/**
 * Copyright Red Hat, Inc, and individual contributors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.feedhenry.sdk.utils;

/**
 * Interface for implementing loggers.
 */
public interface Logger {

    int LOG_LEVEL_VERBOSE = 1;
    int LOG_LEVEL_DEBUG = 2;
    int LOG_LEVEL_INFO = 3;
    int LOG_LEVEL_WARNING = 4;
    int LOG_LEVEL_ERROR = 5;
    int LOG_LEVEL_NONE = Integer.MAX_VALUE;

    /**
     * Log using VERBOSE level
     *
     * @param tag     log tag
     * @param message log message
     */
    void v(String tag, String message);

    /**
     * Log using DEBUG level
     *
     * @param tag     log tag
     * @param message log message
     */
    void d(String tag, String message);

    /**
     * Log using INFO level
     *
     * @param tag     log tag
     * @param message log message
     */
    void i(String tag, String message);

    /**
     * Log using WARNING level
     *
     * @param tag     log tag
     * @param message log message
     */
    void w(String tag, String message);

    /**
     * Log using ERROR level
     *
     * @param tag       log tag
     * @param message   log message
     * @param pThrowable exception causing error
     */
    void e(String tag, String message, Throwable pThrowable);

    /**
     * Sets log level of the logger.
     * Use one of {@link #LOG_LEVEL_VERBOSE}, {@link #LOG_LEVEL_VERBOSE}, {@link #LOG_LEVEL_INFO}, {@link #LOG_LEVEL_WARNING}, {@link #LOG_LEVEL_ERROR} or {@link #LOG_LEVEL_NONE}
     *
     * @param logLevel log level
     */
    void setLogLevel(int logLevel);
}
