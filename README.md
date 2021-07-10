[![Java version](https://img.shields.io/badge/Java-11-blue)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)

This project `jackson-builder` defines a `BuilderModule` to add builder support for deserialization.

The objectMapper will use automatically builder methods during object deserialization, instead of use explicitly `JsonPOJOBuilder`.

## Add dependency

Add dependency in your `pom.xml`
```xml
<dependency>
    <groupId>com.ggl</groupId>
    <artifactId>jackson-builder</artifactId>
    <version>1.0.0</version>
</dependency>
```

Add repository
```xml
<repository>
  <id>github</id>
  <url>https://maven.pkg.github.com/galeries-lafayette/jackson-builder/</url>
</repository>
```

In your `settings.xml` add github server (a personal access token can be added [here](https://github.com/settings/tokens/new), it needs at minimal `read:packages` rights)
```xml
<server>
  <id>github</id>
  <username>USER</username>
  <password>USER_ACCESS_TOKEN</password>
</server>
```
## Usage

```java
new ObjectMapper().registerModule(new BuilderModule());
```

You can provide custom build and builder methods names
```java
new ObjectMapper().registerModule(
    new BuilderModule()
        .builderMethodName("builder")
        .buildMethodName("build")
        .withPrefix("")
);
```
## License

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
