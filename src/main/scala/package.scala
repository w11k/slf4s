package com.weiglewilczek

import org.slf4j.{ Logger => SLF4JLogger }
import slf4s.Logger

package object slf4s {

  /**
   * Implicitly Converts a SLF4JLogger to a Logger.
   * @param slf4jLogger The SLF4JLogger which is to convert
   * @return A new Logger 
   */
  implicit def toLogger(slf4jLogger: SLF4JLogger): Logger = {
    require(slf4jLogger != null, "slf4jLogger must be not null!")
    Logger(slf4jLogger.getName)
  }
}
