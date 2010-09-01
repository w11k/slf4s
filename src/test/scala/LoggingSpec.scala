/**
 * Copyright (c) 2009-2010 WeigleWilczek and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.weiglewilczek.slf4s

import org.specs.Specification

class LoggingSpec extends Specification {

  "Mixing Logging into SomeClass" should {
    "yield a Logger named to SomeClass's FQCN" in {
      val someClass = new SomeClass
      someClass.logger.name mustEqual classOf[SomeClass].getName
    }
  }
}

class SomeClass extends Logging
