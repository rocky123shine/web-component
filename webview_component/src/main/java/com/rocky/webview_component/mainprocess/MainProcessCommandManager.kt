package com.rocky.webview_component.mainprocess

import com.google.gson.Gson
import com.rocky.common.ICallbackFromMainProcessToWebViewProcess
import com.rocky.common.IWebViewProcessToMainProcess
import com.rocky.common.autoservice.ICommand
import java.util.*

/**
 * <pre>
 *     author : rocky
 *     time   : 2024/02/21
 * </pre>
 */
object MainProcessCommandManager : IWebViewProcessToMainProcess.Stub() {
    private val mCommands: HashMap<String, ICommand> = HashMap()

    init {
        //搜集所有命令 便于后续的分发
        val iCommands = ServiceLoader.load(ICommand::class.java)
        iCommands.forEach {
            if (!mCommands.containsKey(it.name())) {
                mCommands[it.name()] = it
            }
        }
    }

    override fun handleWebCommand(
        commandName: String?,
        jsParams: String?,
        callback: ICallbackFromMainProcessToWebViewProcess?,
    ) {

//        println("MainProcessCommandManager ====== $commandName  -> $jsParams")
        //查找到对应命令的实现类  去执行命令
        mCommands[commandName]?.execute(Gson().fromJson(jsParams,MutableMap::class.java),callback)
    }
}