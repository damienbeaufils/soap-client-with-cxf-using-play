// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.5.8")

// https://github.com/ebiznext/sbt-cxf-wsdl2java
resolvers += "Sonatype Repository" at "https://oss.sonatype.org/content/groups/public"
addSbtPlugin("com.ebiznext.sbt.plugins" % "sbt-cxf-wsdl2java" % "0.1.4")

// Useful plugins to deploy to Heroku
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.1.4")
addSbtPlugin("com.heroku" % "sbt-heroku" % "1.0.1")
