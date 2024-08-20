package com.plugin.holochainforegroundservice

import android.app.Activity
import android.content.Intent
import android.content.Context
import app.tauri.annotation.Command
import app.tauri.annotation.InvokeArg
import app.tauri.annotation.TauriPlugin
import app.tauri.plugin.JSObject
import app.tauri.plugin.Plugin
import app.tauri.plugin.Invoke
import android.app.NotificationChannel
import android.app.NotificationManager
import android.util.Log


@InvokeArg
class HolochainArgs {
}

@TauriPlugin
class HolochainPlugin(private val activity: Activity): Plugin(activity) {

    @Command
    fun launch(invoke: Invoke) {
        Log.d("HolochainPlugin", "launch 1")
        val args = invoke.parseArgs(HolochainArgs::class.java)

        val channel = NotificationChannel(
            "HolochainServiceChannel",
            "Holochain Service",
            NotificationManager.IMPORTANCE_HIGH
        )
        Log.d("HolochainPlugin", "launch 2")

        val notificationManager = activity.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        Log.d("HolochainPlugin", "launch 3")

        notificationManager.createNotificationChannel(channel)
        Log.d("HolochainPlugin", "launch 4")

        val intent = Intent(activity, HolochainService::class.java)
        Log.d("HolochainPlugin", "launch 5")

        activity.startForegroundService(intent)
        Log.d("HolochainPlugin", "launch 6")
        invoke.resolve()
    }
}
