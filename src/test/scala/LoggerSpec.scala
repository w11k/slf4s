/**
 * Copyright (c) 2009-2010 WeigleWilczek and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.weiglewilczek.slf4s

import org.slf4j.{ Logger => SLF4JLogger }
import org.specs.Specification
import org.specs.mock.Mockito

class LoggerSpec extends Specification with Mockito {

  "Creating a Logger using Logger(clazz: Class[_])" should {

    "return a Logger namend like the given class" in {
      val clazz = classOf[String]
      Logger(clazz).name mustEqual clazz.getName
    }

    "throw an IAE when creating a Logger with a null class" in {
      Logger(null: Class[_]) must throwA[IllegalArgumentException]
    }
  }

  "Creating a Logger using Logger(name: String)" should {

    "return a Logger namend like the given name" in {
      val name = "MyLogger"
      Logger(name).name mustEqual name
    }

    "throw an IAE when creating a Logger with a null String" in {
      Logger(null: String) must throwA [IllegalArgumentException]
    }
  }

  "Calling Logger.error(msg)" should {
    val (logger, slf4jLogger) = loggers

    "throw an IAE when called with a null message" in {
      logger error null must throwA[IllegalArgumentException]
    }

    "not call SLF4JLogger.error when error not enabled" in {
      slf4jLogger.isErrorEnabled returns false
      logger error Msg
      there was no(slf4jLogger).error(Msg)
    }

    "call SLF4JLogger.error when error enabled" in {
      slf4jLogger.isErrorEnabled returns true
      logger error Msg
      there was one(slf4jLogger).error(Msg)
    }
  }

  "Calling Logger.error(msg, t)" should {
    val (logger, slf4jLogger) = loggers

    "throw an IAE when called with a null message" in {
      logger.error(null, t) must throwA[IllegalArgumentException]
    }

    "throw and IAE when called a null Throwable" in {
      logger.error(Msg, null) must throwA[IllegalArgumentException]
    }

    "not call SLF4JLogger.error when error not enabled" in {
      slf4jLogger.isErrorEnabled returns false
      logger.error(Msg, t)
      there was no(slf4jLogger).error(Msg, t)
    }

    "call SLF4JLogger.error when error enabled" in {
      slf4jLogger.isErrorEnabled returns true
      logger.error(Msg, t)
      there was one(slf4jLogger).error(Msg ,t)
    }
  }

  "Calling Logger.warn(msg)" should {
    val (logger, slf4jLogger) = loggers

    "throw an IAE when called with a null message" in {
      logger warn null must throwA[IllegalArgumentException]
    }

    "not call SLF4JLogger.warn when warn not enabled" in {
      slf4jLogger.isWarnEnabled returns false
      logger warn Msg
      there was no(slf4jLogger).warn(Msg)
    }

    "call SLF4JLogger.warn when warn enabled" in {
      slf4jLogger.isWarnEnabled returns true
      logger warn Msg
      there was one(slf4jLogger).warn(Msg)
    }
  }

  "Calling Logger.warn(msg, t)" should {
    val (logger, slf4jLogger) = loggers

    "throw an IAE when called with a null message" in {
      logger.warn(null, t) must throwA[IllegalArgumentException]
    }

    "throw an IAE when called with a null Throwable" in {
      logger.warn(Msg, null) must throwA[IllegalArgumentException]
    }

    "not call SLF4JLogger.warn when warn not enabled" in {
      slf4jLogger.isErrorEnabled returns false
      logger.warn(Msg, t)
      there was no(slf4jLogger).warn(Msg, t)
    }

    "call SLF4JLogger.warn when warn enabled" in {
      slf4jLogger.isWarnEnabled returns true
      logger.warn(Msg, t)
      there was one(slf4jLogger).warn(Msg ,t)
    }
  }

  "Calling Logger.info(msg)" should {
    val (logger, slf4jLogger) = loggers

    "throw an IAE when called with a null message" in {
      logger info null must throwA[IllegalArgumentException]
    }

    "not call SLF4JLogger.info when info not enabled" in {
      slf4jLogger.isInfoEnabled returns false
      logger info Msg
      there was no(slf4jLogger).info(Msg)
    }

    "call SLF4JLogger.info when info enabled" in {
      slf4jLogger.isInfoEnabled returns true
      logger info Msg
      there was one(slf4jLogger).info(Msg)
    }
  }

  "Calling Logger.info(msg, t)" should {
    val (logger, slf4jLogger) = loggers

    "throw an IAE when called with a null message" in {
      logger.info(null, t) must throwA[IllegalArgumentException]
    }

    "throw an IAE when called with a null Throwable" in {
      logger.info(Msg, null) must throwA[IllegalArgumentException]
    }

    "not call SLF4JLogger.info when info not enabled" in {
      slf4jLogger.isInfoEnabled returns false
      logger.info(Msg, t)
      there was no(slf4jLogger).info(Msg, t)
    }

    "call SLF4JLogger.info when info enabled" in {
      slf4jLogger.isInfoEnabled returns true
      logger.info(Msg, t)
      there was one(slf4jLogger).info(Msg, t)
    }
  }

  "Calling Logger.debug(msg)" should {
    val (logger, slf4jLogger) = loggers

    "throw an IAE when called with a null message" in {
      logger debug null must throwA[IllegalArgumentException]
    }

    "not call SLF4JLogger.debug when debug not enabled" in {
      slf4jLogger.isDebugEnabled returns false
      logger debug Msg
      there was no(slf4jLogger).debug(Msg)
    }

    "call SLF4JLogger.debug when debug enabled" in {
      slf4jLogger.isDebugEnabled returns true
      logger debug Msg
      there was one(slf4jLogger).debug(Msg)
    }
  }

  "Calling Logger.debug(msg ,t)" should {
    val (logger, slf4jLogger) = loggers

    "throw an IAE when called with a null message" in {
      logger.debug(null, t) must throwA[IllegalArgumentException]
    }

    "throw an IAE when called with a null Throwable" in {
      logger.debug(Msg, null) must throwA[IllegalArgumentException]
    }

    "not call SLF4JLogger.debug when debug not enabled" in {
      slf4jLogger.isDebugEnabled returns false
      logger.debug(Msg, t)
      there was no(slf4jLogger).debug(Msg, t)
    }

    "call SLF4JLogger.debug when debug enabled" in {
      slf4jLogger.isDebugEnabled returns true
      logger.debug(Msg, t)
      there was one(slf4jLogger).debug(Msg, t)
    }
  }

  "Calling Logger.trace(msg)" should {
    val (logger, slf4jLogger) = loggers

    "throw an IAE when called with a null message" in {
      logger trace null must throwA[IllegalArgumentException]
    }

    "not call SLF4JLogger.trace when trace not enabled" in {
      slf4jLogger.isTraceEnabled returns false
      logger trace Msg
      there was no(slf4jLogger).trace(Msg)
    }

    "call SLF4JLogger.trace when trace enabled" in {
      slf4jLogger.isTraceEnabled returns true
      logger trace Msg
      there was one(slf4jLogger).trace(Msg)
    }
  }

  "Calling Logger.trace(msg, t)" should {
    val (logger, slf4jLogger) = loggers

    "throw an IAE when called with a null message" in {
      logger.trace(null, t) must throwA[IllegalArgumentException]
    }

    "throw an IAE when called with a null Throwable" in {
      logger.trace(Msg, null) must throwA[IllegalArgumentException]
    }

    "not call SLF4JLogger.trace when trace not enabled" in {
      slf4jLogger.isTraceEnabled returns false
      logger.trace(Msg, t)
      there was no(slf4jLogger).trace(Msg, t)
    }

    "call SLF4JLogger.trace when trace enabled" in {
      slf4jLogger.isTraceEnabled returns true
      logger.trace(Msg, t)
      there was one(slf4jLogger).trace(Msg, t)
    }
  }

  private lazy val Msg = "MESSAGE"

  private lazy val t = new Throwable

  private def loggers = {
    val mockSLF4JLogger = mock[SLF4JLogger]
    val logger = new Logger {
      override protected val slf4jLogger = mockSLF4JLogger
    }
    (logger, mockSLF4JLogger)
  }
}