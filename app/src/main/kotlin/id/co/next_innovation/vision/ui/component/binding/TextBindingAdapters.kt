package id.co.next_innovation.vision.ui.component.binding

import android.databinding.BindingAdapter
import android.widget.TextView

object TextBindingAdapters {
    @JvmStatic
    @BindingAdapter("android:text")
    fun bindText(view: TextView, value: Int) {
        view.text = value.toString()
    }

    @JvmStatic
    @BindingAdapter("android:text", "android:text_format")
    fun bindTextWithFormat(view: TextView, value: Int, format: String) {
        view.text = String.format(format, value)
    }

    @JvmStatic
    @BindingAdapter("android:text", "android:text_format")
    fun bindTextWithFormat(view: TextView, value: Double, format: String) {
        view.text = String.format(format, value)
    }
}