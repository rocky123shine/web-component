package com.rocky.webview_component

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rocky.webview_component.webview.WebViewComponent
import com.rocky.webview_component.webview.webviewprocess.callback.WebViewCallBack

/**
 * <pre>
 *     author : rocky
 *     time   : 2024/02/20
 * </pre>
 */
class WebComponentFragment() : Fragment(), WebViewCallBack {
    lateinit var mUrl: String
    private lateinit var mWeb: WebViewComponent

    companion object {
        const val URL = "URL"
        fun instance(url: String): WebComponentFragment {
            val webfrag = WebComponentFragment()
            val bundle = Bundle()
            bundle.putString(URL, url)
            webfrag.arguments = bundle
            return webfrag
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mUrl = arguments?.getString(URL) ?: ""
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_webcomponent, container, false)
        mWeb = view.findViewById<WebViewComponent>(R.id.web)
        initWeb()
        return view
    }

    private fun initWeb() {
        mWeb.registerWebViewCallback(this)
        mWeb.loadUrl(mUrl)
    }

    override fun pageStarted(url: String) {
    }

    override fun pageFinished(url: String) {
    }

    override fun onError(description: CharSequence) {
    }

    override fun updateTitle(title: String) {
    }

    val canGoBack = {
        val canback = mWeb.canGoBack()
//        println("mWeb.canGoBack() === $canback")
        if (canback) mWeb.goBack()
        canback
    }
}