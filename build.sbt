name := """soap-client-with-cxf-using-play"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"
javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

val cxfVersion: String = "3.1.7"

libraryDependencies ++= Seq(
  "org.apache.cxf" % "cxf-rt-frontend-jaxws" % cxfVersion,
  "org.apache.cxf" % "cxf-rt-transports-http" % cxfVersion,
  "org.springframework" % "spring-context" % "4.3.2.RELEASE",

  // Test dependencies
  "junit" % "junit" % "4.12" % "test",
  "org.assertj" % "assertj-core" % "3.5.2" % "test",
  "org.mockito" % "mockito-core" % "1.10.19" % "test"
)

// CXF wsdl2java configuration
Seq(cxf.settings: _*)
cxf.cxfVersion := cxfVersion
cxf.wsdls := Seq(
  cxf.Wsdl((resourceDirectory in Compile).value / "wsdls/globalweather.wsdl", Seq("-mark-generated", "-p", "com.global.weather"), "globalweather")
)
