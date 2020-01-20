package com.wisdom.dialogapplication.ui

import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.wisdom.dialogapplication.R
import com.wisdom.dialogapplication.adapt.MyFragmentAdapt
import com.wisdom.dialogapplication.fragment.FragmentBlue
import com.wisdom.dialogapplication.fragment.FragmentYellow

class FragmentDemoActivity : BaseActivity(), View.OnClickListener {

    private lateinit var txtChannel: TextView
    private lateinit var txtMessage: TextView
    private lateinit var fragmentList: ArrayList<Fragment>
    private lateinit var myFragmentAdapt: MyFragmentAdapt
    private lateinit var vpContainer: ViewPager

    override fun onCreateActivity() {
        setContentView(R.layout.activity_fragment_demo)
    }

    override fun initWidget() {
        txtChannel = findViewById(R.id.txt_channel)
        txtMessage = findViewById(R.id.txt_message)

        vpContainer = findViewById(R.id.vp_container)
        fragmentList = arrayListOf()
        fragmentList.add(FragmentBlue())
        fragmentList.add(FragmentYellow())
        myFragmentAdapt = MyFragmentAdapt(supportFragmentManager, fragmentList)
        vpContainer.adapter = myFragmentAdapt

    }

    override fun initData() {
    }

    override fun setListener() {
        txtChannel.setOnClickListener(this)
        txtMessage.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            txtChannel ->
                vpContainer.currentItem = 0

            txtMessage ->
                vpContainer.currentItem = 1
        }
    }

}


