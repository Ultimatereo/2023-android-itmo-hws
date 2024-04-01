package com.ultimatereo.androidband.domain.audio.sequencer.dto

import com.ultimatereo.androidband.presentation.ui.vo.SampleVo

data class SequenceRecord(
    val initialState: List<SampleVo>,
    val events: List<SequenceEvent>,
)