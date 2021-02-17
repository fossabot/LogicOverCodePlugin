package org.logicovercode.base_plugin.docker_containers

import com.whisk.docker.{DockerContainer, DockerReadyChecker}
import org.logicovercode.base_plugin.flyway.IFlyway
import org.logicovercode.bsbt.docker.IDockerContainer
import sbt.Def

trait DbDockerContainers {

  case class SimpleMySqlContainer(
      containerName: String,
      dbUser: String,
      dbPassword: String,
      hostPort: Int,
      schema: String,
      initDir: String,
      host: String = "localhost"
  ) extends IDockerContainer {

    val dbContainerPort = 3306

    override def instance(): DockerContainer = {
      val imageName: String = "mogli/smysql"

      val dbContainer = DockerContainer(imageName, Option(containerName))
        .withEnv(s"MYSQL_ROOT_PASSWORD=$dbPassword")
        .withCommand(dbUser, dbPassword, dbContainerPort + "", schema)
        .withPorts(dbContainerPort -> Some(hostPort))
        .withReadyChecker(
          DockerReadyChecker.LogLineContains(
            s"[healthCheck] : container ready for use"
          )
        )

      dbContainer
    }

    override def settings(): Set[Def.Setting[_]] = {
      val url = s"jdbc:mysql://${host}:$hostPort/$schema"

      println(s"flyway url is >$url<")

      //one way is to extends FlywayAdaptorSettings
      //to hide flyWayCoreSettings in consumer project sbts
      val settings: Set[Def.Setting[_]] = new IFlyway {}.flyWaySettings(
        url,
        dbUser,
        dbPassword,
        Seq(s"filesystem:$initDir")
      )
      settings
    }
  }

  case class SimplePostgresContainer(
      containerName: String,
      dbUser: String,
      dbPassword: String,
      hostPort: Int,
      schema: String,
      initDir: String,
      host: String = "localhost"
  ) extends IDockerContainer {

    val dbContainerPort = 5432

    override def instance(): DockerContainer = {
      val imageName: String = "mogli/spostgres"
      val dbContainer = DockerContainer(imageName, Option(containerName))
        .withEnv(s"POSTGRES_PASSWORD=$dbPassword")
        .withCommand(dbUser, dbPassword, dbContainerPort + "", schema)
        .withPorts(dbContainerPort -> Some(hostPort))
        .withReadyChecker(
          DockerReadyChecker.LogLineContains(
            s"[healthCheck] : container ready for use"
          )
        )

      dbContainer
    }

    override def settings(): Set[Def.Setting[_]] = {
      val url = s"jdbc:postgresql://${host}:$hostPort/$schema"

      println(s"flyway url is >$url<")

      //one way is to extends FlywayAdaptorSettings
      //to hide flyWayCoreSettings in consumer project sbts
      val settings: Set[Def.Setting[_]] = new IFlyway {}.flyWaySettings(
        url,
        dbUser,
        dbPassword,
        Seq(s"filesystem:$initDir")
      )
      settings
    }
  }

}
