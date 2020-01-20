package com.wisdom.dialogapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.wisdom.dialogapplication.R


/**
 * @description: 电话Fragment
 * @author: Felix J
 * @time: 2020/1/20 9:00
 */
class CallFragment : Fragment(), View.OnClickListener {

    private lateinit var btnCall: Button

    //private lateinit var btnCallListener: BtnCallListener

    interface BtnCallListener {
        fun onBtnCallClick()
    }

    /*//显式设置
    fun setBtnCallListener(btnCallListener: BtnCallListener) {
        this.btnCallListener = btnCallListener
    }*/


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_call, container, false)
        btnCall = view.findViewById(R.id.btn_call)
        btnCall.setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        //若实现了这个接口，就可以用，把事件交给Activity来做
        if (activity is BtnCallListener) {
            (activity as BtnCallListener).onBtnCallClick()
        }
    }
}