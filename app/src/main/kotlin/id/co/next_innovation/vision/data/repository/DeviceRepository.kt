package id.co.next_innovation.vision.data.repository

import id.co.next_innovation.vision.data.local.room.AppDatabase
import id.co.next_innovation.vision.data.local.room.DeviceDao
import id.co.next_innovation.vision.data.local.room.DeviceEntity
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeviceRepository @Inject constructor(
        private val database: AppDatabase,
        private val dao: DeviceDao
) : Device {
    override fun save(device: DeviceEntity): Completable {

        return Completable.create({
            database.runInTransaction { dao.save(device) }
            it.onComplete()
        })
    }

    override fun get(): Single<DeviceEntity> = dao.get()
}