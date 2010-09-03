/**
 * Copyright (c) 2009-2010 WeigleWilczek and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
import com.weiglewilczek.bnd4sbt._
import sbt._

class SLF4SProject(info: ProjectInfo) extends DefaultProject(info) with BNDPlugin {

  // ===================================================================================================================
  // Dependencies
  // ===================================================================================================================

  // Versions
  val Slf4jVersion = "1.6.1"

  // Compile
  val slf4jApi = "org.slf4j" % "slf4j-api" % Slf4jVersion withSources

  // Test
  val specs = "org.scala-tools.testing" %% "specs" % "1.6.5" % "test" withSources
  val mockito = "org.mockito" % "mockito-all" % "1.8.4" % "test" withSources
  val slf4jSimple = "org.slf4j" % "slf4j-simple" % Slf4jVersion % "test"

  // ===================================================================================================================
  // Publishing
  // ===================================================================================================================

  override def managedStyle = ManagedStyle.Maven
  Credentials(Path.userHome / ".ivy2" / ".credentials", log)
  lazy val publishTo = "Scala Tools Nexus" at "http://nexus.scala-tools.org/content/repositories/releases/"
//  lazy val publishTo = Resolver.file("Local Test Repository", Path fileProperty "java.io.tmpdir" asFile)
  override def packageSrcJar = defaultJarPath("-sources.jar")
  lazy val sourceArtifact = Artifact.sources(artifactID)
  override def packageToPublishActions = super.packageToPublishActions ++ Seq(packageSrc)

  // ===================================================================================================================
  // OSGi stuff
  // ===================================================================================================================

  import ExecutionEnvironment._
  override def bndBundleVendor = Some("WeigleWilczek")
  override def bndBundleLicense =
    Some("Eclipse Public License v1.0 (http://www.eclipse.org/legal/epl-v10.html)")
  override def bndExecutionEnvironment = Set(Java5, Java6)
  override def bndExportPackage =
    "com.weiglewilczek.slf4s;version=\"%s\"".format(projectVersion.value) :: Nil
  override def bndVersionPolicy = Some("[$(@),$(version;=+;$(@)))")
}
