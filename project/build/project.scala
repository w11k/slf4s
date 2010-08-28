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
  val slf4jSimple = "org.slf4j" % "slf4j-simple" % Slf4jVersion

  // ===================================================================================================================
  // OSGi stuff
  // ===================================================================================================================

  
}
