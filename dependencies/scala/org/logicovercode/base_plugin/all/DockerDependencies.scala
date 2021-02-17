package org.logicovercode.base_plugin.all

import org.logicovercode.base_plugin.Version
import sbt._

trait DockerDependencies {

  val testContainers_1_15_2 = Version("1.15.2")
  def testcontainers(version: Version): ModuleID = javaTestContainer(
    version.version
  )
  @Deprecated
  def javaTestContainer(version: String = "1.15.2"): ModuleID = {
    "org.testcontainers" % "testcontainers" % version
  }
}
