
organization := "com.weiglewilczek.slf4s"

name := "slf4s"

version := "1.0.7"

scalaVersion := "2.9.1"

crossScalaVersions := Seq(
    "2.8.0",
    "2.8.1",
    "2.9.0-1",
    "2.9.1")

libraryDependencies ++= Seq(
    "org.slf4j" % "slf4j-api" % "1.6.1")

publishTo <<= (version) { v => 
  if (v endsWith "SNAPSHOT")
    Some("ScalaTools-Nexus-Snapshots" at "http://nexus.scala-tools.org/content/repositories/snapshots/")
  else
    Some("ScalaTools-Nexus-Releases" at "http://nexus.scala-tools.org/content/repositories/releases/")
}

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
