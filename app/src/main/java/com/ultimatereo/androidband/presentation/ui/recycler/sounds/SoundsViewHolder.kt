package com.ultimatereo.androidband.presentation.ui.recycler.sounds

import androidx.recyclerview.widget.RecyclerView
import com.ultimatereo.androidband.presentation.ui.customviews.SoundView
import com.ultimatereo.androidband.presentation.ui.vo.SoundVo

class SoundsViewHolder(
    val view: SoundView
) : RecyclerView.ViewHolder(view) {

    fun bind(vo: SoundVo) {
        view.bind(vo)
    }
}