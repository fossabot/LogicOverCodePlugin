package org.logicovercode.base_plugin.doobie

import sbt._
import sbt.librarymanagement.ModuleID

trait AllDoobieDependencies {

  case class DoobieVersion(value: String)

  final val doobieVersion_0_9_0 = DoobieVersion("0.9.0")

  case class DoobieDependencies(version : DoobieVersion){
    def core() : ModuleID = {
      "org.tpolecat" %% "doobie-core" % version.value
    }

    def specs2() : ModuleID = {
      "org.tpolecat" %% "doobie-specs2" % version.value
    }

    def postgres() : ModuleID = {
      "org.tpolecat" %% "doobie-postgres" % version.value
    }
  }
}
