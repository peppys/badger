# badger

Heavily inspired by https://github.com/HandOfGod94/jacoco-cov-badge-maven-plugin

Dynamically build badges based on specified properties

# [library](./library)
### [package](https://github.com/peppys/badger/packages/343219)

#### Maven installation

1. Add the following to your global `~/.m2/settings.xml`:
```xml
<profiles>
  <profile>
    <id>github</id>
      <repositories>
        <repository>
          <id>github</id>
          <name>peppys badger github repo</name>
          <url>https://maven.pkg.github.com/peppys/badger</url>
        </repository>
      </repositories>
  </profile>
</profiles>

<servers>
  <server>
    <id>github</id>
    <username>{GITHUB_USER}</username>
    <password>{GITHUB_TOKEN}</password>
  </server>
</servers>
```
2. Add the following depency to your `pom.xml`
```xml
<dependency>
  <groupId>io.github.peppys</groupId>
  <artifactId>badger</artifactId>
  <version>0.0.5</version>
</dependency>
```
2. Run via command line
```sh
$ mvn install
```

#### Usage
```java
import io.github.peppys.badger.Badge;

Badge badge = Badge.builder()
        .setLabelText("build")
        .setLabelColor("black")
        .setMessageText("passing")
        .setMessageColor("green")
        .build();

String svg = badge.render()
```

# [service](./service)

#### Local setup

1. Run API
```sh
$ docker-compose up api
```

2. Render via endpoint
```sh
$ curl -X GET "http://localhost:8080/badge.svg?label_text=build&label_color=black&message_text=passing&message_color=green"
```

# Demo

Host: https://badger-oxm27jqbha-uc.a.run.app

Example query string: `?label_text=build&label_color=black&message_text=passing&message_color=green`

Badge: <img src="https://badger-oxm27jqbha-uc.a.run.app/badge.svg?label_text=build&label_color=black&message_text=passing&message_color=green" />
