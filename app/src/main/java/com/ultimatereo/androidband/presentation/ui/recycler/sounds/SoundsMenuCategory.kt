package com.ultimatereo.androidband.presentation.ui.recycler.sounds

import com.ultimatereo.androidband.domain.audio.sounds.SoundType
import com.ultimatereo.androidband.presentation.ui.vo.SoundVo

data class SoundsMenuCategory(val category: SoundType, val sounds: List<SoundVo>)