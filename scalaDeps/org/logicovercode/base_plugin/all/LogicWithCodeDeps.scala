package org.logicovercode.base_plugin.all

import sbt.librarymanagement.ModuleID
import sbt._

trait LogicWithCodeDeps {
  def lang_utils(version: String = "1.0-SNAPSHOT") : ModuleID = {
    "org.mogli" %% "langutils" % version
  }
}
