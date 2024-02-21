package com.rocky.webview_component.mainprocess

import com.rocky.common.ICallbackFromMainProcessToWebViewProcess
import com.rocky.common.IWebViewProcessToMainProcess

/**
 * <pre>
 *     author : rocky
 *     time   : 2024/02/21
 * </pre>
 */
object MainProcessCommandManager : IWebViewProcessToMainProcess.Stub() {
    override fun handleWebCommand(
        commandName: String?,
        jsParams: String?,
        callback: ICallbackFromMainProcessToWebViewProcess?,
    ) {

        println("MainProcessCommandManager ====== $commandName  -> $jsParams")

    }
}