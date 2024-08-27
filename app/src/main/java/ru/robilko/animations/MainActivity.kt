package ru.robilko.animations

import android.content.Intent
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.Window
import android.view.animation.AccelerateInterpolator
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        with(window) {
            requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
            enterTransition = TransitionInflater.from(this@MainActivity)
                .inflateTransition(R.transition.slide_from_left)
            exitTransition = TransitionInflater.from(this@MainActivity)
                .inflateTransition(R.transition.slide_from_right)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonStart = findViewById<Button>(R.id.button_start)

        buttonStart.alpha = 0f
        buttonStart.scaleX = 0f
        buttonStart.scaleY = 0f
        buttonStart.animate()
            .alpha(1f)
            .scaleX(1f)
            .scaleY(1f)
            .setDuration(800)
            .setInterpolator(AccelerateInterpolator())
            .start()

        buttonStart.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent, android.app.ActivityOptions
                .makeSceneTransitionAnimation(this).toBundle())
        }
    }
}