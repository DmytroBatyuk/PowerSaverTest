package com.example.powersavertest

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PowerManager
import android.provider.Settings
import android.support.v7.app.AlertDialog
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.testPowerSaverMode).setOnClickListener {
            val pm = getSystemService(Context.POWER_SERVICE) as PowerManager
            val sb = StringBuilder()
            sb.append("isDeviceIdleMode=${pm.isDeviceIdleMode}\n")
            sb.append("isInteractive=${pm.isInteractive}\n")
            sb.append("isPowerSaveMode=${pm.isPowerSaveMode}\n")
            sb.append("isSustainedPerformanceModeSupported=${pm.isSustainedPerformanceModeSupported}\n")

            val powerSavingMode = Settings.System.getString(contentResolver, "isDeviceIdleMode") == "1"
            sb.append("samsung: powerSavingMode=${powerSavingMode}\n")


            AlertDialog.Builder(this)
                .setTitle("Power Manager status")
                .setMessage(sb.toString())
                .setPositiveButton(android.R.string.ok, {d, id -> })
                .show()
        }
    }
}
