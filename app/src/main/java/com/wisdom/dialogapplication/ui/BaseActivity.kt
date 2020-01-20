package com.wisdom.dialogapplication.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
 * @description: 父activity
 * @author: Felix J
 * @time: 2020/1/10 14:37
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateActivity()
        initWidget()
        initData()
        setListener()
    }

    /**
     * 创建activity
     */
    protected abstract fun onCreateActivity()
    /**
     * 初始化控件
     */

    protected abstract fun initWidget()
    /**
     * 初始化数据
     */
    protected abstract fun initData()

    /**
     * 监听
     */
    protected abstract fun setListener()
}