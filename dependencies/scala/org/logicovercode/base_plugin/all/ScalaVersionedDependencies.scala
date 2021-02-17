package org.logicovercode.base_plugin.all

import org.logicovercode.base_plugin.Version
import sbt.librarymanagement.ModuleID
import sbt._

trait ScalaVersionedDependencies {

  val catsCore_2_4_1 = Version("2.4.1")
  def cats_core(version: Version): ModuleID = cats_core(version.version)
  @Deprecated
  def cats_core(version: String = "2.4.1"): ModuleID = {
    "org.typelevel" %% "cats-core" % version
  }

  val catsEffect_2_3_1 = Version("2.3.1")
  def cats_effect(version: Version): ModuleID = cats_effect(version.version)
  @Deprecated
  def cats_effect(version: String = "2.3.1"): ModuleID = {
    "org.typelevel" %% "cats-effect" % version
  }

  val scalajHttp_2_4_2 = Version("2.4.2")
  def scalaj_http(version: Version): ModuleID = scalaj_http(version.version)
  @Deprecated
  def scalaj_http(version: String = "2.4.2"): ModuleID = {
    "org.scalaj" %% "scalaj-http" % version
  }

  val scalaTest_3_2_3 = Version("3.2.3")
  def scalatest(version: Version): ModuleID = scalatest(version.version)
  @Deprecated
  def scalatest(version: String = "3.2.3"): ModuleID = {
    "org.scalatest" %% "scalatest" % version
  }

  val betterFiles_3_9_1 = Version("3.9.1")
  def better_files(version: Version): ModuleID = better_files(version.version)
  @Deprecated
  def better_files(version: String = "3.9.1"): ModuleID = {
    "com.github.pathikrit" %% "better-files" % version
  }

  val scalaJava8Compat_0_9_1 = Version("0.9.1")
  def scala_java8_compat(version: Version): ModuleID = scalaJavaCompat(
    version.version
  )
  @Deprecated
  def scalaJavaCompat(version: String = "0.9.1"): ModuleID = {
    "org.scala-lang.modules" %% "scala-java8-compat" % version
  }

  val jacksonModuleScala_2_12_1 = Version("2.12.1")
  def jackson_module_scala(version: Version): ModuleID = scalaJackson(
    version.version
  )
  @Deprecated
  def scalaJackson(version: String = "2.12.1"): ModuleID = {
    "com.fasterxml.jackson.module" %% "jackson-module-scala" % version
  }

  val scalaParallelCollections_1_0_0 = Version("1.0.0")
  def scala_parallel_collections(version: Version): ModuleID =
    scalaParallelCollections(version.version)
  @Deprecated
  def scalaParallelCollections(version: String = "1.0.0"): ModuleID = {
    "org.scala-lang.modules" %% "scala-parallel-collections" % version
  }
}
