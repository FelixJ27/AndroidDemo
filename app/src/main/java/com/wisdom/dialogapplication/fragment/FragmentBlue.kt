package com.wisdom.dialogapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.wisdom.dialogapplication.R

/**
 * @description: fragment1-blue
 * @author: Felix J
 * @time: 2020/1/15 10:23
 */
class FragmentBlue : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_blue, container, false)
    }

    /**
     * @description 可对控件进行操作
     * @author Felix J
     * @time 2020/1/19 10:48
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val txtTip = view.findViewById<TextView>(R.id.txt_tip)
    }
}