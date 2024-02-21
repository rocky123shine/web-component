package com.rocky.webview_component

import androidx.annotation.Keep
import com.google.gson.JsonObject


/**
 * <pre>
 *     author : rocky
 *     time   : 2024/02/21
 * </pre>
 */
@Keep
data class JsParam(val name: String, val param: JsonObject)
