package com.ultimatereo.androidband.domain.audio.visualizer

interface AudioVisualizer {
    fun init()
    fun getWaveForm(): Int
    fun getWaveFormArr(): List<Int>
}