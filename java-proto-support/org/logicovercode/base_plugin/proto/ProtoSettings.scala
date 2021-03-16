package org.logicovercode.base_plugin.proto


import org.logicovercode.base_plugin.Version
import org.logicovercode.bsbt.core.model.ModuleBuild
import sbt._
import sbtprotoc.ProtocPlugin.autoImport.{AsProtocPlugin, PB}

trait ProtoSettings {

  val grpcVersion_1_36_0 = Version("1.36.0")

  case class GrpcDependencies(version : Version = grpcVersion_1_36_0){
    def protoGenGrpcJavaAsProtocPlugin() : ModuleID = {
      ("io.grpc" % "protoc-gen-grpc-java" % version.version) asProtocPlugin()
    }

    def grpcAll() : ModuleID = {
      "io.grpc" % "grpc-all" % version.version
    }
  }

  implicit class ModuleBuildArtifactProtoExtension(moduleBuild: ModuleBuild) {

    def protoGenTargetDirectories(generatedJavaPath : String, generatedGrpcPath : String) : ModuleBuild = {

      val _settings : Seq[Def.Setting[_]] = Seq(
        PB.targets in Compile := Seq(
          PB.gens.java -> new File(generatedJavaPath),
          PB.gens.plugin("grpc-java") -> new File(generatedGrpcPath)
        )
      )

      val allSettings = moduleBuild.settings.toSet ++ _settings
      ModuleBuild(allSettings)
    }
  }


}
