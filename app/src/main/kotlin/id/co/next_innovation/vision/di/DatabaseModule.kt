package id.co.next_innovation.vision.di

import android.arch.persistence.room.Room
import dagger.Module
import dagger.Provides
import id.co.next_innovation.vision.Vision
import id.co.next_innovation.vision.data.local.room.AppDatabase
import id.co.next_innovation.vision.data.local.room.DeviceDao
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(app: Vision): AppDatabase {
        return Room.databaseBuilder(app, AppDatabase::class.java, "vision.db")
                .fallbackToDestructiveMigration()
                .build()
    }

    @Provides
    @Singleton
    fun provideDeviceDao(db: AppDatabase): DeviceDao = db.deviceDao
}