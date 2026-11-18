
val bytePackVersion = "aac91e43dc"

ThisBuild / version := "0.1.0"
ThisBuild / scalaVersion := "3.9.0"


lazy val model = project
  .in(file("model"))
  .settings(
    name := "model",

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
    libraryDependencies += "com.github.openmole.byte-pack" %% "byte-pack-file" % bytePackVersion,
    libraryDependencies += "org.apache.commons" % "commons-compress" % "1.28.0",
    libraryDependencies += "org.tukaani" % "xz" % "1.12",

//    assemblyPackageScala / assembleArtifact := false,
//    assemblyMergeStrategy := { _ => MergeStrategy.first }
  )


lazy val prepare = project
  .in(file("prepare"))
  .settings(
    name := "prepare"
  ) dependsOn(model)
