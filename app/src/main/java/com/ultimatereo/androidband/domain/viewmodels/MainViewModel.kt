package com.ultimatereo.androidband.domain.viewmodels

import com.ultimatereo.androidband.domain.audio.capture.CaptureRepository
import com.ultimatereo.androidband.presentation.framework.PermissionManager
import com.ultimatereo.androidband.presentation.framework.PermissionRequest
import kotlinx.coroutines.flow.Flow

class MainViewModel(
    private val captureRepository: CaptureRepository,
    private val permissionManager: PermissionManager,
) : CoroutineViewModel() {

    fun observePermissionRequests(): Flow<PermissionRequest> {
        return permissionManager.permissionRequests
    }

    fun onPermissionRequestResult(requestId: Int, granted: Boolean) {
        permissionManager.onPermissionResult(requestId, granted)
    }

    fun onStartCapturing() {
        captureRepository.startCapturing()
    }
}