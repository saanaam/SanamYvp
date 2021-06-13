package com.sanam.yavarpour.common

import androidx.recyclerview.widget.DiffUtil


interface RecyclerItemView : PresentationModel {
    fun contentEquals(old: RecyclerItemView): Boolean

    companion object {
        fun <T : RecyclerItemView> DiffCallback(): DiffUtil.ItemCallback<T> {
            return object : DiffUtil.ItemCallback<T>() {
                override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
                    return oldItem == newItem
                }

                override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
                    return newItem.contentEquals(oldItem)
                }

            }
        }
    }
}