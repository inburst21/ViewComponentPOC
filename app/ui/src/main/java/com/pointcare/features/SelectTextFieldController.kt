package com.pointcare.features

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.pointcare.ui.base.ManagedController
import com.pointcare.ui.databinding.ViewTextInputBinding
import com.pointcare.ui.dialog.DialogController
import com.pointcare.ui.recycler.items.SelectableTextItem

class SelectTextFieldController(context: Context) :
    ManagedController<ViewTextInputBinding>(context) {
    private val mController = SelectableItemListController(context)
    private val mDialog = DialogController(context)

    init {
        mBinding = ViewTextInputBinding.inflate(getInflater())
        setView(mBinding.root)
        mBinding.reference.setOnClickListener { onClick() }

        mDialog.setDialogView(mController.getView())
        setList(mockList)
    }

    fun observe(lifecycleOwner: LifecycleOwner) {
        mDialog.getState().observe(lifecycleOwner, {
            if (it == true) {
                val updatedText = mController.getSelectedItems().toString()
                mBinding.reference.setText(updatedText.subSequence(1, updatedText.length - 1))
            }
        })
    }

    private fun onClick() {
        mDialog.show()
    }

    private fun setList(list: List<SelectableTextItem>) {
        mController.setList(list)
    }
}

val mockList = listOf(
    SelectableTextItem("Test", true),
    SelectableTextItem("Test", true),
    SelectableTextItem("Test", false),
    SelectableTextItem("Test", true),
    SelectableTextItem("Test", true),
    SelectableTextItem("Test", true),
    SelectableTextItem("Test", false),
    SelectableTextItem("Test", true),
    SelectableTextItem("Test", true)
)