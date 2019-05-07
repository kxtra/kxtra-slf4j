/*
 * MIT License
 *
 * Copyright (c) 2017-2019, Hunter WB <hunterwb.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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