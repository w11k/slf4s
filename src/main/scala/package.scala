/**
 * Copyright (c) 2009-2010 WeigleWilczek and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.weiglewilczek

import org.slf4j.{ Logger => SLF4JLogger }
import slf4s.Logger

package object slf4s {

  /**
   * Implicitly converts a SLF4J Logger to a (SLF4S) Logger.
   * @param slf4jLogger The SLF4J Logger to be converted; must not be null!
   * @return A new (SLF4S) Logger
   */
  @deprecated("Converting from SLF4J to SLF4S logger is probably more costly than possible savings through by-name params!")
  implicit def toLogger(slf4jLogger: SLF4JLogger): Logger = {
    require(slf4jLogger != null, "slf4jLogger must be not null!")
    Logger(slf4jLogger.getName)
  }
}
