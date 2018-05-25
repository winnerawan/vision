package id.co.next_innovation.vision.ui.component.binding

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.request.RequestOptions
import id.co.next_innovation.vision.util.GlideApp

object ImageBindingAdapters {
    @JvmStatic
    @BindingAdapter("image")
    fun loadImage(view: ImageView, imagePath: String) {
        GlideApp.with(view.context)
                .load(imagePath)
                .into(view)
    }

    @JvmStatic
    @BindingAdapter("circle_image")
    fun loadCircleImage(view: ImageView, imagePath: String) {
        GlideApp.with(view.context)
                .load(imagePath)
                .apply(RequestOptions.circleCropTransform())
                .into(view)
    }
}