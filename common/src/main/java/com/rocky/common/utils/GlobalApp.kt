package com.rocky.common.utils

import android.annotation.SuppressLint
import android.app.Application
import java.lang.reflect.Method

/**
 * <pre>
 *     author : rocky
 *     time   : 2024/02/21
 * </pre>
 */
@SuppressLint("DiscouragedPrivateApi")
object GlobalApp {
    val app: Application? by lazy {
        try {
            val currentApplication: Method =
                Class.forName("android.app.ActivityThread")
                    .getDeclaredMethod("currentApplication")
            currentApplication.invoke(null) as Application
        } catch (e: Exception) {
            null
        }

    }

}

