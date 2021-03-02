package org.logicovercode.base_plugin.all
import org.logicovercode.base_plugin.Version
import sbt._
import sbt.librarymanagement.ModuleID

trait JavaVersionedDependencies {

  val gson_2_8_6 = Version("2.8.6")
  def gson(version: Version = gson_2_8_6): ModuleID = gson(version.version)
  @Deprecated
  def gson(version: String): ModuleID = "com.google.code.gson" % "gson" % version

  val jwt_0_9_1 = Version("0.9.1")
  def jjwt(version: Version = jwt_0_9_1): ModuleID = jjwt(version.version)
  @Deprecated
  def jjwt(version: String): ModuleID = "io.jsonwebtoken" % "jjwt" % version

  val mySqlConnector_8_0_23 = Version("8.0.23")
  def mysql_connector_java(version: Version = mySqlConnector_8_0_23): ModuleID = mysql_connector_java(version.version)
  @Deprecated
  def mysql_connector_java(version: String): ModuleID = "mysql" % "mysql-connector-java" % version
}
