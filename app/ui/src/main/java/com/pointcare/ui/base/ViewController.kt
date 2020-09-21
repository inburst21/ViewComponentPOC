package com.pointcare.ui.base

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.core.view.children
import androidx.core.view.marginStart
import androidx.core.view.setPadding
import com.pointcare.ui.databinding.ViewBaseLayoutFullBinding
import com.pointcare.ui.exceptions.ControllerBoundException

class ViewController(context: Context) {
    private val mViewBinding = ViewBaseLayoutFullBinding.inflate(LayoutInflater.from(context))


    fun addView(baseController: BaseController) {
        if (!getView().children.contains(baseController.getView())) {
            mViewBinding.root.addView(baseController.getView())
        } else throw ControllerBoundException()
    }

    fun removeView(baseController: BaseController) {
        if (getView().children.contains(baseController.getView())) {
            getView().removeView(baseController.getView())
        }
    }

    fun setView(view: View) {
        getView().removeAllViews()
        getView().addView(view)
    }

    fun getView() = mViewBinding.root

    fun setBackgroundColor(view: ViewGroup, color: ColorDrawable) {
        view.background = color
        for (child: View in view.children) {
            child.background = color
        }
    }
}

interface LayoutControls {
    fun setLayoutSize(width: Int, height: Int)
    fun setBackgroundColor(color: ColorDrawable)
    fun setElevation(elevation: Float)
    fun setGravity(gravity: Int)
    fun setPadding(padding: Int)
}

class ViewStateController(mViewBinding: ViewBaseLayoutFullBinding) : LayoutControls {
    private var mView = mViewBinding


    override fun setLayoutSize(width: Int, height: Int) {
        mView.root.layoutParams = ViewGroup.LayoutParams(width, height)
    }

    override fun setBackgroundColor(color: ColorDrawable) {
        mView.root.background = color
    }

    override fun setElevation(elevation: Float) {
        mView.root.elevation = elevation
    }

    override fun setGravity(gravity: Int) {
        mView.root.textAlignment = gravity
    }

    override fun setPadding(padding: Int) {
        mView.root.setPadding(padding, padding, padding, padding)
    }
}