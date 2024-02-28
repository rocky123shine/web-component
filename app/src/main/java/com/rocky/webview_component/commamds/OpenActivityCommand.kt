package com.rocky.webview_component.commamds

import android.content.ComponentName
import android.content.Intent
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
class OpenActivityCommand : ICommand {
    override fun name(): String {
        return "openActivity"
    }

    override fun execute(params: Map<*, *>, callback: ICallbackFromMainProcessToWebViewProcess?) {
        val targetClass = params["target_class"].toString()
        targetClass?.let {
            val intent = Intent()
            intent.component = ComponentName(GlobalApp.app?.packageName ?: "", targetClass)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            GlobalApp.app?.startActivity(intent)
        }
    }
}