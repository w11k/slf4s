package com.weiglewilczek.slf4s

import org.slf4j.{ Logger => SLF4JLogger }

/**
 * Thin wrapper for SLF4J making use of by-name parameters to improve performance.
 */
trait Logger {

  /**
   * Log an error.
   * @msg The message to be logged
   */
  def error(msg: => String) {
    require (msg != null, "msg must not be null!")
    if (slf4jLogger.isErrorEnabled) slf4jLogger error msg
  }

  /**
   * Log an error.
   * @msg The message to be logged
   * @t The Throwable to be logged
   */
  def error(msg: => String, t: Throwable) {
    require (msg != null, "msg must not be null!")
    require (t != null, "t must not be null!")
    if (slf4jLogger.isErrorEnabled) slf4jLogger.error(msg, t)
  }

  // TODO Add ScalaDoc (also other API methods)!
  def warn(msg: => String) {
    require (msg != null, "msg must not be null!")
    if (slf4jLogger.isWarnEnabled) slf4jLogger warn msg
  }

  def warn(msg: => String, t: Throwable) {
    require (msg != null, "msg must not be null!")
    require (t != null, "t must not be null!")
    if (slf4jLogger.isWarnEnabled) slf4jLogger.warn(msg, t)
  }

  def info(msg: => String) {
    require (msg != null, "msg must not be null!")
    if (slf4jLogger.isInfoEnabled) slf4jLogger info msg
  }

  def info(msg: => String, t: Throwable) {
    require (msg != null, "msg must not be null!")
    require (t != null, "t must not be null!")
    if (slf4jLogger.isInfoEnabled) slf4jLogger.info(msg, t)
  }

  def debug(msg: => String) {
    require (msg != null, "msg must not be null!")
    if (slf4jLogger.isDebugEnabled) slf4jLogger debug msg
  }

  def debug(msg: => String, t: Throwable) {
    require (msg != null, "msg must not be null!")
    require (t != null, "t must not be null!")
    if (slf4jLogger.isDebugEnabled) slf4jLogger.debug(msg, t)
  }

  // TODO Add trace methods!

  /**
   * The wrapped SLF4J Logger.
   */
  protected val slf4jLogger: SLF4JLogger
}
