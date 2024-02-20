package com.rocky.webview_component.webview.webviewprocess.client

import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient
import android.webkit.WebView
import com.rocky.webview_component.webview.webviewprocess.callback.WebViewCallBack

/**
 * <pre>
 *     author : rocky
 *     time   : 2024/02/20
 *     des: 这里是浏览器解析相关
 *
 * </pre>
 */
class ChromeClient(val callBack: WebViewCallBack? = null) : WebChromeClient() {
    override fun onProgressChanged(view: WebView?, newProgress: Int) {
        super.onProgressChanged(view, newProgress)
    }

    override fun onReceivedTitle(view: WebView?, title: String?) {
        super.onReceivedTitle(view, title)
        callBack?.updateTitle(title ?: "")
    }

    override fun onConsoleMessage(consoleMessage: ConsoleMessage?): Boolean {
        return super.onConsoleMessage(consoleMessage)
    }
}