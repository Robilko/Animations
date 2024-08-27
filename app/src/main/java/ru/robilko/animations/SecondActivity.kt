package ru.robilko.animations

import android.animation.ObjectAnimator
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.View
import android.view.Window
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        with(window) {
            requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
            enterTransition = TransitionInflater.from(this@SecondActivity)
                .inflateTransition(R.transition.slide_from_right)
            exitTransition = TransitionInflater.from(this@SecondActivity)
                .inflateTransition(R.transition.slide_from_left)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val animatedView = findViewById<View>(R.id.animated_view)
        animateView(animatedView)

        val buttonBack = findViewById<Button>(R.id.button_back)
        buttonBack.setOnClickListener { finishAfterTransition() }
    }

    private fun animateView(view: View) {
        ObjectAnimator.ofFloat(view, "rotation", 0f, 360f).apply {
            duration = 1000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.RESTART
            start()
        }
    }
}
