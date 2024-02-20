package com.rocky.common.autoservice

import android.content.Context

/**
 * <pre>
 *     author : rocky
 *     time   : 2024/02/20
 * </pre>
 */
interface IWebViewService {
    fun startWebViewActivity(context: Context, url: String)
}