package com.pointcare.ui.toolbar

import android.content.Context
import com.pointcare.ui.base.ManagedController
import com.pointcare.ui.databinding.ViewToolbarHeaderBinding

class HeaderToolbarController(context: Context) :
    ManagedController<ViewToolbarHeaderBinding>(context) {

    init {
        mBinding = ViewToolbarHeaderBinding.inflate(getInflater())
        setView(mBinding.root)
        setTitle("Testt Tile")
    }

    fun setTitle(string: String) {
        mBinding.title.reference.text = string
    }
}