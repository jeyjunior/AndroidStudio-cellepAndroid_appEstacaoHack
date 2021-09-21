package com.jjunior.estaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.jjunior.estaohack.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mIntent = Intent(this, LoginActivity::class.java)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(mIntent)
            finish()
        }, 1000)
    }
}