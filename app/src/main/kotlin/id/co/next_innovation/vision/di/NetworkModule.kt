package id.co.next_innovation.vision.di

import com.androidnetworking.AndroidNetworking
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import id.co.next_innovation.vision.BuildConfig.HTTPS
import id.co.next_innovation.vision.BuildConfig.VISION_ENDPOINT
import id.co.next_innovation.vision.Vision
import id.co.next_innovation.vision.di.Qualifiers.VISION
import id.co.next_innovation.vision.util.ApplicationJsonAdapterFactory
import id.co.next_innovation.vision.util.InstantAdapter
import id.co.next_innovation.vision.util.Memory
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
open class NetworkModule {

    open fun buildOkHttpClient(app: Vision): OkHttpClient =
            OkHttpClient.Builder()
                    .connectTimeout(10L, TimeUnit.SECONDS)
                    .writeTimeout(10L, TimeUnit.SECONDS)
                    .readTimeout(30L, TimeUnit.SECONDS)
                    .cache(Cache(File(app.cacheDir, "OkCache"),
                            Memory.calcCacheSize(app, .25f)))
                    .build()

    @Provides
    @Singleton
    fun provideOkHttpClient(app: Vision): OkHttpClient = buildOkHttpClient(app)

    @Singleton
    @Provides
    fun provideMoshi() = Moshi.Builder()
            .add(ApplicationJsonAdapterFactory.INSTANCE)
            .add(InstantAdapter.INSTANCE)
            .build()

    @Provides
    @Singleton
    @Named(VISION)
    fun provideRetrofitForVision(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit = Retrofit.Builder()
            .baseUrl("$HTTPS://$VISION_ENDPOINT")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

//    @Provides
//    @Singleton
//    fun providePlanetService(@Named(VISION) retrofit: Retrofit): PlanetService =
//            retrofit.create(PlanetService::class.java)
}