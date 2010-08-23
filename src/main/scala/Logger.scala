package com.weiglewilczek.slf4s

import org.slf4j.{ Logger => SLF4JLogger, LoggerFactory }

/**
 * Factory for Loggers.
 */
object Logger {

  /**
   * Creates a Logger named corresponding to the given class.
   * @param clazz Class used for the Logger's name. Must not be null!
   */
  def apply(clazz: Class[_]) = {
    // TODO Precondition: clazz != null
    new Logger {
      override val slf4jLogger = LoggerFactory getLogger clazz
    }
  }

  /**
   * Creates a Logger with the given name.
   * @param The Logger's name. Must not be null!
   */
  def apply(name: String) = {
    // TODO Precondition: name != null
    new Logger {
      override val slf4jLogger = LoggerFactory getLogger name
    }
  }
}

/**
 * Thin wrapper for SLF4J making use of by-name parameters to improve performance.
 */
trait Logger {

  /**
   * The name of this Logger.
   */
  lazy val name = slf4jLogger.getName

  /**
   * Log a message with ERROR level.
   * @param msg The message to be logged. Must not be null!
   */
  def error(msg: => String) {
    require (msg != null, "msg must not be null!")
    if (slf4jLogger.isErrorEnabled) slf4jLogger error msg
  }

  /**
   * Log a message with ERROR level.
   * @param msg The message to be logged. Must not be null!
   * @param t The Throwable to be logged. Must not be null!
   */
  def error(msg: => String, t: Throwable) {
    require (msg != null, "msg must not be null!")
    require (t != null, "t must not be null!")
    if (slf4jLogger.isErrorEnabled) slf4jLogger.error(msg, t)
  }

  /**
   * Log a message with WARN level.
   * @param msg The message to be logged. Must not be null!
   */
  def warn(msg: => String) {
    require (msg != null, "msg must not be null!")
    if (slf4jLogger.isWarnEnabled) slf4jLogger warn msg
  }

  /**
   * Log a message with WARN level.
   * @param msg The message to be logged. Must not be null!
   * @param t The Throwable to be logged. Must not be null!
   */
  def warn(msg: => String, t: Throwable) {
    require (msg != null, "msg must not be null!")
    require (t != null, "t must not be null!")
    if (slf4jLogger.isWarnEnabled) slf4jLogger.warn(msg, t)
  }

  /**
   * Log a message with INFO level.
   * @param msg The message to be logged. Must not be null!
   */
  def info(msg: => String) {
    require (msg != null, "msg must not be null!")
    if (slf4jLogger.isInfoEnabled) slf4jLogger info msg
  }

  /**
   * Log a message with INFO level.
   * @param msg The message to be logged. Must not be null!
   * @param t The Throwable to be logged. Must not be null!
   */
  def info(msg: => String, t: Throwable) {
    require (msg != null, "msg must not be null!")
    require (t != null, "t must not be null!")
    if (slf4jLogger.isInfoEnabled) slf4jLogger.info(msg, t)
  }

  /**
   * Log a message with DEBUG level.
   * @param msg The message to be logged. Must not be null!
   */
  def debug(msg: => String) {
    require (msg != null, "msg must not be null!")
    if (slf4jLogger.isDebugEnabled) slf4jLogger debug msg
  }

  /**
   * Log a message with DEBUG level.
   * @param msg The message to be logged. Must not be null!
   * @param t The Throwable to be logged. Must not be null!
   */
  def debug(msg: => String, t: Throwable) {
    require (msg != null, "msg must not be null!")
    require (t != null, "t must not be null!")
    if (slf4jLogger.isDebugEnabled) slf4jLogger.debug(msg, t)
  }

  /**
   * Log a message with TRACE level.
   * @param msg The message to be logged. Must not be null!
   */
  def trace(msg: => String) {
    require (msg != null, "msg must not be null!")
    if (slf4jLogger.isTraceEnabled) slf4jLogger trace msg
  }

  /**
   * Log a message with TRACE level.
   * @param msg The message to be logged. Must not be null!
   * @param t The Throwable to be logged. Must not be null!
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
