package com.rocky.webview_component

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * <pre>
 *     author : rocky
 *     time   : 2024/02/20
 * </pre>
 */
class WebComponentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webcomponent)
        initView()
    }

    private fun initView() {
        val url = intent.getStringExtra("URL") ?: "file:///android_asset/index.html"
        val frag = WebComponentFragment.instance(url)
        canGoBack = frag.canGoBack
        supportFragmentManager.beginTransaction().replace(R.id.flWeb, frag).commit()
    }

    var canGoBack: (() -> Boolean)? = null

    override fun finish() {
        if (canGoBack?.invoke() != true) {
            super.finish()
        }

    }
}