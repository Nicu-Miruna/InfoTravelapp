package com.fmi.app

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast;

class AnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
        val airplaneView = findViewById<View>(R.id.airplane_id) as ImageView

        val AnimateAir = ObjectAnimator.ofFloat(airplaneView, "translationX", 1000f)
        AnimateAir.start();
        AnimateAir.duration = 4000

    }

    companion object {
        private const val TAG = "AnimationActivity"
    }
}