package com.wisdom.dialogapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.wisdom.dialogapplication.R


/**
 * @description: 信息fragment
 * @author: Felix J
 * @time: 2020/1/20 8:50
 */
class MsgFragment : Fragment(), View.OnClickListener {

    private lateinit var btnMsg: Button

    interface BtnMsgListener {
        fun onMsgBtnClick()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_msg, container, false)
        btnMsg = view.findViewById(R.id.btn_msg)
        btnMsg.setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        //若实现了这个接口，就可以把事件交给Activity来做
        if (activity is BtnMsgListener) {
            (activity as BtnMsgListener).onMsgBtnClick()
        }
    }
}