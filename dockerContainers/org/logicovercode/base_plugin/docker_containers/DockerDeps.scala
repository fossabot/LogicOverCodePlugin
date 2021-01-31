package org.logicovercode.base_plugin.docker_containers

import sbt._
import sbt.librarymanagement.ModuleID

trait DockerDependencies {

  def javaTestContainer(version: String = "1.15.1") : ModuleID = {
    "org.testcontainers" % "testcontainers" % version
  }
}
