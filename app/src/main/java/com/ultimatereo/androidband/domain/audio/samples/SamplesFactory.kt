package com.ultimatereo.androidband.domain.audio.samples

interface SamplesFactory {
    fun getSample(soundId: Int, name: String, sampleId: Int): Sample
}

