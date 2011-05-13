import com.weiglewilczek.bnd4sbt._
import sbt._

class Project(info: ProjectInfo) extends DefaultProject(info) with BNDPlugin {

  // ===================================================================================================================
  // Dependencies
  // ===================================================================================================================

  // Repositories
//  val sts = ScalaToolsSnapshots

  // Versions
  val Slf4jVersion = "1.6.1"

  // Compile
  val slf4jApi = "org.slf4j" % "slf4j-api" % Slf4jVersion withSources

  // Test
  val (specs, mockito) = {
    def specs(version: String) = ("org.scala-tools.testing" %% "specs" % version % "test").withSources
    def mockito(version: String) = ("org.mockito" % "mockito-all" % version % "test").withSources
    buildScalaVersion match {
      case "2.8.0" => specs("1.6.5") -> mockito("1.8.4")
      case "2.8.1" => specs("1.6.7.1") -> mockito("1.8.5")
      case s if (s startsWith "2.9.0") => specs("1.6.8") -> mockito("1.8.5")
      case _ => error("No clue what versions for specs and mockito to use!")
    }
  }
  val logback = "ch.qos.logback" % "logback-classic" % "0.9.28" % "test"

  // ===================================================================================================================
  // Publishing
  // ===================================================================================================================

  override def managedStyle = ManagedStyle.Maven
  Credentials(Path.userHome / ".ivy2" / ".credentials", log)
//  lazy val publishTo = "Scala Tools Nexus" at "http://nexus.scala-tools.org/content/repositories/releases/"
  lazy val publishTo = "Scala Tools Nexus" at "http://nexus.scala-tools.org/content/repositories/snapshots/"
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
    Some("Apache 2.0 License (http://www.apache.org/licenses/LICENSE-2.0.html)")
  override def bndExecutionEnvironment = Set(Java5, Java6)
  override def bndExportPackage =
    "com.weiglewilczek.slf4s;version=\"%s\"".format(projectVersion.value) :: Nil
  override def bndImportPackage =
    "org.slf4j;version=\"[1.6,2.0)\"" :: "org.slf4j.spi;version=\"[1.6,2.0)\"" ::super.bndImportPackage.toList
  override def bndVersionPolicy = Some("[$(@),$(version;=+;$(@)))")
}
