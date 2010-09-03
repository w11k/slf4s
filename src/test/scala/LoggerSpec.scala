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
    var evaluated = false
    def msg = {
      evaluated = true
      Msg
    }

    "not call SLF4JLogger.error when error not enabled" in {
      slf4jLogger.isErrorEnabled returns false
      logger error msg
      there was no(slf4jLogger).error(Msg)
      evaluated mustBe false
    }

    "call SLF4JLogger.error when error enabled" in {
      slf4jLogger.isErrorEnabled returns true
      logger error msg
      there was one(slf4jLogger).error(Msg)
      evaluated mustBe true
    }
  }

  "Calling Logger.error(msg, t)" should {
    val (logger, slf4jLogger) = loggers
    var evaluated = false
    def msg = {
      evaluated = true
      Msg
    }

    "not call SLF4JLogger.error when error not enabled" in {
      slf4jLogger.isErrorEnabled returns false
      logger.error(msg, t)
      there was no(slf4jLogger).error(Msg, t)
      evaluated mustBe false
    }

    "call SLF4JLogger.error when error enabled" in {
      slf4jLogger.isErrorEnabled returns true
      logger.error(msg, t)
      there was one(slf4jLogger).error(Msg ,t)
      evaluated mustBe true
    }
  }

  "Calling Logger.warn(msg)" should {
    val (logger, slf4jLogger) = loggers
    var evaluated = false
    def msg = {
      evaluated = true
      Msg
    }

    "not call SLF4JLogger.warn when warn not enabled" in {
      slf4jLogger.isWarnEnabled returns false
      logger warn msg
      there was no(slf4jLogger).warn(Msg)
      evaluated mustBe false
    }

    "call SLF4JLogger.warn when warn enabled" in {
      slf4jLogger.isWarnEnabled returns true
      logger warn msg
      there was one(slf4jLogger).warn(Msg)
      evaluated mustBe true
    }
  }

  "Calling Logger.warn(msg, t)" should {
    val (logger, slf4jLogger) = loggers
    var evaluated = false
    def msg = {
      evaluated = true
      Msg
    }

    "not call SLF4JLogger.warn when warn not enabled" in {
      slf4jLogger.isErrorEnabled returns false
      logger.warn(msg, t)
      there was no(slf4jLogger).warn(Msg, t)
      evaluated mustBe false
    }

    "call SLF4JLogger.warn when warn enabled" in {
      slf4jLogger.isWarnEnabled returns true
      logger.warn(msg, t)
      there was one(slf4jLogger).warn(Msg ,t)
      evaluated mustBe true
    }
  }

  "Calling Logger.info(msg)" should {
    val (logger, slf4jLogger) = loggers
    var evaluated = false
    def msg = {
      evaluated = true
      Msg
    }

    "not call SLF4JLogger.info when info not enabled" in {
      slf4jLogger.isInfoEnabled returns false
      logger info msg
      there was no(slf4jLogger).info(Msg)
      evaluated mustBe false
    }

    "call SLF4JLogger.info when info enabled" in {
      slf4jLogger.isInfoEnabled returns true
      logger info msg
      there was one(slf4jLogger).info(Msg)
      evaluated mustBe true
    }
  }

  "Calling Logger.info(msg, t)" should {
    val (logger, slf4jLogger) = loggers
    var evaluated = false
    def msg = {
      evaluated = true
      Msg
    }

    "not call SLF4JLogger.info when info not enabled" in {
      slf4jLogger.isInfoEnabled returns false
      logger.info(msg, t)
      there was no(slf4jLogger).info(Msg, t)
      evaluated mustBe false
    }

    "call SLF4JLogger.info when info enabled" in {
      slf4jLogger.isInfoEnabled returns true
      logger.info(msg, t)
      there was one(slf4jLogger).info(Msg, t)
      evaluated mustBe true
    }
  }

  "Calling Logger.debug(msg)" should {
    val (logger, slf4jLogger) = loggers
    var evaluated = false
    def msg = {
      evaluated = true
      Msg
    }

    "not call SLF4JLogger.debug when debug not enabled" in {
      slf4jLogger.isDebugEnabled returns false
      logger debug msg
      there was no(slf4jLogger).debug(Msg)
      evaluated mustBe false
    }

    "call SLF4JLogger.debug when debug enabled" in {
      slf4jLogger.isDebugEnabled returns true
      logger debug msg
      there was one(slf4jLogger).debug(Msg)
      evaluated mustBe true
    }
  }

  "Calling Logger.debug(msg ,t)" should {
    val (logger, slf4jLogger) = loggers
    var evaluated = false
    def msg = {
      evaluated = true
      Msg
    }

    "not call SLF4JLogger.debug when debug not enabled" in {
      slf4jLogger.isDebugEnabled returns false
      logger.debug(msg, t)
      there was no(slf4jLogger).debug(Msg, t)
      evaluated mustBe false
    }

    "call SLF4JLogger.debug when debug enabled" in {
      slf4jLogger.isDebugEnabled returns true
      logger.debug(msg, t)
      there was one(slf4jLogger).debug(Msg, t)
      evaluated mustBe true
    }
  }

  "Calling Logger.trace(msg)" should {
    val (logger, slf4jLogger) = loggers
    var evaluated = false
    def msg = {
      evaluated = true
      Msg
    }

    "not call SLF4JLogger.trace when trace not enabled" in {
      slf4jLogger.isTraceEnabled returns false
      logger trace msg
      there was no(slf4jLogger).trace(Msg)
      evaluated mustBe false
    }

    "call SLF4JLogger.trace when trace enabled" in {
      slf4jLogger.isTraceEnabled returns true
      logger trace msg
      there was one(slf4jLogger).trace(Msg)
      evaluated mustBe true
    }
  }

  "Calling Logger.trace(msg, t)" should {
    val (logger, slf4jLogger) = loggers
    var evaluated = false
    def msg = {
      evaluated = true
      Msg
    }

    "not call SLF4JLogger.trace when trace not enabled" in {
      slf4jLogger.isTraceEnabled returns false
      logger.trace(msg, t)
      there was no(slf4jLogger).trace(Msg, t)
      evaluated mustBe false
    }

    "call SLF4JLogger.trace when trace enabled" in {
      slf4jLogger.isTraceEnabled returns true
      logger.trace(msg, t)
      there was one(slf4jLogger).trace(Msg, t)
      evaluated mustBe true
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
