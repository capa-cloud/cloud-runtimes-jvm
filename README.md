<p align="center">
  <img src="./docs/banner.png" alt="Cloud Runtimes JVM" width="600">
</p>

# Cloud Runtimes JVM

Vendor-neutral Java API contracts for multi-runtime application capabilities, plus partial client adapter modules for Capa, Dapr, and Layotto.

[Capa Cloud](https://github.com/capa-cloud) · [Documentation](https://capa.rxcloud.group/) · [Issues](https://github.com/capa-cloud/cloud-runtimes-jvm/issues)

## Requirements

- Java 8 or 11
- Maven 3.8.1 or later

Current repository and Maven artifact version: `1.19.RELEASE`.

## Add the API

Maven:

```xml
<dependency>
    <groupId>group.rxcloud</groupId>
    <artifactId>cloud-runtimes-api</artifactId>
    <version>1.19.RELEASE</version>
</dependency>
```

Gradle:

```groovy
implementation 'group.rxcloud:cloud-runtimes-api:1.19.RELEASE'
```

`cloud-runtimes-api` defines contracts and shared types. It does not connect to a runtime by itself.

## Modules and maturity

| Module | Purpose | Current boundary |
| --- | --- | --- |
| `cloud-runtimes-api` | Core, enhanced, native-protocol, SaaS, client, and shared domain APIs | Compatibility-sensitive API definitions |
| `cloud-runtimes-capa` | Capa client/provider scaffold | Partial implementation; many methods inherit unsupported defaults |
| `cloud-runtimes-dapr` | Dapr client/provider scaffold | Partial implementation; verify every operation used by the application |
| `cloud-runtimes-layotto` | Layotto client/provider scaffold | Partial implementation; verify every operation used by the application |

The API module intentionally provides default methods that throw `UnsupportedOperationException`. An adapter artifact being present therefore does not guarantee full support for service invocation, configuration, pub/sub, state, bindings, files, locks, telemetry, or native APIs.

Before selecting an adapter:

1. Inspect its client implementation for the operations your application calls.
2. Test those operations against the target runtime version.
3. Handle unsupported operations explicitly.

## API groups

```text
cloud-runtimes-api/src/main/java/group/rxcloud/cloudruntimes/
├── client/                 # Client and provider contracts
├── domain/core/            # Invocation, configuration, pub/sub, state, secrets, bindings
├── domain/enhanced/        # Database, files, locks, telemetry and related APIs
├── domain/nativeproto/     # Provider-shaped native protocols such as Redis, SQL and S3
├── domain/saas/            # SaaS-shaped APIs
└── utils/                  # Shared helpers such as TypeRef
```

## Build and verify

```bash
git clone https://github.com/capa-cloud/cloud-runtimes-jvm.git
cd cloud-runtimes-jvm
mvn --batch-mode --no-transfer-progress --fail-fast clean verify \
  -Pjacoco,rat,checkstyle \
  -DskipTests=false \
  -Dcheckstyle.skip=false \
  -Drat.skip=false \
  -Dmaven.javadoc.skip=true \
  -Dgpg.skip=true
```

CI runs this command on Java 8 and Java 11.

When changing an API:

1. Keep public signatures compatible or clearly document the breaking change.
2. Update request/response types and adapter modules together where required.
3. Add tests for implemented behavior and unsupported fallbacks.
4. Do not place credentials, private endpoints, or customer data in examples or fixtures.

## Design background

- [Dapr API future plans](https://github.com/dapr/dapr/issues/2817)
- [Layotto Java SDK design discussion](https://github.com/mosn/layotto/issues/188)
- [Dapr API layering discussion](https://github.com/dapr/dapr/issues/3600)

## Related projects

- [capa-java](https://github.com/capa-cloud/capa-java)
- [cloud-runtimes-python](https://github.com/capa-cloud/cloud-runtimes-python)
- [cloud-runtimes-golang](https://github.com/capa-cloud/cloud-runtimes-golang)

## License

Apache License 2.0. See [LICENSE](LICENSE).
