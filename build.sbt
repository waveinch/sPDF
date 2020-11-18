
name := "sPDF"

description := "Create PDFs using plain old HTML+CSS. Uses wkhtmltopdf on the back-end which renders HTML using Webkit."

homepage := Some(url("https://github.com/cloudify/sPDF"))

startYear := Some(2013)

licenses := Seq(
  ("MIT", url("http://opensource.org/licenses/MIT"))
)

organization := "io.github.cloudify"

scalaVersion := "2.13.0"



scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-encoding", "UTF-8"
)

fork in Test := true

parallelExecution in Test := false

logLevel in compile := Level.Warn

// add dependencies on standard Scala modules, in a way
// supporting cross-version publishing
// taken from: http://github.com/scala/scala-module-dependency-sample
libraryDependencies := {
  CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, scalaMajor)) if scalaMajor >= 11 =>
      libraryDependencies.value ++ Seq(
        "org.scala-lang.modules" %% "scala-xml" % "1.2.0",
        "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2"
      )
    case _ =>
      libraryDependencies.value
  }
}

libraryDependencies ++= Seq (
  "org.scalatest"   %% "scalatest"      % "3.0.8"   % "test",
  "org.mockito"     %  "mockito-all"    % "1.10.8"  % "test"
)

// publishing
publishMavenStyle := true


bintrayRepository := "maven"
bintrayOrganization := Some("waveinch")
publishMavenStyle := true
licenses += ("Apache-2.0", url("http://www.opensource.org/licenses/apache2.0.php"))
git.useGitDescribe := true

lazy val root = (project in file(".")).enablePlugins(GitVersioning)