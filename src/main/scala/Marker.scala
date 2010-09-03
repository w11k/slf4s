package com.weiglewilczek.slf4s

import java.util.{ Iterator => JIterator }
import org.slf4j.{ Marker => SLFMarker }
import scala.collection.JavaConversions.{ asIterator, IteratorWrapper }
import scala.collection.{ mutable, immutable, generic }

object Marker {
  val AnyMarker        = org.slf4j.Marker.ANY_MARKER
  val AnyNonNullMarker = org.slf4j.Marker.ANY_NON_NULL_MARKER
  
  implicit def fromSLFMarker(x: SLFMarker): Marker =
    apply(x.getName) ++= (x.iterator() map (_.asInstanceOf[SLFMarker]))

  def apply(name: String): Marker = new SimpleMarker(name)
  def apply(name: String, refs: SLFMarker*): Marker = new SimpleMarker(name) ++= refs
}
import Marker._

class SimpleMarker(val name: String) extends Marker {
  private val _references = mutable.HashSet[SLFMarker]()
  def references: Set[SLFMarker] = _references.toSet - this
  def ++=(refs: TraversableOnce[SLFMarker]): this.type = { refs foreach += ; this }
  def +=(ref: SLFMarker): this.type = { _references += ref ; this }
  def -=(ref: SLFMarker): this.type = { _references -= ref ; this }
  def remove(ref: SLFMarker): Boolean = { _references remove ref }
}

trait Marker extends SLFMarker {
  def name: String
  def references: Set[SLFMarker]
  def ++=(refs: TraversableOnce[SLFMarker]): this.type
  def +=(ref: SLFMarker): this.type
  def -=(ref: SLFMarker): this.type
  def remove(reference: SLFMarker): Boolean
  
  def getName(): String         = name
  def add(ref: SLFMarker): Unit = +=(ref)
  
  @deprecated("use hasReferences()")
  def hasChildren(): Boolean   = references.nonEmpty
  def hasReferences(): Boolean = references.nonEmpty

  def iterator(): JIterator[_] = new IteratorWrapper(references.iterator)
  def contains(other: SLFMarker): Boolean = (other != null) && (deepReferences contains other)
  def contains(name: String): Boolean  = (name != null) && (deepReferences exists (_.name == name))

  def deepReferences: Set[SLFMarker] = {  
    def loop(xs: Set[SLFMarker], out: Set[SLFMarker]): Set[SLFMarker] = {
      val undone = out -- xs
      if (undone.isEmpty) xs
      else loop(xs ++ out - this, undone flatMap (_.references))
    }
    loop(Set(), references)
  }
  def isEmpty: Boolean = references.isEmpty
  
  override def equals(other: Any) = other match {
    case x: Marker  => name == x.name
    case _          => false
  }
  override def hashCode = name.hashCode
  override def toString = name
}
