package com.dev.base

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.dev.base.activity.ActivityCollector
import com.dev.base.broadcast.ReceiverInfo

open class BaseActivity : AppCompatActivity() {
    private lateinit var receiver: CustomReceiver

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        ActivityCollector.addActivity(this)
    }

    override fun onResume() {
        super.onResume()
        val intentFilter = IntentFilter()
        intentFilter.addAction(ReceiverInfo.FORCE_OFFLINE)
        registerReceiver(receiver, intentFilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }

    inner class CustomReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            AlertDialog.Builder(context!!).apply {
                title = "Warning"
                setMessage("You are forced to be offline.Please try to login again. ")
                setCancelable(false)
                setPositiveButton("OK") { _, _ ->
                    ActivityCollector.finishAll()
                }
                show()
            }
        }
    }
}