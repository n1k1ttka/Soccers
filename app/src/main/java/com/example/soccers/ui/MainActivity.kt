package com.example.soccers.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.soccers.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            val fragment = SplashFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.navigation_view, fragment)
                .commit()
        }
    }
}