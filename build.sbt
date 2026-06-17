
val scala3Version = "3.8.4"
val walkerVersion = "0.1.0"

val bytePackVersion = "4939c6be7e"

lazy val model = project
  .in(file("model"))
  .settings(
    name := "model",
    version := walkerVersion,

    scalaVersion := scala3Version,
    libraryDependencies += "com.github.scopt" %% "scopt" % "4.1.0" cross(CrossVersion.for3Use2_13),
    libraryDependencies += "com.github.pathikrit" %% "better-files" % "3.9.2",
    libraryDependencies += "org.apache.commons" % "commons-math3" % "3.6.1",

    libraryDependencies ++= Seq(
      "dev.optics" %% "monocle-core"  % "3.3.0",
      "dev.optics" %% "monocle-macro" % "3.3.0",
    ),

    resolvers += "osgeo" at "https://repo.osgeo.org/repository/release/",
    libraryDependencies += "com.outr" %% "scribe" % "3.17.0",
    //libraryDependencies += "org.virtuslab" %% "scala-yaml" % "0.0.8"
    libraryDependencies += "io.circe" %% "circe-yaml" % "0.14.2",
    libraryDependencies ++= Seq(
      "io.circe" %% "circe-core",
      "io.circe" %% "circe-generic",
      "io.circe" %% "circe-parser",
      //"io.circe" %% "circe-generic-extras"
    ).map(_ % "0.14.9"),


    resolvers += "jitpack" at "https://jitpack.io",
    libraryDependencies += "com.github.openmole.byte-pack" %% "byte-pack" % bytePackVersion,
    libraryDependencies += "com.github.openmole.byte-pack" %% "byte-pack-monocle" % bytePackVersion,
    libraryDependencies += "org.apache.commons" % "commons-compress" % "1.28.0",
    libraryDependencies += "org.tukaani" % "xz" % "1.12",

    assemblyPackageScala / assembleArtifact := false,
    assemblyMergeStrategy := { _ => MergeStrategy.first }
  )

