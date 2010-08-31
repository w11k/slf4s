package com.weiglewilczek.slf4s

import org.specs.Specification
import org.slf4j.{ Logger => SLF4JLogger, LoggerFactory }

class sl4fsSpec extends Specification {

  "Calling toSLF4SLogger" should {

    "throw an IAE when called with null" in {
      toSLF4SLogger(null) must throwA[IllegalArgumentException]
    }
  }

  "A SLF4JLogger" should {

    "be implicitly converted into a Logger" in {
      val slf4jLogger: SLF4JLogger = LoggerFactory getLogger classOf[String]
      val logger: Logger = slf4jLogger
      logger.name mustEqual slf4jLogger.getName
    }
  }
}
