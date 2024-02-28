package com.rocky.common.autoservice

import com.rocky.common.ICallbackFromMainProcessToWebViewProcess

/**
 * <pre>
 *     author : rocky
 *     time   : 2024/02/21
 *     des : 命令的抽象
 * </pre>
 */
interface ICommand {
    fun name(): String
    fun execute(params: Map<*, *>, callback: ICallbackFromMainProcessToWebViewProcess?)
}