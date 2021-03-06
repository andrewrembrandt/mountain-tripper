// Comment to get more information during initialization
logLevel := Level.Warn

// Resolvers
//resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"
resolvers += Resolver.sonatypeRepo("snapshots")

// Sbt plugins
addSbtPlugin("se.marcuslonnberg" % "sbt-docker" % "1.4.1")

// TODO: Fix this outdated plugin
//addSbtPlugin("com.terradatum" % "sbt-docker-helper" % "0.7.0-SNAPSHOT")

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.6.3")

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.5")

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.19")

addSbtPlugin("com.vmunier" % "sbt-web-scalajs" % "1.0.6")

addSbtPlugin("com.typesafe.sbt" % "sbt-gzip" % "1.0.2")

addSbtPlugin("com.typesafe.sbt" % "sbt-digest" % "1.1.3")

