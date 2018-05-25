package id.co.next_innovation.vision.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.webkit.WebView
import id.co.next_innovation.vision.Vision
import id.co.next_innovation.vision.data.local.room.DeviceEntity
import id.co.next_innovation.vision.data.repository.DeviceRepository
import id.co.next_innovation.vision.util.Result
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import id.co.next_innovation.vision.util.defaultErrorHandler;
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

class DeviceViewModel @Inject constructor(
        private val app: Vision,
        private val repo: DeviceRepository
) : ViewModel() {

    private val disposable: CompositeDisposable = CompositeDisposable()

    private val _deviceInfo: MutableLiveData<Result<DeviceEntity>> = MutableLiveData()
    val deviceInfo: LiveData<Result<DeviceEntity>> = _deviceInfo

    private val deviceId: String by lazy {
        UUID.randomUUID().toString()
        // AdvertisingIdClient.getAdvertisingIdInfo(app).id
    }

    private val userAgent: String by lazy { WebView(app).settings.userAgentString }

    init {
        val entity = DeviceEntity(deviceId = deviceId, userAgent = userAgent)
        repo.get()
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext { repo.save(entity).toSingleDefault(entity) }
                .subscribeBy(
                        onError = defaultErrorHandler(),
                        onSuccess = { _deviceInfo.postValue(Result.success(it)) }
                )
                .addTo(disposable)
    }

    fun save(device: DeviceEntity) {
        repo.save(device)
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onError = defaultErrorHandler(),
                        onComplete = { _deviceInfo.postValue(Result.success(device)) }
                ).addTo(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}