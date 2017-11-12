@file:JvmName("KxLogger")

package org.kxtra.slf4j.logger

import org.slf4j.Logger
import org.slf4j.Marker

inline fun Logger.error(lazyMessage: () -> Any?) {
    if (isErrorEnabled) error(lazyMessage().toString())
}

inline fun Logger.warn(lazyMessage: () -> Any?) {
    if (isWarnEnabled) warn(lazyMessage().toString())
}

inline fun Logger.info(lazyMessage: () -> Any?) {
    if (isInfoEnabled) info(lazyMessage().toString())
}

inline fun Logger.debug(lazyMessage: () -> Any?) {
    if (isDebugEnabled) debug(lazyMessage().toString())
}

inline fun Logger.trace(lazyMessage: () -> Any?) {
    if (isTraceEnabled) trace(lazyMessage().toString())
}




inline fun Logger.error(marker: Marker?, lazyMessage: () -> Any?) {
    if (isErrorEnabled(marker)) error(marker, lazyMessage().toString())
}

inline fun Logger.warn(marker: Marker?, lazyMessage: () -> Any?) {
    if (isWarnEnabled(marker)) warn(marker, lazyMessage().toString())
}

inline fun Logger.info(marker: Marker?, lazyMessage: () -> Any?) {
    if (isInfoEnabled(marker)) info(marker, lazyMessage().toString())
}

inline fun Logger.debug(marker: Marker?, lazyMessage: () -> Any?) {
    if (isDebugEnabled(marker)) debug(marker, lazyMessage().toString())
}

inline fun Logger.trace(marker: Marker?, lazyMessage: () -> Any?) {
    if (isTraceEnabled(marker)) trace(marker, lazyMessage().toString())
}




inline fun Logger.error(throwable: Throwable?, lazyMessage: () -> Any?) {
    if (isErrorEnabled) error(lazyMessage().toString(), throwable)
}

inline fun Logger.warn(throwable: Throwable?, lazyMessage: () -> Any?) {
    if (isWarnEnabled) warn(lazyMessage().toString(), throwable)
}

inline fun Logger.info(throwable: Throwable?, lazyMessage: () -> Any?) {
    if (isInfoEnabled) info(lazyMessage().toString(), throwable)
}

inline fun Logger.debug(throwable: Throwable?, lazyMessage: () -> Any?) {
    if (isDebugEnabled) debug(lazyMessage().toString(), throwable)
}

inline fun Logger.trace(throwable: Throwable?, lazyMessage: () -> Any?) {
    if (isTraceEnabled) trace(lazyMessage().toString(), throwable)
}




inline fun Logger.error(marker: Marker?, throwable: Throwable?, lazyMessage: () -> Any?) {
    if (isErrorEnabled(marker)) error(marker, lazyMessage().toString(), throwable)
}

inline fun Logger.warn(marker: Marker?, throwable: Throwable?, lazyMessage: () -> Any?) {
    if (isWarnEnabled(marker)) warn(marker, lazyMessage().toString(), throwable)
}

inline fun Logger.info(marker: Marker?, throwable: Throwable?, lazyMessage: () -> Any?) {
    if (isInfoEnabled(marker)) info(marker, lazyMessage().toString(), throwable)
}

inline fun Logger.debug(marker: Marker?, throwable: Throwable?, lazyMessage: () -> Any?) {
    if (isDebugEnabled(marker)) debug(marker, lazyMessage().toString(), throwable)
}

inline fun Logger.trace(marker: Marker?, throwable: Throwable?, lazyMessage: () -> Any?) {
    if (isTraceEnabled(marker)) trace(marker, lazyMessage().toString(), throwable)
}