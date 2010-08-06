package com.weiglewilczek.slf4s

import org.slf4j.{ Logger => SLF4JLogger }

/**
 * Thin wrapper for SLF4J making use of by-name parameters to improve performance.
 */
trait Logger {

  /**
   * Log a message with ERROR level.
   * @param msg The message to be logged
   */
  def error(msg: => String) {
    require (msg != null, "msg must not be null!")
    if (slf4jLogger.isErrorEnabled) slf4jLogger error msg
  }

  /**
   * Log a message with ERROR level.
   * @param msg The message to be logged
   * @param t The Throwable to be logged
   */
  def error(msg: => String, t: Throwable) {
    require (msg != null, "msg must not be null!")
    require (t != null, "t must not be null!")
    if (slf4jLogger.isErrorEnabled) slf4jLogger.error(msg, t)
  }

  /**
   * Log a message with WARN level.
   * @param msg The message to be logged
   */
  def warn(msg: => String) {
    require (msg != null, "msg must not be null!")
    if (slf4jLogger.isWarnEnabled) slf4jLogger warn msg
  }

  /**
   * Log a message with WARN level.
   * @param msg The message to be logged
   * @param t The Throwable to be logged
   */
  def warn(msg: => String, t: Throwable) {
    require (msg != null, "msg must not be null!")
    require (t != null, "t must not be null!")
    if (slf4jLogger.isWarnEnabled) slf4jLogger.warn(msg, t)
  }

  /**
   * Log a message with INFO level.
   * @param msg The message to be logged
   */
  def info(msg: => String) {
    require (msg != null, "msg must not be null!")
    if (slf4jLogger.isInfoEnabled) slf4jLogger info msg
  }

  /**
   * Log a message with INFO level.
   * @param msg The message to be logged
   * @param t The Throwable to be logged
   */
  def info(msg: => String, t: Throwable) {
    require (msg != null, "msg must not be null!")
    require (t != null, "t must not be null!")
    if (slf4jLogger.isInfoEnabled) slf4jLogger.info(msg, t)
  }

  /**
   * Log a message with DEBUG level.
   * @param msg The message to be logged
   */
  def debug(msg: => String) {
    require (msg != null, "msg must not be null!")
    if (slf4jLogger.isDebugEnabled) slf4jLogger debug msg
  }

  /**
   * Log a message with DEBUG level.
   * @param msg The message to be logged
   * @param t The Throwable to be logged
   */
  def debug(msg: => String, t: Throwable) {
    require (msg != null, "msg must not be null!")
    require (t != null, "t must not be null!")
    if (slf4jLogger.isDebugEnabled) slf4jLogger.debug(msg, t)
  }

  /**
   * Log a message with TRACE level.
   * @param msg The message to be logged
   */
  def trace(msg: => String) {
    require (msg != null, "msg must not be null!")
    if (slf4jLogger.isTraceEnabled) slf4jLogger trace msg
  }

  /**
   * Log a message with TRACE level.
   * @param msg The message to be logged
   * @param t The Throwable to be logged
   */
  def trace(msg: => String, t: Throwable) {
    require (msg != null, "msg must not be null!")
    require (t != null, "t must not be null!")
    if (slf4jLogger.isTraceEnabled) slf4jLogger.trace(msg, t)
  }

  /**
   * The wrapped SLF4J Logger.
   */
  protected val slf4jLogger: SLF4JLogger
}