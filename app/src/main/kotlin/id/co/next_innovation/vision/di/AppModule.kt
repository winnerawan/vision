package id.co.next_innovation.vision.di

import dagger.Module

@Module(includes = [DatabaseModule::class, NetworkModule::class, ViewModelModule::class])
internal object AppModule {
    // If you need.
}