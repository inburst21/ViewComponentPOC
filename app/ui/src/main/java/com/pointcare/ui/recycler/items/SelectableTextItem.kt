package com.pointcare.ui.recycler.items

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import com.pointcare.ui.databinding.ComponentSelectableTextBinding
import com.pointcare.ui.recycler.ItemTypes

class SelectableTextItem(val string: String, var checked: Boolean): AbstractBindingItem<ComponentSelectableTextBinding>() {

    override val type: Int
        get() = ItemTypes.SELECTABLE_TEXT.ordinal

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): ComponentSelectableTextBinding {
        return ComponentSelectableTextBinding.inflate(inflater, parent, false)
    }

    override fun bindView(binding: ComponentSelectableTextBinding, payloads: List<Any>) {
        binding.reference.text = string
        binding.reference.isChecked = checked
        binding.reference.setOnClickListener {
            checked = !checked
            binding.reference.isChecked = checked
        }
    }

    override fun toString(): String {
        return string
    }
}