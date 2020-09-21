package com.pointcare.ui.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.pointcare.service.ResourceManager

abstract class BaseController(context: Context) {
    private val mInflater = LayoutInflater.from(context)!!
    private val mViewHandler = ViewController(context)
    private val mResourceManager = ResourceManager(context)

    protected fun getViewManager() = mViewHandler
    protected fun getResources() = mResourceManager
    protected fun getInflater() = mInflater
    protected fun setView(view: View) { mViewHandler.setView(view) }
    fun getView() = mViewHandler.getView()
    fun addController(controller: BaseController) { mViewHandler.addView(controller) }
}