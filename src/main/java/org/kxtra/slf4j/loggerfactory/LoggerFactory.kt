@file:JvmName("KxLoggerFactory")

package org.kxtra.slf4j.loggerfactory

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.lang.invoke.MethodHandles

/**
 * Calls [LoggerFactory.getLogger] with the [Class] that contains the call to this method.
 */
@JvmSynthetic
@Suppress("NOTHING_TO_INLINE")
inline fun getLogger(): Logger {
    return LoggerFactory.getLogger(MethodHandles.lookup().lookupClass())
}

/**
 * Calls [LoggerFactory.getLogger].
 */
@JvmSynthetic
@Suppress("NOTHING_TO_INLINE")
inline fun getLogger(clazz: Class<*>): Logger {
    return LoggerFactory.getLogger(clazz)
}

/**
 * Calls [LoggerFactory.getLogger].
 */
@JvmSynthetic
@Suppress("NOTHING_TO_INLINE")
inline fun getLogger(name: String): Logger {
    return LoggerFactory.getLogger(name)
}