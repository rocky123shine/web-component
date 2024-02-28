package com.rocky.webview_component.webview

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import com.rocky.common.ICallbackFromMainProcessToWebViewProcess
import com.rocky.common.IWebViewProcessToMainProcess
import com.rocky.common.utils.GlobalApp
import com.rocky.webview_component.mainprocess.MainProcessCommandService

/**
 * <pre>
 *     author : rocky
 *     time   : 2024/02/21
 * </pre>
 */
object WebViewProcessCommandsDispatcher : ServiceConnection {
    private var iWebViewProcessToMainProcess: IWebViewProcessToMainProcess? = null
    fun initAidlConnection() {
        val context = GlobalApp.app ?: return

        val intent = Intent(context, MainProcessCommandService::class.java)

        context.bindService(intent, this, Context.BIND_AUTO_CREATE)
    }

    override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
        iWebViewProcessToMainProcess = IWebViewProcessToMainProcess.Stub.asInterface(service)

    }

    override fun onServiceDisconnected(name: ComponentName?) {
        iWebViewProcessToMainProcess = null
        initAidlConnection()
    }

    fun executeCommand(commandName: String, parameters: String, webView: WebViewComponent) {
        iWebViewProcessToMainProcess?.handleWebCommand(commandName,
            parameters,
            object : ICallbackFromMainProcessToWebViewProcess.Stub() {
                override fun onResult(callbackName: String?, response: String?) {
                    webView.handleCallback(callbackName,response)
                }
            })
    }
}