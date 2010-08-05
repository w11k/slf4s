package com.weiglewilczek.slf4s

import org.slf4j.{Logger => SLF4JLogger, LoggerFactory}

/**
 * Logger is a wrapper for the SLF4J
 *
 */
trait Logger {
  def info(msg: => String) {
    require (msg != null, "msg must not be null!")
    if (logger.isInfoEnabled) logger info msg
  }

  def info(msg: => String, t: Throwable) {
    require (msg != null, "msg must not be null!")
    require (t != null, "t must not be null!")
    if (logger.isInfoEnabled) logger.info(msg, t)
  }

  def debug(msg: => String){
    require (msg != null, "msg must not be null!")
    if (logger.isDebugEnabled) logger debug msg
  }

  def debug(msg: => String, t: Throwable) {
    require (msg != null, "msg must not be null!")
    require (t != null, "t must not be null!")
    if (logger.isDebugEnabled) logger.debug(msg, t)
  }

  def error(msg: => String){
    require (msg != null, "msg must not be null!")
    if (logger.isErrorEnabled) logger error msg
  }

  def error(msg: => String, t:Throwable){
    require (msg != null, "msg must not be null!")
    require (t != null, "t must not be null!")
    if (logger.isErrorEnabled) logger.error(msg, t)
  }

  def warn(msg: => String){
    require (msg != null, "msg must not be null!")
    if (logger.isWarnEnabled) logger warn msg
  }

  def warn(msg: => String, t:Throwable){
    require (msg != null, "msg must not be null!")
    require (t != null, "msg must not be null!")
    if (logger.isWarnEnabled) logger.warn(msg, t)
  }

  protected val logger: SLF4JLogger
}
