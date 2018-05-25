package id.co.next_innovation.vision.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [RepositoryModule::class])
interface ViewModelModule {
    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

//    @Binds
//    @IntoMap
//    @ViewModelKey(HomeViewModel::class)
//    fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel
}