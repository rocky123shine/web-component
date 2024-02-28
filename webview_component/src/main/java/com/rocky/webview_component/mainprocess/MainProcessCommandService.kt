package com.rocky.webview_component.mainprocess

import android.app.Service
import android.content.Intent
import android.os.IBinder

/**
 * <pre>
 *     author : rocky
 *     time   : 2024/02/21
 *     des    : web 进程和 主进程通讯的桥梁
 * </pre>
 */
class MainProcessCommandService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return MainProcessCommandManager.asBinder()
    }
}