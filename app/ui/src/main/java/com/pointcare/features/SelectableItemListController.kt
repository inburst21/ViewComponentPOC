package com.pointcare.features

import android.content.Context
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.pointcare.ui.recycler.ListController
import com.pointcare.ui.recycler.items.SelectableTextItem

class SelectableItemListController(context: Context) : ListController(context) {
    private val adapter = ItemAdapter<SelectableTextItem>()

    init {
        updateAdapter(adapter)
    }

    fun setList(list: List<SelectableTextItem>) {
        adapter.set(list)
    }

    fun getList() = adapter.adapterItems
    fun getSelectedItems() = adapter.adapterItems.filter { it.checked }
}