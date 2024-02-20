package com.rocky.webview_component

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun jumpWeb(view: View) {
        try {
            val claz = Class.forName("com.rocky.webview_component.WebComponentActivity")
            val mIntent = Intent(this, claz)
            startActivity(mIntent)

        } catch (e: Exception) {
        }

    }
}