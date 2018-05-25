package id.co.next_innovation.vision.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import id.co.next_innovation.vision.Vision
import id.co.next_innovation.vision.util.GlideModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AndroidSupportInjectionModule::class,
            ActivityBuilder::class,
            AppModule::class
        ])

interface AppComponent : AndroidInjector<Vision> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Vision): Builder

        fun database(database: DatabaseModule): Builder

        fun network(network: NetworkModule): Builder

        fun build(): AppComponent
    }

    override fun inject(app: Vision)

    fun inject(glideModule: GlideModule)
}