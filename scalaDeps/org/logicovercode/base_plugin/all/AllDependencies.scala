package org.logicovercode.base_plugin.all

import org.logicovercode.base_plugin.docker_containers.DockerDependencies
import org.logicovercode.base_plugin.doobie.AllDoobieDependencies
import org.logicovercode.base_plugin.sboot.AllSpringDependencies
import org.logicovercode.base_plugin.spark.SparkDeps
import org.logicovercode.bsbt.core.model.JvmModuleID
import sbt._
import sbt.librarymanagement.ModuleID

trait AllDependencies extends
  SparkDeps with AllSpringDependencies with
  LogicWithCodeDeps with AllDoobieDependencies with DockerDependencies{

  // Versions
  lazy val akkaVersion = "2.6.1"

  // Libraries
  def akkaactor(version: String = akkaVersion): ModuleID = {
    "com.typesafe.akka" %% "akka-actor" % version
  }

  def akkacluster(version: String = akkaVersion): ModuleID = {
    "com.typesafe.akka" %% "akka-cluster" % version
  }

  def akkatest(version: String = akkaVersion): ModuleID = {
    "com.typesafe.akka" %% "akka-testkit" % version
  }

  def akkastream(version: String = akkaVersion): ModuleID = {
    "com.typesafe.akka" %% "akka-stream" % version
  }

  def akkaclient(version: String = "2.4.17"): ModuleID = {
    "com.typesafe.akka" %% "akka-cluster-tools" % version
  }

  def typesafeConfig(version: String = "1.3.4"): ModuleID = {
    "com.typesafe" % "config" % version
  }

  def scalaJavaCompat(version : String = "0.9.1") : ModuleID = {
    "org.scala-lang.modules" %% "scala-java8-compat" % version
  }

  def logging(version: String = "default"): Seq[JvmModuleID] = {
    Seq("com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
      "ch.qos.logback" % "logback-classic" % "1.1.2").map( JvmModuleID(_, None) )
  }

  def junit(version: String = "default"): ModuleID = {
    "junit" % "junit" % "4.12"
//    Seq("org.hamcrest" % "hamcrest-all" % "1.3",
//      "pl.pragmatists" % "JUnitParams" % "1.0.4",
//      "junit" % "junit" % "4.12")
  }

  def scalaz(version: String = "7.2.30"): ModuleID = {
    "org.scalaz" %% "scalaz-core" % version
  }

  def scalalib(version: String = "2.11.7"): ModuleID = {
    "org.scala-lang" % "scala-library" % version
  }

  def scalalib12(version: String = "2.12.2"): ModuleID = {
    "org.scala-lang" % "scala-library" % version
  }

  def mockito(version: String = "1.8.4"): ModuleID = {
    "org.mockito" % "mockito-all" % version
  }

  def easymock(version: String = "3.4"): ModuleID = {
    "org.easymock" % "easymock" % version
  }

  def scalamock(version: String = "3.6.0"): ModuleID = {
    "org.scalamock" %% "scalamock-scalatest-support" % version
  }

  def scalatest(version: String = "3.2.0-M2"): ModuleID = {
    "org.scalatest" %% "scalatest" % version
  }

  def betterfiles(version: String = "3.8.0"): ModuleID = {
    "com.github.pathikrit" %% "better-files" % version
  }

  def guava(version: String = "11.0.2"): ModuleID = {
    "com.google.guava" % "guava" % version
  }

  def guice(version: String = "3.0"): ModuleID = {
    "com.google.inject" % "guice" % version
  }

  def gson(version : String = "2.8.6") : ModuleID = {
    "com.google.code.gson" % "gson" % version
  }

  def jwt(version: String = "0.9.1"): ModuleID = {
    "io.jsonwebtoken" % "jjwt" % "0.9.1"
  }

  @Deprecated
  def akkaconfig(version: String = "1.3.3") : ModuleID = {
    "com.typesafe" % "config" % "1.3.3"
  }

  def mysqlConnector(version: String = "5.1.47") : ModuleID = {
    "mysql" % "mysql-connector-java" % version
  }

  def cats_core(version : String = "2.1.0") : ModuleID = {
    "org.typelevel" %% "cats-core" % version
  }

  def cats_effect(version : String = "2.1.4") : ModuleID = {
    "org.typelevel" %% "cats-effect" % version
  }

  def scalaj_http(version : String = "2.4.2") : ModuleID = {
    "org.scalaj" %% "scalaj-http" % version
  }
}