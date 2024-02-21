package com.rocky.webview_component.webview

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebViewClient
import com.google.gson.Gson
import com.rocky.webview_component.JsParam
import com.rocky.webview_component.webview.webviewprocess.callback.WebViewCallBack
import com.rocky.webview_component.webview.webviewprocess.client.ChromeClient
import com.rocky.webview_component.webview.webviewprocess.client.ViewClient
import com.rocky.webview_component.webview.webviewprocess.settings.WebViewDefaultSettings

/**
 * <pre>
 *     author : rocky
 *     time   : 2024/02/20
 * </pre>
 */
class WebViewComponent constructor(
    private val context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
) : WebView(context, attrs, defStyleAttr, defStyleRes) {

    constructor(context: Context) : this(context, null, 0, 0)
    constructor(context: Context, attrs: AttributeSet? = null) : this(context, attrs, 0, 0)

    init {
        WebViewProcessCommandsDispatcher.initAidlConnection()
        WebViewDefaultSettings.setSettings(this)
        webViewClient = object : WebViewClient() {}
        addJavascriptInterface(this, "webComponent")
    }


    /**
     * @param callback 处理 webview的回调
     * 例如title的改变 视图的生命周期回调
     */
    fun registerWebViewCallback(callback: WebViewCallBack) {
        webViewClient = ViewClient(callback)
        webChromeClient = ChromeClient(callback)
    }

    /**
     * 统一处理 H5 调用原生方法
     * 只需要 传递过来参数即可
     * @param jsParam 和h5 沟通好的对象的序列化  包含方法名 参数
     */
    @JavascriptInterface
    fun executeNativeAction(jsParam: String) {
        if (!TextUtils.isEmpty(jsParam)) {
            val jsParamObj = Gson().fromJson(jsParam, JsParam::class.java)
            jsParamObj?.let {
                WebViewProcessCommandsDispatcher.executeCommand(
                    jsParamObj.name,
                    Gson().toJson(jsParamObj.param),
                    this
                )
            }

        }
    }
}