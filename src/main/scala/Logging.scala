package com.weiglewilczek.slf4s

import org.slf4j.LoggerFactory

/**
 * Declare a Logger using apply
 */
object Logging {
  
  def apply(cls: Class[_]): Logger = {
    new Logger {
      override val slf4jLogger = LoggerFactory getLogger cls
    }
  }
}

/**
 * Mixin providing a Logger
 */
trait Logging {

  protected lazy val logger: Logger = {
    new Logger {
      override val slf4jLogger = LoggerFactory getLogger cls
    }
  }

  private lazy val cls: Class[_] = this.getClass
}