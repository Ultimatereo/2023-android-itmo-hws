package com.ultimatereo.androidband.presentation.ui.vo

import androidx.annotation.DrawableRes
import androidx.annotation.MenuRes
import com.ultimatereo.androidband.domain.audio.sounds.SoundType

data class SoundVo(
    val soundId: Int,
    val name: String,
    @DrawableRes val icon: Int,
    @MenuRes val menu: Int,
    val type: SoundType,
    val checked: Boolean,
)