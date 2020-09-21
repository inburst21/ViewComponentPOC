package com.pointcare.ui.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import com.pointcare.ui.R
import com.pointcare.ui.base.ManagedController
import com.pointcare.ui.databinding.ViewConfirmationDialogBinding


open class DialogController(context: Context) :
    ManagedController<ViewConfirmationDialogBinding>(context) {
    private val state = MutableLiveData(false)
    private var dialog = Dialog(context)
    private val color = ColorDrawable(getResources().getColor(R.color.transparent))

    init {
        mBinding = ViewConfirmationDialogBinding.inflate(getInflater())
        mBinding.footer.cancelButton.reference.setOnClickListener { dialog.show() }
        mBinding.footer.confirmButton.reference.setOnClickListener { onConfirm() }
        setView(mBinding.root)
        dialog.setContentView(getView())
        setTitle("Title Text")
        setPositiveButtonText(getResources().getString(R.string.ok))
        setNegativeButtonText(getResources().getString(R.string.cancel))
    }

    fun show() {
        dialog.show()
    }

    fun setDialogView(view: ViewGroup) {
        mBinding.content.removeAllViews()
        addDialogView(view)
    }

    private fun addDialogView(view: ViewGroup) {
        getViewManager().setBackgroundColor(view, color)
        mBinding.content.addView(view)
    }

    fun setTitle(string: String) {
        mBinding.header.title.reference.text = string
    }

    private fun setNegativeButtonText(string: String) {
        mBinding.footer.cancelButton.reference.text = string
    }

    private fun setPositiveButtonText(string: String) {
        mBinding.footer.confirmButton.reference.text = string
    }

    private fun onConfirm() {
        state.value = true
        dialog.dismiss()
    }

    fun getState() = state
}