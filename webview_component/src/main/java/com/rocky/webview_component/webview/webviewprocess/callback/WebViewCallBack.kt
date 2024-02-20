package com.rocky.webview_component.webview.webviewprocess.callback

/**
 * <pre>
 *     author : rocky
 *     time   : 2024/02/20
 *     des:    暴露视图的生命周期
 * </pre>
 */
interface WebViewCallBack {
    fun pageStarted(url: String)
    fun pageFinished(url: String)
    fun onError(description: CharSequence)
    fun updateTitle(title: String)
}