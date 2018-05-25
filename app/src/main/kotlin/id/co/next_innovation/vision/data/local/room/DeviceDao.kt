package id.co.next_innovation.vision.data.local.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Single

@Dao
interface DeviceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(device: DeviceEntity): Long

    @Query("SELECT * FROM Device")
    fun get(): Single<DeviceEntity>
}