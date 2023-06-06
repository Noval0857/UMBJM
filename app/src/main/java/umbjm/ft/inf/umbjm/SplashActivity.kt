package umbjm.ft.inf.umbjm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Menyembunyikan Action
        supportActionBar?.hide()

        Handler().postDelayed({
            //Menjalankan MainActivity
            startActivity(Intent(this, MainActivity::class.java))
            //Menghentikan SplashActivity
            finish()
        }, 3000) //set Durasi Splash Screen
    }
}