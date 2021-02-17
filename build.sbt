import org.apache.ivy.core.module.descriptor.License
import org.logicovercode.bsbt.core.model.ModuleBuild

sbtPlugin := true

val license = new License("MIT", "https://opensource.org/licenses/MIT")

/*this will automatically fetch dependency-tree for sbt projects that depends on LogicAndCode*/
addDependencyTreePlugin

val cto = Developer(
  "cto",
  "cto",
  "oss@logicovercode.com",
  url("https://github.com/logicovercode")
)
val githubRepo = GithubRepo("logicovercode", "LogicOverCodePlugin")

val moduleBuild = ModuleBuild("org.logicovercode", "fluent-style-sbt", "0.0.3")
  .sourceDirectories(
    "dependencies/model",
    "dependencies/spark",
    "dependencies/springboot",
    "dependencies/scala",
    "licenses",
    "resolvers",
    "plugin",
    "dockerContainers",
    "flywayExt"
  )
  //TODO : make this dependency conditional, depending on jdk version
  .dependencies("javax.activation" % "activation" % "1.1.1")
  .sbtPlugins(
    "org.logicovercode" % "fluent-style-sbt-core" % "0.0.2",
    /*this will automatically fetch flyway-sbt, sbt-pack, scalafmt for sbt projects that depends on LogicAndCode*/
    "io.github.davidmweber" % "flyway-sbt" % "6.5.0",
    "org.xerial.sbt" % "sbt-pack" % "0.13",
    "org.scalameta" % "sbt-scalafmt" % "2.4.0"
  )
  .argsRequiredForPublishing(
    List(cto),
    license,
    githubRepo.homePageUrl,
    githubRepo.scmInfo(),
    Opts.resolver.sonatypeStaging
  )

lazy val basePluginProject =
  (project in file(".")).settings(moduleBuild.settings)
