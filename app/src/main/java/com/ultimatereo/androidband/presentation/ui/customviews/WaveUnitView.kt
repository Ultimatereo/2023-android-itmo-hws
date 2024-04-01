package com.ultimatereo.androidband.presentation.ui.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.ultimatereo.androidband.databinding.WaveViewBinding
import com.ultimatereo.androidband.presentation.ui.vo.WaveUnitVo
import com.ultimatereo.androidband.setHeightDp
import java.lang.Float.max

class WaveUnitView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0, defStyleRes: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private val binding = WaveViewBinding.inflate(LayoutInflater.from(context), this, true)

    fun bind(vo: WaveUnitVo) {
        binding.formUnit.setHeightDp(max(vo.form / 256f * 48f, 5f))
    }

    companion object {
        const val LOG_TAG = "WaveUnitView"
    }
}