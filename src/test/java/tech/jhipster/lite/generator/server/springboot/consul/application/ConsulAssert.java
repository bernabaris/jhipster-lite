package tech.jhipster.lite.generator.server.springboot.consul.application;

import static tech.jhipster.lite.TestUtils.assertFileContent;
import static tech.jhipster.lite.TestUtils.assertFileExist;
import static tech.jhipster.lite.common.domain.FileUtils.getPath;
import static tech.jhipster.lite.generator.project.domain.Constants.MAIN_RESOURCES;
import static tech.jhipster.lite.generator.project.domain.Constants.TEST_RESOURCES;

import java.util.List;
import tech.jhipster.lite.generator.project.domain.Project;

public class ConsulAssert {

  public static void assertDependencies(Project project) {
    // TODO test dependency management for spring-cloud

    assertFileContent(
      project,
      "pom.xml",
      List.of(
        "<dependency>",
        "<groupId>org.springframework.cloud</groupId>",
        "<artifactId>spring-cloud-starter-bootstrap</artifactId>",
        "</dependency>"
      )
    );
    assertFileContent(
      project,
      "pom.xml",
      List.of(
        "<dependency>",
        "<groupId>org.springframework.cloud</groupId>",
        "<artifactId>spring-cloud-starter-consul-discovery</artifactId>",
        "</dependency>"
      )
    );
    assertFileContent(
      project,
      "pom.xml",
      List.of(
        "<dependency>",
        "<groupId>org.springframework.cloud</groupId>",
        "<artifactId>spring-cloud-starter-consul-config</artifactId>",
        "</dependency>"
      )
    );
  }

  public static void assertProperties(Project project) {
    assertFileExist(project, MAIN_RESOURCES, "config/bootstrap.properties");
    assertFileExist(project, MAIN_RESOURCES, "config/bootstrap-fast.properties");
    assertFileExist(project, TEST_RESOURCES, "config/bootstrap.properties");

    assertFileContent(
      project,
      getPath(MAIN_RESOURCES, "config/bootstrap.properties"),
      List.of(
        "spring.cloud.consul.config.enabled=true",
        "spring.cloud.consul.host=localhost",
        "spring.cloud.consul.port=8500"
        // TODO other properties
      )
    );

    assertFileContent(
      project,
      getPath(MAIN_RESOURCES, "config/bootstrap-fast.properties"),
      List.of(
        "spring.cloud.consul.config.enabled=false",
        "spring.cloud.consul.discovery.enabled=false",
        "spring.cloud.consul.enabled=false"
      )
    );

    assertFileContent(
      project,
      getPath(TEST_RESOURCES, "config/bootstrap.properties"),
      List.of(
        "spring.cloud.consul.config.enabled=false",
        "spring.cloud.consul.discovery.enabled=false",
        "spring.cloud.consul.enabled=false"
      )
    );
  }
}
