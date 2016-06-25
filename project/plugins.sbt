// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.5.4")

// https://github.com/ebiznext/sbt-cxf-wsdl2java
resolvers += "Sonatype Repository" at "https://oss.sonatype.org/content/groups/public"
addSbtPlugin("com.ebiznext.sbt.plugins" % "sbt-cxf-wsdl2java" % "0.1.4")
