/**
 * Copyright (c) 2009-2010 WeigleWilczek and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.weiglewilczek.slf4s

import org.specs.Specification
import org.slf4j.{ Logger => SLF4JLogger, LoggerFactory }

class packageSpec extends Specification {

  "Calling toLogger" should {
    "throw an IAE when called with null" in {
      toLogger(null) must throwA[IllegalArgumentException]
    }
  }

  "A SLF4J Logger" should {
    "be implicitly converted to a (SLF4S) Logger" in {
      val slf4jLogger: SLF4JLogger = LoggerFactory getLogger classOf[String]
      val logger: Logger = slf4jLogger
      logger.name mustEqual slf4jLogger.getName
    }
  }
}
