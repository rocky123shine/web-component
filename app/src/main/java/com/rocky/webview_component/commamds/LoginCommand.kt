package com.rocky.webview_component.commamds

import android.os.Handler
import android.os.Looper
import com.google.auto.service.AutoService
import com.google.gson.Gson
import com.rocky.common.ICallbackFromMainProcessToWebViewProcess
import com.rocky.common.autoservice.ICommand

/**
 * <pre>
 *     author : rocky
 *     time   : 2024/02/21
 * </pre>
 */
@AutoService(ICommand::class)
class LoginCommand : ICommand {
    private lateinit var callbackNameFromNativeJs: String
    private var callback: ICallbackFromMainProcessToWebViewProcess? = null

    override fun name(): String {
        return "login"
    }

    override fun execute(params: Map<*, *>, callback: ICallbackFromMainProcessToWebViewProcess?) {
        this.callback = callback
        this.callbackNameFromNativeJs = params["callbackName"].toString()
        Handler(Looper.getMainLooper()).postDelayed(
            {
                val map = HashMap<String, String>()
                map["accountName"] = "rocky"
                callback?.onResult(callbackNameFromNativeJs, Gson().toJson(map))
            }, 2000
        )
    }


}