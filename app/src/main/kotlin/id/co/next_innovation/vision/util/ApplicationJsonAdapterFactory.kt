package id.co.next_innovation.vision.util

import com.squareup.moshi.JsonAdapter
import se.ansman.kotshi.KotshiJsonAdapterFactory

/**
 * @link https://github.com/ansman/kotshi
 */

@KotshiJsonAdapterFactory
abstract class ApplicationJsonAdapterFactory : JsonAdapter.Factory {
    companion object {
        val INSTANCE: ApplicationJsonAdapterFactory = KotshiApplicationJsonAdapterFactory()
    }
}