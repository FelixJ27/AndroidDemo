package com.wisdom.dialogapplication.ui

import android.app.AlertDialog
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.fasterxml.jackson.databind.ObjectMapper
import com.wisdom.dialogapplication.R
import com.wisdom.dialogapplication.param.RespData
import com.wisdom.dialogapplication.param.User
import com.wisdom.util.AlertDialogUtil
import okhttp3.*
import java.io.IOException


class MainActivity : BaseActivity(), View.OnClickListener {

    private lateinit var btnShow: Button
    private lateinit var btnCustom: Button
    private lateinit var scanDialog: AlertDialog
    private var scanBuilder: AlertDialog.Builder? = null
    private lateinit var scanView: View
    private var dialog: AlertDialogUtil? = null
    private lateinit var btnFragment: Button
    private lateinit var btnDynamicFragment: Button
    private lateinit var btnGet: Button
    private lateinit var btnPost: Button
    val client = OkHttpClient()

    override fun onCreateActivity() {
        setContentView(R.layout.activity_main)
    }

    override fun initWidget() {
        btnShow = findViewById(R.id.btn_show)
        btnCustom = findViewById(R.id.btn_custom)
        btnFragment = findViewById(R.id.btn_fragment)
        scanBuilder = AlertDialog.Builder(this)
        val inflater = this.layoutInflater
        scanView = inflater.inflate(R.layout.alert_dialog_scan, null, false)
        scanBuilder!!.setView(scanView)
        scanBuilder!!.setCancelable(false)
        scanDialog = scanBuilder!!.create()
        setCorner()

        btnDynamicFragment = findViewById(R.id.btn_dynamic_fragment)
        btnGet = findViewById(R.id.btn_get)
        btnPost = findViewById(R.id.btn_post)
    }

    override fun initData() {}

    override fun onClick(v: View?) {
        when (v) {
            btnShow -> {
                dialog = AlertDialogUtil.Builder(this)
                    .setTitle("通用弹窗")
                    .setMessage("漂亮的对话框")
                    .setOnConfirmClickListener("确定") {
                        testDismissMethod(this.dialog!!)
                    }
                    .setOnCancelClickListener("取消") {
                        if (dialog != null) {
                            dialog!!.dismiss()
                        }
                    }
                    .build()
                    .shown()
            }
            btnGet -> {
                val request = Request.Builder()
                    .get()
                    .tag(this)
                    .url("http://www.192.168.102.98.org")
                    .build()
                Thread(Runnable {
                    var response: Response? = null
                    try {
                        response = client.newCall(request).execute()
                        if (response!!.isSuccessful) {
                            Log.i("WY", "打印GET响应的数据：" + response!!.body()?.string())
                        } else {
                            throw IOException("Unexpected code " + response!!)
                        }
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }).start()
            }

            btnPost -> {
                //创建OkHttpClient对象
                val client = OkHttpClient()
                //数据类型为json格式
                val JSON = MediaType.parse("application/json; charset=utf-8")
                //json数据
                val objectMapper = ObjectMapper()
                val user = User("张三", "370211111111111111")
                //val jsonStr = "{\"username\":\"张三\",\"nickname\":\"李四\"}"
                val jsonStr = objectMapper.writeValueAsString(user)
                val body = RequestBody.create(JSON, jsonStr)
                val request = Request.Builder()
                    .url("http://192.168.89.6:8080/testPost")
                    .post(body)
                    .build()
                client.newCall(request).enqueue(object : Callback {
                    override fun onFailure(call: Call, e: IOException) {
                        Log.i("网络异常", "请检查网络")
                    }

                    @Throws(IOException::class)
                    override fun onResponse(call: Call, response: Response) {
                        val result = response.body()?.string()
                        Log.i("result = ",result)
                        val returnJson = objectMapper.readValue(result, RespData::class.java)
                        //val jo = JSONObject(result)
                        if (returnJson.returnCode == 200) {
                            
                            Toast.makeText(this@MainActivity, returnJson.returnMsg, Toast.LENGTH_LONG)
                        } else {
                            Toast.makeText(this@MainActivity, returnJson.returnMsg, Toast.LENGTH_LONG)
                        }
                    }
                })
            }
        }
    }

    override fun setListener() {
        btnShow.setOnClickListener(this)
        btnCustom.setOnClickListener {
            scanDialog.show()
            scanView.findViewById<Button>(R.id.btn_cancel).setOnClickListener {
                scanDialog.dismiss()
            }
            /*     scanBuilder = AlertDialog.Builder(this)
                 scanBuilder?.setPositiveButton("确认") { _, _ ->
                     Toast.makeText(this, "点击了确认按钮", Toast.LENGTH_LONG)
                 }
                 scanBuilder?.setNegativeButton("取消") { _,_ ->
                     Toast.makeText(this, "点击了取消按钮", Toast.LENGTH_LONG)
                 }
                 scanDialog = scanBuilder!!.create()
                 scanDialog.show()*/
        }

        btnFragment.setOnClickListener {
            startActivity(Intent(this, FragmentDemoActivity::class.java))
        }

        btnDynamicFragment.setOnClickListener {
            startActivity(Intent(this, DynamicFragmentActivity::class.java))
        }

        btnGet.setOnClickListener(this)
        btnPost.setOnClickListener(this)
    }

    private fun setCorner() {
        val scanWindow = scanDialog.window
        scanWindow!!.setBackgroundDrawable(BitmapDrawable())
    }

    /**
     * @description
     * @author Felix J
     * @time 2020/1/14 11:05
     */
    private fun testDismissMethod(dialog: AlertDialogUtil) {

    }

    private fun testDialog() {

    }
}
