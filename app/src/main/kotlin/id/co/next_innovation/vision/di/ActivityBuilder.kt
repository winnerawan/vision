package id.co.next_innovation.vision.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.co.next_innovation.vision.ui.main.MainActivity

@Module
internal abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [MainModule::class])
    internal abstract fun contributeMainInjector(): MainActivity
}
