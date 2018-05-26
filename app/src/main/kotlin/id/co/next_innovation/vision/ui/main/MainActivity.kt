package id.co.next_innovation.vision.ui.main

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import id.co.next_innovation.vision.R
import id.co.next_innovation.vision.ui.component.activity.BaseActivity
import id.co.next_innovation.vision.util.Display
import id.co.next_innovation.vision.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }

    val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setFragment(R.id.frame_main_content, ::HomeFragment)
//        binding.bottomNavMain.setOnNavigationItemSelectedListener(this)

        Display.showSystemUi(window)
    }
}