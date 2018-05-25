package id.co.next_innovation.vision.util

import android.content.Context
import id.co.next_innovation.vision.Vision
import id.co.next_innovation.vision.di.AppComponent

object AppInjection {
    fun of(context: Context?): AppComponent {
        return (context as Vision).applicationInjector() as AppComponent
    }
}