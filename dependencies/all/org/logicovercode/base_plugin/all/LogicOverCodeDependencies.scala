package org.logicovercode.base_plugin.all

import org.logicovercode.base_plugin.Version
import sbt.librarymanagement.ModuleID
import sbt._

trait LogicOverCodeDependencies {

  val jProcProxy_0_0_1 = Version("0.0.1")
  def jproc_proxy(version: Version = jProcProxy_0_0_1): ModuleID = jproc_proxy(version.version)
  @Deprecated
  def jproc_proxy(version: String): ModuleID = "com.logicovercode" %% "jproc-proxy" % version

  val jThread_0_0_1 = Version("0.0.1")
  def jthread(version: Version = jThread_0_0_1): ModuleID = jthread(version.version)
  @Deprecated
  def jthread(version: String): ModuleID = "com.logicovercode" %% "jthread" % version

  val tcDb_0_0_1 = Version("0.0.1")
  def tc_db(version: Version = tcDb_0_0_1): ModuleID = tc_db(version.version)
  @Deprecated
  def tc_db(version: String): ModuleID = "com.logicovercode" %% "tc-db" % version

  val tcProcess_0_0_1 = Version("0.0.1")
  def tc_process(version: Version = tcProcess_0_0_1): ModuleID = tc_process(version.version)
  @Deprecated
  def tc_process(version: String): ModuleID = "com.logicovercode" %% "tc-process" % version

  val jsonizer_0_0_1 = Version("0.0.1")
  def jsonizer(version: Version = jsonizer_0_0_1): ModuleID = jsonizer(version.version)
  @Deprecated
  def jsonizer(version: String): ModuleID = "com.logicovercode" %% "jsonizer" % version

  val jawrCore_0_0_1 = Version("0.0.1")
  def jawt_core(version: Version = jawrCore_0_0_1): ModuleID = jawt_core(version.version)
  @Deprecated
  def jawt_core(version: String): ModuleID = "com.logicovercode" %% "jsonizer" % version
}
