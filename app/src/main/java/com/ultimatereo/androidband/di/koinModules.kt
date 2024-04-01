package com.ultimatereo.androidband.di

import com.ultimatereo.androidband.data.PersistenceManager
import com.ultimatereo.androidband.data.SoundsDataStore
import com.ultimatereo.androidband.data.db.AppDatabase
import com.ultimatereo.androidband.domain.audio.capture.CaptureRepository
import com.ultimatereo.androidband.domain.audio.samples.SampleManager
import com.ultimatereo.androidband.domain.audio.samples.SampleVoFormatter
import com.ultimatereo.androidband.domain.audio.samples.SamplesFactory
import com.ultimatereo.androidband.domain.audio.samples.SamplesRepository
import com.ultimatereo.androidband.domain.audio.sequencer.SampleFrameMapper
import com.ultimatereo.androidband.domain.audio.sequencer.SequencePlayer
import com.ultimatereo.androidband.domain.audio.sequencer.SequenceRecorder
import com.ultimatereo.androidband.domain.audio.sequencer.SequenceRenderer
import com.ultimatereo.androidband.domain.audio.sounds.GetSoundsCategoriesUseCase
import com.ultimatereo.androidband.domain.audio.sounds.QuickSoundsManager
import com.ultimatereo.androidband.domain.audio.visualizer.AudioVisualizer
import com.ultimatereo.androidband.domain.audio.visualizer.VisualizerRepository
import com.ultimatereo.androidband.domain.interfacestate.ButtonsStateUseCase
import com.ultimatereo.androidband.domain.viewmodels.LibraryFragmentViewModel
import com.ultimatereo.androidband.domain.viewmodels.MainFragmentViewModel
import com.ultimatereo.androidband.domain.viewmodels.MainViewModel
import com.ultimatereo.androidband.presentation.framework.AndroidVisualizer
import com.ultimatereo.androidband.presentation.framework.AssetManager
import com.ultimatereo.androidband.presentation.framework.FilesManager
import com.ultimatereo.androidband.presentation.framework.MicRecordingRepository
import com.ultimatereo.androidband.presentation.framework.PermissionManager
import com.ultimatereo.androidband.presentation.framework.ResourceManager
import com.ultimatereo.androidband.presentation.framework.SamplesFactoryImpl
import com.ultimatereo.androidband.temp.VisViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val koinModule = module {
    single<AudioVisualizer> { AndroidVisualizer(get()) }
    single { PersistenceManager(get(), get(), get(), get(), get()) }
    single { AppDatabase.createDatabase(get()) }
    single { SamplesRepository(get(), get()) }
    single { QuickSoundsManager(get()) }
    single { SoundsDataStore(get(), get()) }
    single { get<AppDatabase>().getSoundDao() }
    single { get<AppDatabase>().getSamplesDao() }
    single { get<AppDatabase>().getQuickSoundDao() }
    single { VisualizerRepository(get()) }
    single { SequenceRecorder() }
    single { SequencePlayer(get(), get()) }
    single { SampleManager(get(), get(), get(), get(), get()) }
    single { SequenceRenderer(get(), get()) }
    single { CaptureRepository() }
    single { PermissionManager(get()) }
    single { MicRecordingRepository(get(), get()) }

    factory<SamplesFactory> { SamplesFactoryImpl(get(), get(), get()) }
    factory { ResourceManager(get()) }
    factory { AssetManager(get(), get(), get()) }
    factory { SampleVoFormatter(get()) }
    factory { SampleFrameMapper() }
    factory { FilesManager(get()) }
    factory { ButtonsStateUseCase(get(), get(), get(), get(), get()) }
    factory { GetSoundsCategoriesUseCase(get(), get()) }
}

val viewModelModule = module {
    viewModel {
        MainFragmentViewModel(
            sampleManager = get(),
            quickSoundsManager = get(),
            visualizerRepository = get(),
            recorder = get(),
            player = get(),
            buttonsStateUseCase = get(),
            sequenceRenderer = get(),
            sampleFrameMapper = get(),
            soundsDataStore = get(),
            captureRepository = get(),
            permissionManager = get(),
            micRecordingRepository = get(),
            resourceManager = get(),
            persistenceManager = get(),
        )
    }

    viewModel {
        MainViewModel(
            captureRepository = get(), permissionManager = get()
        )
    }

    viewModel {
        LibraryFragmentViewModel(
            sampleManager = get(),
            getSoundsCategoriesUseCase = get(),
            quickSoundsManager = get(),
            soundsDataStore = get(),
            resourceManager = get(),
        )
    }

    viewModel {
        VisViewModel(get(), get())
    }
}