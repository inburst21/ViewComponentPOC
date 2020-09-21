package com.pointcare.ui.base

import android.content.Context
import androidx.viewbinding.ViewBinding

abstract class ManagedController<T : ViewBinding>(context: Context) : BaseController(context) {
    protected lateinit var mBinding: T
    fun getBinding() = mBinding
}