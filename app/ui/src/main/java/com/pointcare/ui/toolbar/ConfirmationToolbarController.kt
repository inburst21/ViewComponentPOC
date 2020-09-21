package com.pointcare.ui.toolbar

import android.content.Context
import com.pointcare.ui.R
import com.pointcare.ui.base.ManagedController
import com.pointcare.ui.databinding.ViewToolbarConfirmationBinding

class ConfirmationToolbarController(context: Context) :
    ManagedController<ViewToolbarConfirmationBinding>(context) {

    init {
        mBinding = ViewToolbarConfirmationBinding.inflate(getInflater())
        mBinding.cancelButton.reference.text = getResources().getString(R.string.cancel)
        mBinding.confirmButton.reference.text = getResources().getString(R.string.ok)
        setView(mBinding.root)
    }

    private fun setNegativeText(string: String) {
        mBinding.cancelButton.reference.text = string
    }

    private fun setPositiveText(string: String) {
        mBinding.cancelButton.reference.text = string
    }
}