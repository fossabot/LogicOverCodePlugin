package org.logicovercode.base_plugin

import org.logicovercode.base_plugin.all.AllDependencies
import org.logicovercode.base_plugin.docker_containers.DbDockerContainers
import org.logicovercode.base_plugin.licenses.Licenses
import org.logicovercode.base_plugin.resolvers.SbtResolvers
import org.logicovercode.base_plugin.spark.SparkSettings
import org.logicovercode.bsbt.BuilderStyleBuild
import sbt.{AutoPlugin, PluginTrigger, Plugins}

object LogicOverCode extends AutoPlugin {

  object autoImport
      extends SparkSettings
      with AllDependencies
      with SbtResolvers
      with Licenses
      with DbDockerContainers
      with ModuleBuildExtSettings

  override def trigger: PluginTrigger = Plugins.noTrigger

  override def requires: Plugins = BuilderStyleBuild

  override lazy val projectSettings = super.projectSettings
}
