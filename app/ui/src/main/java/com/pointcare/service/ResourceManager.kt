package com.pointcare.service

import android.content.Context
import androidx.annotation.*
import androidx.core.content.res.ResourcesCompat

class ResourceManager(context: Context) {
    private val resources = context.resources
    fun getColor(@ColorRes color: Int) = resources.getColor(color).toInt()
    fun getDimen(@DimenRes dimen: Int) = resources.getDimension(dimen).toInt()
    fun getString(@StringRes string: Int) = resources.getString(string)
    fun getBoolean(@BoolRes boolean: Int) = resources.getBoolean(boolean)
    fun getDrawable(@DrawableRes drawable: Int) = ResourcesCompat.getDrawable(resources, drawable, null)
}