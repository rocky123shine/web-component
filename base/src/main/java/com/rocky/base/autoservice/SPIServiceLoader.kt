package com.rocky.base.autoservice

import java.util.ServiceLoader

/**
 * <pre>
 *     author : rocky
 *     time   : 2024/02/20
 * </pre>
 */
object SPIServiceLoader {
    fun <S> load(service: Class<S>): S? {
        return try {
            ServiceLoader.load(service).iterator().next()
        } catch (e: Exception) {
            null
        }
    }
}
