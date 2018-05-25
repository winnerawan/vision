package id.co.next_innovation.vision

import android.content.Context
import android.support.multidex.MultiDex
import com.androidnetworking.AndroidNetworking
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication;
import id.co.next_innovation.vision.di.DaggerAppComponent
import id.co.next_innovation.vision.di.DatabaseModule
import id.co.next_innovation.vision.di.NetworkModule
import okhttp3.OkHttpClient
import timber.log.Timber

open class Vision : DaggerApplication() {

    lateinit var androidInjector: AndroidInjector<out DaggerApplication>

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
        androidInjector = DaggerAppComponent.builder()
                .application(this)
                .database(databaseModule())
                .network(networkModule())
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        initTimber()
        initThreeTenABP()
        initAndroidNetworking()
    }

    public override fun applicationInjector(): AndroidInjector<out DaggerApplication> = androidInjector

    protected open fun databaseModule(): DatabaseModule = DatabaseModule()

    protected open fun networkModule(): NetworkModule = NetworkModule()

    protected open fun initTimber() = Timber.plant()

    protected open fun initThreeTenABP() = AndroidThreeTen.init(this)

    protected open fun initOkHttp3(): OkHttpClient = OkHttpClient().newBuilder()
            .addNetworkInterceptor(StethoInterceptor()).build()

    protected open fun initAndroidNetworking() = AndroidNetworking.initialize(this, initOkHttp3())


}