package org.logicovercode.base_plugin.proto

import org.logicovercode.base_plugin.Version
import org.logicovercode.bsbt.core.model.ModuleBuild
import sbt._
import sbtprotoc.ProtocPlugin.autoImport.{AsProtocPlugin, PB}

trait ProtoSettings {

  val grpcVersion_1_36_0 = Version("1.36.0")

  case class GrpcDependencies(version: Version = grpcVersion_1_36_0) {
    def protoGenGrpcJavaAsProtocPlugin(): ModuleID = {
      ("io.grpc" % "protoc-gen-grpc-java" % version.version) asProtocPlugin ()
    }

    def grpcAll(): ModuleID = {
      "io.grpc" % "grpc-all" % version.version
    }
  }

  implicit class ModuleBuildArtifactProtoExtension(moduleBuild: ModuleBuild) {

    @Deprecated
    def protoGenTargetDirectories(generatedJavaPath: String, generatedGrpcPath: String): ModuleBuild = {

      val _settings: Seq[Def.Setting[_]] = Seq(
        PB.targets in Compile := Seq(
          PB.gens.java -> new File(generatedJavaPath),
          PB.gens.plugin("grpc-java") -> new File(generatedGrpcPath)
        )
      )

      val allSettings = moduleBuild.settings.toSet ++ _settings
      ModuleBuild(allSettings)
    }

    def protoSourceDirectories(sourceDirs: String*): ModuleBuild = {
      val protoSourceDirectories = sourceDirs.map(new File(_))

      val _settings: Seq[Def.Setting[_]] = Seq(
        PB.protoSources in Compile := protoSourceDirectories
      )
      val allSettings = moduleBuild.settings.toSet ++ _settings
      ModuleBuild(allSettings)
    }

    def protoJavaTargetDir(protoBufferCodeGenDir: String): ModuleBuild = {
      protoJavaTargetDir(protoBufferCodeGenDir, None)
    }

    def protoJavaTargetDir(protoBufferCodeGenDir: String, grpcCodeGenDir: String): ModuleBuild = {
      protoJavaTargetDir(protoBufferCodeGenDir, Option(grpcCodeGenDir))
    }

    private def protoJavaTargetDir(protoBufferCodeGenDir: String, grpcCodeGenDir: Option[String]): ModuleBuild = {

      val _settings: Seq[Def.Setting[_]] = Seq(
        Compile / PB.targets := (grpcCodeGenDir match {
          case Some(grpcDir) => Seq(PB.gens.java -> new File(protoBufferCodeGenDir), PB.gens.plugin("grpc-java") -> new File(grpcDir))
          case None          => Seq(PB.gens.java -> new File(protoBufferCodeGenDir))
        })
      )
      val allSettings = moduleBuild.settings.toSet ++ _settings
      ModuleBuild(allSettings)
    }

    def protoScalaTargetDir(codeGenDir: String, generateGrpcCode: Boolean = false): ModuleBuild = {
      val _settings: Seq[Def.Setting[_]] = Seq(
        Compile / PB.targets := Seq(
          scalapb.gen(grpc = generateGrpcCode) -> new File(codeGenDir)
        )
      )
      val allSettings = moduleBuild.settings.toSet ++ _settings
      ModuleBuild(allSettings)
    }
  }

}
