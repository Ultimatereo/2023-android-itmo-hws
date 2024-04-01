package com.ultimatereo.androidband.presentation.ui.recycler.sounds

import androidx.recyclerview.widget.RecyclerView
import com.ultimatereo.androidband.presentation.ui.customviews.SoundsMenuCategoryView

class SoundsMenuCategoryViewHolder(val view: SoundsMenuCategoryView) :
    RecyclerView.ViewHolder(view) {

    fun bind(category: SoundsMenuCategory) {
        view.bind(category)
    }
}
