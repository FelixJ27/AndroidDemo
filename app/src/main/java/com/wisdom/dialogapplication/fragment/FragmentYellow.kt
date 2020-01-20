package com.wisdom.dialogapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.wisdom.dialogapplication.R
import kotlinx.android.synthetic.*

/**
 * @description: fragment2-yellow
 * @author: Felix J
 * @time: 2020/1/15 14:09
 */
class FragmentYellow : Fragment() {

    private lateinit var txtTip: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_yellow, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtTip = view.findViewById(R.id.txt_tip)
    }
}