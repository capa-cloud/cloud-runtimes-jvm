# cloud-runtimes-jvm

Cloud Runtimes Specification for the JVM.

## Introduction

Standard API for [dapr](https://docs.dapr.io/concepts/building-blocks-concept/)
/ [layotto](https://github.com/mosn/layotto) / [capa](https://github.com/reactivegroup/capa) / ....

## Motivation

[[Discussion] Future plans for dapr api](https://github.com/dapr/dapr/issues/2817)

[Make java-sdk as a independent project](https://github.com/mosn/layotto/issues/188)

[Decompose core-API and enhanced-API.](https://github.com/dapr/dapr/issues/3600)

[Java sdk design](https://github.com/mosn/layotto/issues/206)

## Getting Started

#### Importing CloudRuntimes's Java SDK

For a Maven project, add the following to your `pom.xml` file:

```xml
<project>
    ...
    <dependencies>
        ...
        <!-- https://mvnrepository.com/artifact/group.rxcloud/cloud-runtimes-api -->
        <dependency>
            <groupId>group.rxcloud</groupId>
            <artifactId>cloud-runtimes-api</artifactId>
            <version>1.0.2.RELEASE</version>
        </dependency>
        ...
    </dependencies>
    ...
</project>
```

For a Gradle project, add the following to your `build.gradle` file:

```groovy
dependencies {
...
   // https://mvnrepository.com/artifact/group.rxcloud/cloud-runtimes-api
   implementation group: 'group.rxcloud', name: 'cloud-runtimes-api', version: '1.0.2.RELEASE'
}
```
