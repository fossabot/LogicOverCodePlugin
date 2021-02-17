package org.logicovercode.base_plugin.all
import org.logicovercode.base_plugin.Version
import sbt._
import sbt.librarymanagement.ModuleID

trait JavaVersionedDependencies {

  val gson_2_8_6 = Version("2.8.6")
  def gson(version: Version): ModuleID = gson(version.version)
  @Deprecated
  def gson(version: String = "2.8.6"): ModuleID = {
    "com.google.code.gson" % "gson" % version
  }

  val jwt_0_9_1 = Version("0.9.1")
  def jjwt(version: Version): ModuleID = jwt(version.version)
  @Deprecated
  def jwt(version: String = "0.9.1"): ModuleID = {
    "io.jsonwebtoken" % "jjwt" % "0.9.1"
  }

  val mySqlConnector_8_0_23 = Version("8.0.23")
  def mysql_connector_java(version: Version): ModuleID = mysqlConnector(
    version.version
  )
  @Deprecated
  def mysqlConnector(version: String = "8.0.23"): ModuleID = {
    "mysql" % "mysql-connector-java" % version
  }
}
