package org.logicovercode.base_plugin.all

import org.logicovercode.base_plugin.Version
import sbt._

trait DockerDependencies {

  val testContainers_1_15_2 = Version("1.15.2")
  val jdbcTestContainers_1_15_2 = testContainers_1_15_2

  def jdbc_test_containers(version: Version): ModuleID = javaTestContainer(
    version.version
  )

  @Deprecated
  def jdbcTestContainers(version: String = "1.15.2"): ModuleID = {
    "org.testcontainers" % "jdbc" % version
  }

  def test_containers(version: Version): ModuleID = javaTestContainer(
    version.version
  )

  @Deprecated
  def testcontainers(version: Version): ModuleID = javaTestContainer(
    version.version
  )

  @Deprecated
  def testContainers(version: String = "1.15.2"): ModuleID = {
    "org.testcontainers" % "testcontainers" % version
  }

  @Deprecated
  def javaTestContainer(version: String = "1.15.2"): ModuleID = {
    "org.testcontainers" % "testcontainers" % version
  }
}
