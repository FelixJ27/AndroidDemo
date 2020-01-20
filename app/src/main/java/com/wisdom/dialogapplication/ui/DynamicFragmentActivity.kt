package com.wisdom.dialogapplication.ui

import android.widget.Button
import com.wisdom.dialogapplication.R
import com.wisdom.dialogapplication.fragment.CallFragment
import com.wisdom.dialogapplication.fragment.MsgFragment

class DynamicFragmentActivity : BaseActivity(), MsgFragment.BtnMsgListener,CallFragment.BtnCallListener {

    private lateinit var btnClick: Button
    private lateinit var msgFragment: MsgFragment
    private lateinit var callFragment: CallFragment

    override fun onCreateActivity() {
        setContentView(R.layout.activity_dynamic_fragment)
    }

    override fun initWidget() {
        btnClick = findViewById(R.id.btnClick)
        msgFragment = MsgFragment()
        callFragment = CallFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragment_content, msgFragment, "MSG")
        fragmentTransaction.commit()

    }

    override fun initData() {
    }

    override fun setListener() {
        btnClick.setOnClickListener {
            this.finish()
        }
    }

    override fun onMsgBtnClick() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_content, callFragment, "CALL")
        //回退栈，加了后点击返回键可以返回到上一个fragment
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun onBtnCallClick() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_content, msgFragment, "MSG")
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

}
