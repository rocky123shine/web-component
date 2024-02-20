package com.rocky.webview_component

import android.content.Context
import android.content.Intent
import com.google.auto.service.AutoService
import com.rocky.common.autoservice.IWebViewService

/**
 * <pre>
 *     author : rocky
 *     time   : 2024/02/20
 *     des : 使用autoservice
 * </pre>
 */
@AutoService(IWebViewService::class)
class WebViewServiceImpl : IWebViewService {
    override fun startWebViewActivity(context: Context, url: String) {
        val intent = Intent(context, WebComponentActivity::class.java)
        intent.putExtra("URL", url);
        context.startActivity(intent)
    }
}