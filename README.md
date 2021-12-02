# Cloud Runtimes JVM

Cloud Runtimes Specification for the JVM.

## Introduction

The Multi-Runtime Standard API for Mecha architecture Projects:

+ [capa](https://github.com/reactivegroup/capa) (used)
+ [dapr](https://docs.dapr.io/concepts/building-blocks-concept/) (follow)
+ [layotto](https://github.com/mosn/layotto) (follow)
+ ....

## Motivation

[[Discussion] Future plans for dapr api](https://github.com/dapr/dapr/issues/2817)

[Make java-sdk as a independent project](https://github.com/mosn/layotto/issues/188)

[Decompose core-API and enhanced-API.](https://github.com/dapr/dapr/issues/3600)

[Java sdk design](https://github.com/mosn/layotto/issues/206)

## Features

+ Service Invocation (RPC)
+ Configuration Centor (Configuration)
+ Publish/Subscribe (Pub/Sub)
+ State Management (State)
+ Secret Management (Secret)
+ Application Log/Metrics/Traces (Telemetry)
+ Database (SQL) -alpha
+ Schedule (Schedule) -alpha
+ ...

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
            <version>1.1.0-alpha-1</version>
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
   implementation group: 'group.rxcloud', name: 'cloud-runtimes-api', version: '1.1.0-alpha-1'
}
```
