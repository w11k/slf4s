package com.weiglewilczek

import org.slf4j.{ Logger => SLF4JLogger }
import slf4s.{ Logger => SLF4SLogger }

package object slf4s {

  /**
   * Implicitly Converts a SLF4JLogger to a SLF4SLogger 
   */
  implicit def toSLF4SLogger(slf4jLogger: SLF4JLogger): SLF4SLogger = {
    require(slf4jLogger != null, "slf4jLogger must be not null!")
    SLF4SLogger(slf4jLogger.getName)
  }
}