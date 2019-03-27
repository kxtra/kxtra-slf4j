@file:Suppress("NOTHING_TO_INLINE")

package org.kxtra.slf4j

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.slf4j.Marker
import java.lang.invoke.MethodHandles

/**
 * Calls [LoggerFactory.getLogger] with the [Class] that contains the call to this method.
 */
@JvmSynthetic
inline fun getLogger(): Logger {
    return LoggerFactory.getLogger(MethodHandles.lookup().lookupClass())
}

/**
 * Calls [LoggerFactory.getLogger].
 */
@JvmSynthetic
inline fun getLogger(clazz: Class<*>): Logger {
    return LoggerFactory.getLogger(clazz)
}

/**
 * Calls [LoggerFactory.getLogger].
 */
@JvmSynthetic
inline fun getLogger(name: String): Logger {
    return LoggerFactory.getLogger(name)
}



@JvmSynthetic
inline fun Logger.error(lazyMessage: () -> Any?) {
    if (isErrorEnabled) error(lazyMessage().toString())
}

@JvmSynthetic
inline fun Logger.warn(lazyMessage: () -> Any?) {
    if (isWarnEnabled) warn(lazyMessage().toString())
}

@JvmSynthetic
inline fun Logger.info(lazyMessage: () -> Any?) {
    if (isInfoEnabled) info(lazyMessage().toString())
}

@JvmSynthetic
inline fun Logger.debug(lazyMessage: () -> Any?) {
    if (isDebugEnabled) debug(lazyMessage().toString())
}

@JvmSynthetic
inline fun Logger.trace(lazyMessage: () -> Any?) {
    if (isTraceEnabled) trace(lazyMessage().toString())
}



@JvmSynthetic
inline fun Logger.error(marker: Marker?, lazyMessage: () -> Any?) {
    if (isErrorEnabled(marker)) error(marker, lazyMessage().toString())
}

@JvmSynthetic
inline fun Logger.warn(marker: Marker?, lazyMessage: () -> Any?) {
    if (isWarnEnabled(marker)) warn(marker, lazyMessage().toString())
}

@JvmSynthetic
inline fun Logger.info(marker: Marker?, lazyMessage: () -> Any?) {
    if (isInfoEnabled(marker)) info(marker, lazyMessage().toString())
}

@JvmSynthetic
inline fun Logger.debug(marker: Marker?, lazyMessage: () -> Any?) {
    if (isDebugEnabled(marker)) debug(marker, lazyMessage().toString())
}

@JvmSynthetic
inline fun Logger.trace(marker: Marker?, lazyMessage: () -> Any?) {
    if (isTraceEnabled(marker)) trace(marker, lazyMessage().toString())
}



@JvmSynthetic
inline fun Logger.error(throwable: Throwable?, lazyMessage: () -> Any?) {
    if (isErrorEnabled) error(lazyMessage().toString(), throwable)
}

@JvmSynthetic
inline fun Logger.warn(throwable: Throwable?, lazyMessage: () -> Any?) {
    if (isWarnEnabled) warn(lazyMessage().toString(), throwable)
}

@JvmSynthetic
inline fun Logger.info(throwable: Throwable?, lazyMessage: () -> Any?) {
    if (isInfoEnabled) info(lazyMessage().toString(), throwable)
}

@JvmSynthetic
inline fun Logger.debug(throwable: Throwable?, lazyMessage: () -> Any?) {
    if (isDebugEnabled) debug(lazyMessage().toString(), throwable)
}

@JvmSynthetic
inline fun Logger.trace(throwable: Throwable?, lazyMessage: () -> Any?) {
    if (isTraceEnabled) trace(lazyMessage().toString(), throwable)
}



@JvmSynthetic
inline fun Logger.error(marker: Marker?, throwable: Throwable?, lazyMessage: () -> Any?) {
    if (isErrorEnabled(marker)) error(marker, lazyMessage().toString(), throwable)
}

@JvmSynthetic
inline fun Logger.warn(marker: Marker?, throwable: Throwable?, lazyMessage: () -> Any?) {
    if (isWarnEnabled(marker)) warn(marker, lazyMessage().toString(), throwable)
}

@JvmSynthetic
inline fun Logger.info(marker: Marker?, throwable: Throwable?, lazyMessage: () -> Any?) {
    if (isInfoEnabled(marker)) info(marker, lazyMessage().toString(), throwable)
}

@JvmSynthetic
inline fun Logger.debug(marker: Marker?, throwable: Throwable?, lazyMessage: () -> Any?) {
    if (isDebugEnabled(marker)) debug(marker, lazyMessage().toString(), throwable)
}

@JvmSynthetic
inline fun Logger.trace(marker: Marker?, throwable: Throwable?, lazyMessage: () -> Any?) {
    if (isTraceEnabled(marker)) trace(marker, lazyMessage().toString(), throwable)
}



@JvmSynthetic
inline fun Logger.error(throwable: Throwable?) {
    error("", throwable)
}

@JvmSynthetic
inline fun Logger.warn(throwable: Throwable?) {
    warn("", throwable)
}

@JvmSynthetic
inline fun Logger.info(throwable: Throwable?) {
    info("", throwable)
}

@JvmSynthetic
inline fun Logger.debug(throwable: Throwable?) {
    debug("", throwable)
}

@JvmSynthetic
inline fun Logger.trace(throwable: Throwable?) {
    trace("", throwable)
}