import org.apache.ivy.core.module.descriptor.License
import org.logicovercode.bsbt.core.model.ModuleBuild

sbtPlugin := true

val license = new License("MIT", "https://opensource.org/licenses/MIT")

/*this will automatically fetch dependency-tree for sbt projects that depends on LogicAndCode*/
addDependencyTreePlugin

val cto = Developer("cto", "cto", "cto@logicovercode.org", url("https://github.com/logicovercode"))
val githubRepo = GithubRepo("logicovercode", "LogicAndCodePlugin")

val moduleBuild = ModuleBuild("org.logicovercode", "fluent-style-sbt", "0.0.1")
  .sourceDirectories("spark", "springboot", "scalaDeps",
    "licenses", "resolvers", "plugin", "dockerContainers", "flywayExt")
  .sbtPlugins(
    "org.logicovercode" % "fluent-style-sbt-core" % "0.0.1",
    /*this will automatically fetch sbt-pack, flyway-sbt for sbt projects that depends on LogicAndCode*/
    "io.github.davidmweber" % "flyway-sbt" % "6.5.0",
    "org.xerial.sbt" % "sbt-pack" % "0.13"
  )
  .argsRequiredForPublishing(List(cto), license, githubRepo.homePageUrl, githubRepo.scmInfo(), Opts.resolver.sonatypeStaging)

lazy val basePluginProject = (project in file(".")).settings(moduleBuild.settings)
