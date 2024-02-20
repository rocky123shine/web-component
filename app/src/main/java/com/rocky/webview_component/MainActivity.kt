package com.rocky.webview_component

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.rocky.base.autoservice.SPIServiceLoader
import com.rocky.common.autoservice.IWebViewService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun jumpWeb(view: View) {
        //跳转方式1 直接跳转
//        try {
//            val claz = Class.forName("com.rocky.webview_component.WebComponentActivity")
//            val mIntent = Intent(this, claz)
//            startActivity(mIntent)
//
//        } catch (e: Exception) {
//        }

        //方式二 autoservice  使用 接口执行
        val iWebViewService = SPIServiceLoader.load(IWebViewService::class.java)
        iWebViewService?.startWebViewActivity(this,"file:///android_asset/index.html")

    }
}