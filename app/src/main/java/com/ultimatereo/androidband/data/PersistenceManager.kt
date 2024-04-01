package com.ultimatereo.androidband.data

import com.ultimatereo.androidband.data.db.QuickSoundDao
import com.ultimatereo.androidband.data.db.QuickSoundsEntity
import com.ultimatereo.androidband.data.db.SampleDao
import com.ultimatereo.androidband.data.db.SampleEntity
import com.ultimatereo.androidband.domain.audio.samples.SampleManager
import com.ultimatereo.androidband.domain.audio.sounds.QuickSoundsManager
import com.ultimatereo.androidband.domain.viewmodels.AbstractCoroutineManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.withContext

class PersistenceManager(
    private val sampleDao: SampleDao,
    private val sampleManager: SampleManager,
    private val soundsDataStore: SoundsDataStore,
    private val quickSoundsManager: QuickSoundsManager,
    private val quickSoundDao: QuickSoundDao,
) : AbstractCoroutineManager() {

    fun load() {
        launchScope(this) {
            withContext(Dispatchers.IO) {
                soundsDataStore.updateSoundsSync()
                sampleDao.getAll().forEach { entity ->
                    sampleManager.addSample(entity.soundId, entity.name, entity.sampleId)
                    ensureActive()
                }
                quickSoundDao.getById(QuickSoundsEntity.RECORD_ID_VALUE)?.run {
                    quickSoundsManager.setQuickSound(soundIdOne)
                    quickSoundsManager.setQuickSound(soundIdTwo)
                    quickSoundsManager.setQuickSound(soundIdThree)
                    quickSoundsManager.setQuickSound(soundIdFour)
                }
            }
        }
    }

    fun save() {
        launchScope(this) {
            withContext(Dispatchers.IO) {
                sampleDao.deleteAll()
                sampleManager.getAllSamples().mapIndexed { index, sampleVo ->
                    SampleEntity(
                        sampleVo.sampleId,
                        sampleVo.soundId,
                        sampleVo.name,
                        index
                    )
                }.let { samples -> sampleDao.insertAll(samples) }

                quickSoundsManager.sounds.value.let { quickSounds ->
                    quickSoundDao.insert(
                        QuickSoundsEntity(
                            recordId = QuickSoundsEntity.RECORD_ID_VALUE,
                            soundIdOne = quickSounds[0],
                            soundIdTwo = quickSounds[1],
                            soundIdThree = quickSounds[2],
                            soundIdFour = quickSounds[3],
                        )
                    )
                }
            }
        }
    }
}