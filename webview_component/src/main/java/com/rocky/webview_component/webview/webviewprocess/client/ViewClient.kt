package com.rocky.webview_component.webview.webviewprocess.client

import android.graphics.Bitmap
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.rocky.webview_component.webview.webviewprocess.callback.WebViewCallBack

/**
 * <pre>
 *     author : rocky
 *     time   : 2024/02/20
 *     des:   处理视图的生命周期
 * </pre>
 */
class ViewClient(val callback: WebViewCallBack? = null) : WebViewClient() {

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        callback?.pageStarted(url ?: "")
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        callback?.pageFinished(url ?: "")
    }

    override fun onReceivedError(
        view: WebView?,
        request: WebResourceRequest?,
        error: WebResourceError?,
    ) {
        super.onReceivedError(view, request, error)
        callback?.onError(error?.description?:"")
    }

}