package id.co.next_innovation.vision.data.repository

import id.co.next_innovation.vision.data.local.room.DeviceEntity
import io.reactivex.Completable
import io.reactivex.Single

interface Device {
    fun save(device: DeviceEntity): Completable
    fun get(): Single<DeviceEntity>
}