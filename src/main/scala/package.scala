package com.weiglewilczek

import org.slf4j.{ Logger => SLF4JLogger }
import slf4s.Logger

package object slf4s {

  /**
   * Implicitly converts a SLF4J Logger to a (SLF4S) Logger.
   * @param slf4jLogger The SLF4J Logger to be converted; must not be null!
   * @return A new (SLF4S) Logger
   */
  implicit def toLogger(slf4jLogger: SLF4JLogger): Logger = {
    require(slf4jLogger != null, "slf4jLogger must be not null!")
    Logger(slf4jLogger.getName)
  }
}
