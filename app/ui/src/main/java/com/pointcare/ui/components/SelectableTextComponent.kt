package com.pointcare.ui.components

import android.content.Context
import com.pointcare.ui.base.ManagedController
import com.pointcare.ui.databinding.ComponentSelectableTextBinding

class SelectableTextComponent(context: Context):
    ManagedController<ComponentSelectableTextBinding>(context) {

    init {
        mBinding = ComponentSelectableTextBinding.inflate(getInflater())
        mBinding.reference.setOnClickListener { onClick() }
        setView(mBinding.root)
    }

    fun setChecked(checked: Boolean) {
        mBinding.reference.isChecked = checked
    }

    fun setText(string: String) {
        mBinding.reference.text = string
    }

    private fun onClick() {
        mBinding.reference.isChecked = !mBinding.reference.isChecked
    }
}