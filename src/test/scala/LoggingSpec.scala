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
