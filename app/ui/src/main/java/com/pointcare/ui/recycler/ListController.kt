package com.pointcare.ui.recycler

import android.content.Context
import android.view.View
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.IAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.pointcare.ui.base.ManagedController
import com.pointcare.ui.databinding.ComponentRecyclerViewBinding
import com.pointcare.ui.databinding.ViewTextInputBinding
import com.pointcare.ui.recycler.items.SelectableTextItem
import kotlinx.android.synthetic.main.component_text_title.view.*
import kotlinx.android.synthetic.main.view_text_input.view.*

abstract class ListController(context: Context) :
    ManagedController<ComponentRecyclerViewBinding>(context) {

    private val mListenerList: ArrayList<Any> = arrayListOf()

    init {
        mBinding = ComponentRecyclerViewBinding.inflate(getInflater())
        setView(mBinding.root)
    }

    fun <Item : GenericItem> updateAdapter(adapter: IAdapter<Item>) {
        mBinding.root.adapter = FastAdapter.with(adapter)
    }
}