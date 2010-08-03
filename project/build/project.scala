import com.weiglewilczek.bnd4sbt._
import sbt._

class SLF4SProject(info: ProjectInfo) extends DefaultProject(info) with BNDPlugin {

  // ===================================================================================================================
  // Dependencies
  // ===================================================================================================================

  // Compile
  val slf4jApi = "org.slf4j" % "slf4j-api" % "1.6.1" withSources

  // Test
  val specs = "org.scala-tools.testing" %% "specs" % "1.6.5" % "test" withSources
  val mockito = "org.mockito" % "mockito-all" % "1.8.4" % "test" withSources

  // ===================================================================================================================
  // OSGi stuff
  // ===================================================================================================================

  
}
