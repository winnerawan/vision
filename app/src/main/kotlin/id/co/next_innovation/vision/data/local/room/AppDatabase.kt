package id.co.next_innovation.vision.data.local.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import id.co.next_innovation.vision.BuildConfig


@Database(
        entities = [DeviceEntity::class],
        version = BuildConfig.DB_SCHEMA_VERSION,
        // TODO
        exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract val deviceDao: DeviceDao
}