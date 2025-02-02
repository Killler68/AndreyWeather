package com.example.weatherproject.common.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.weatherproject.mainweather.FragmentMainWeather
import com.example.weatherproject.R

private const val WAITING_TIME = 2000
private const val EXIT_CONFIRMATION = "Чтобы выйти из приложения\n           нажмите еще раз"

class MainActivity : AppCompatActivity() {

    private var backPressedTime: Long = 0
    private lateinit var backToast: Toast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigateToFragmentActivity(FragmentMainWeather())
    }

    override fun onBackPressed() {
        backToast = Toast.makeText(this, EXIT_CONFIRMATION, Toast.LENGTH_SHORT)
        if (backPressedTime + WAITING_TIME > System.currentTimeMillis()) {
            backToast.cancel()
            super.onBackPressed()
            finishAffinity()
            finish()
        } else {
            backToast.show()
        }
        backPressedTime = System.currentTimeMillis()
    }
}