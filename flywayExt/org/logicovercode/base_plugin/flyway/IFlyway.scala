package org.logicovercode.base_plugin.flyway

import io.github.davidmweber.FlywayPlugin.autoImport._
import sbt.Def

trait IFlyway {

  def flyWaySettings(_flywayUrl: String = "", _flywayUser: String = "", _flywayPassword: String = "2.11.7",
                     _flywayLocations : Seq[String],
                     _flywayBaselineOnMigrate : Boolean = true) :Set[Def.Setting[_]] = {
    Set(
      flywayUrl := _flywayUrl,
      flywayUser := _flywayUser,
      flywayPassword := _flywayPassword,
      flywayLocations := _flywayLocations,
      // Necessary for initializing metadata table
      flywayBaselineOnMigrate := _flywayBaselineOnMigrate
    )
  }
}
