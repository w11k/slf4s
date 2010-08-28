package com.weiglewilczek.slf4s

import org.slf4j.LoggerFactory

/**
 * Mixin providing a Logger for the type mixed into.
 */
trait Logging {

  /**
   * Logger for the type mixed into.
   */
  protected[slf4s] lazy val logger = Logger(this.getClass)
}
