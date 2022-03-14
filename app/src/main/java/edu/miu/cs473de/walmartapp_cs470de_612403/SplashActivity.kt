package edu.miu.cs473de.walmartapp_cs470de_612403

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Thread.sleep

class SplashActivity : AppCompatActivity() {

    val activitScope= CoroutineScope(Dispatchers.Main)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        activitScope.launch {
            delay(3000)
            startActivity(Intent(this@SplashActivity,LoginActivity::class.java))
            finish()
        }


    }

    override fun onStart() {
        super.onStart()

    }
}