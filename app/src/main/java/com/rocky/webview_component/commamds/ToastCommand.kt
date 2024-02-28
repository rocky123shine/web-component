package com.rocky.webview_component.commamds

import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.google.auto.service.AutoService
import com.rocky.common.ICallbackFromMainProcessToWebViewProcess
import com.rocky.common.autoservice.ICommand
import com.rocky.common.utils.GlobalApp

/**
 * <pre>
 *     author : rocky
 *     time   : 2024/02/21
 * </pre>
 */
@AutoService(ICommand::class)
class ToastCommand : ICommand {
    override fun name(): String {
        return "showToast"
    }

    override fun execute(params: Map<*, *>, callback: ICallbackFromMainProcessToWebViewProcess?) {
        val handler = Handler(Looper.getMainLooper())
        handler.post {
            Toast.makeText(GlobalApp.app, params["message"].toString() ?: "", Toast.LENGTH_SHORT)
                .show()
        }
    }
}