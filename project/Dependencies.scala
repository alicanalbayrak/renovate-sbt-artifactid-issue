import sbt.*
import sbt.Keys.*

object Dependencies extends AutoPlugin {

  override def trigger = allRequirements

  override def buildSettings: Seq[Def.Setting[?]] = Seq(
    scalaVersion := "2.13.14"
  )

  object autoImport {

    val ScalacheckShapeless116 = "com.github.alexarchambault" %% "scalacheck-shapeless_1.16" % "1.3.1"
  }
}
