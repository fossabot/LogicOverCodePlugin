package org.logicovercode.base_plugin.all

import org.logicovercode.base_plugin.Version
import sbt._
import sbt.librarymanagement.ModuleID

trait Jdk11Dependencies {

  val jaxbApi_2_3_0 = Version("2.3.0")
  def jaxb_api(version: Version = jaxbApi_2_3_0): ModuleID = jaxb_api(version.version)
  @Deprecated
  def jaxb_api(version: String): ModuleID = "javax.xml.bind" % "jaxb-api" % version

  val activation_1_1_1 = Version("1.1.1")
  def activation(version: Version = activation_1_1_1): ModuleID = activation(version.version)
  @Deprecated
  def activation(version: String): ModuleID = "javax.activation" % "activation" % "1.1.1"
}
