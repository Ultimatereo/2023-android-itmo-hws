package com.ultimatereo.androidband.presentation.ui.recycler.waves

import androidx.recyclerview.widget.RecyclerView
import com.ultimatereo.androidband.presentation.ui.customviews.WaveUnitView
import com.ultimatereo.androidband.presentation.ui.vo.WaveUnitVo

class WaveUnitViewHolder(val view: WaveUnitView) : RecyclerView.ViewHolder(view) {
    fun bind(vo: WaveUnitVo) {
        view.bind(vo)
    }
}