package com.weiglewilczek.slf4s

import org.slf4j.{ Logger => SLF4JLogger }
import org.specs.Specification
import org.specs.mock.Mockito


class LoggingSpec extends Specification with Mockito {
  val slf4jLogger = mock[SLF4JLogger]
  val msg = ""
  val t = new Throwable
  
  "Calling Logger.info(msg)" should {
    val logger = new Logger {
      override protected val logger = slf4jLogger
    }

    "throw an IAE when called with a null message" in {
      logger.info(null) must throwA[IllegalArgumentException]
    }

    "not call SLF4JLogger.info when info is not enabled" in {
      slf4jLogger.isInfoEnabled returns false
      logger.info(msg)
      there was no(slf4jLogger).info(msg)
    }

    "call SLF4JLogger.info when info is enabled" in {
      slf4jLogger.isInfoEnabled returns true
      logger.info(msg)
      there was one(slf4jLogger).info(msg)
    }
  }

  "Calling Logger.info(msg, t)" should {
    val logger = new Logger {
      override protected val logger = slf4jLogger
    }

    "throw an IAE when called msg with a null message and t as Throwable" in {
      logger.info(null, t) must throwA[IllegalArgumentException]
    }

    "throw an IAE when called t with a null message and msg as a String" in {
      logger.info(msg,null) must throwA[IllegalArgumentException]
    }

    "not call SLF4JLogger.info when info is not enabled" in {
      slf4jLogger.isInfoEnabled returns false
      logger.info(msg, t)
      there was no(slf4jLogger).info(msg, t)
    }

    "call SLF4JLogger.info when info is enabled" in {
      slf4jLogger.isInfoEnabled returns true
      logger.info(msg, t)
      there was one(slf4jLogger).info(msg, t)
    }
  }

  "Calling Logger.debug(msg)" should {
    val logger = new Logger {
      override protected val logger = slf4jLogger
    }

    "throw an IAE when called with a null message" in {
      logger.debug(null) must throwA[IllegalArgumentException]
    }

    "not call SLF4JLogger.debug when info is not enabled" in {
      slf4jLogger.isDebugEnabled returns false
      logger.debug(msg)
      there was no(slf4jLogger).debug(msg)
    }

    "call SLF4JLogger.debug when info is enabled" in {
      slf4jLogger.isDebugEnabled returns true
      logger.debug(msg)
      there was one(slf4jLogger).debug(msg)
    }
  }

  "Calling Logger.debug(msg ,t)" should {
    val logger = new Logger {
      override protected val logger = slf4jLogger
    }

    "throw an IAE when called msg with a null message and t as Throwable" in {
      logger.debug(null,t) must throwA[IllegalArgumentException]
    }

    "throw an IAE when called t with a null message and msg as a String" in {
      logger.debug(msg,null) must throwA[IllegalArgumentException]
    }

    "not call SLF4JLogger.debug when debug is not enabled" in {
      slf4jLogger.isDebugEnabled returns false
      logger.debug(msg, t)
      there was no(slf4jLogger).debug(msg,t)
    }

    "call SLF4JLogger.debug when debug is enabled" in {
      slf4jLogger.isDebugEnabled returns true
      logger.debug(msg, t)
      there was one(slf4jLogger).debug(msg, t)
    }
  }

  "Calling Logger.error(msg)" should {
    val logger = new Logger {
      override protected val logger = slf4jLogger
    }

    "throw an IAE when called msg with a null message" in {
      logger.error(null) must throwA[IllegalArgumentException]
    }

    "not call SLF4JLogger.error(msg) when is not enabled" in {
      slf4jLogger.isErrorEnabled returns false
      logger.error(msg)
      there was no(slf4jLogger).error(msg)
    }

    "call SLF4JLogger.error(msg) when is enabled" in {
      slf4jLogger.isErrorEnabled returns true
      logger.error(msg)
      there was one(slf4jLogger).error(msg)
    }
  }

  "Calling Logger.error(msg, t)" should {
    val logger = new Logger {
      override protected val logger = slf4jLogger
    }

    "throw an IAE when called msg with a null message and t as Throwable" in {
      logger.error(null, t) must throwA[IllegalArgumentException]
    }

    "throw and IAE when called t with a null message and msg as a String" in {
      logger.error(msg, null) must throwA[IllegalArgumentException]
    }

    "not call SLF4JLogger.error when error is not enabled" in {
      slf4jLogger.isErrorEnabled returns false
      logger.error(msg, t)
      there was no(slf4jLogger).error(msg, t)
    }

    "call SLF4JLogger.error when error is enabled" in {
      slf4jLogger.isErrorEnabled returns true
      logger.error(msg, t)
      there was one(slf4jLogger).error(msg ,t)
    }
  }

  "Calling Logger.warn(msg)" should {
    val logger = new Logger {
      override protected val logger = slf4jLogger
    }

    "throw an IAE when called msg with a null message" in {
      logger.warn(null) must throwA[IllegalArgumentException]
    }

    "not call SLF4JLogger.warn(msg) when is not enabled" in {
      slf4jLogger.isWarnEnabled returns false
      logger.warn(msg)
      there was no(slf4jLogger).warn(msg)
    }

    "call SLF4JLogger.warn(msg) when is enabled" in {
      slf4jLogger.isWarnEnabled returns true
      logger.warn(msg)
      there was one(slf4jLogger).warn(msg)
    }
  }

  "Calling Logger.warn(msg, t)" should {
    val logger = new Logger {
      override protected val logger = slf4jLogger
    }

    "throw an IAE when called msg with a null message and t as Throwable" in {
      logger.warn(null, t) must throwA[IllegalArgumentException]
    }

    "throw and IAE when called t with a null message and msg as a String" in {
      logger.warn(msg, null) must throwA[IllegalArgumentException]
    }

    "not call SLF4JLogger.warn when error is not enabled" in {
      slf4jLogger.isErrorEnabled returns false
      logger.warn(msg, t)
      there was no(slf4jLogger).warn(msg, t)
    }
    
    "call SLF4JLogger.warn when error is enabled" in {
      slf4jLogger.isWarnEnabled returns true
      logger.warn(msg, t)
      there was one(slf4jLogger).warn(msg ,t)
    }
  }
}