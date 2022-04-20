# My Quarkus Application

## Prerequisite

### Quarkus CLI (for development)

```
# On Mac
brew install quarkusio/tap/quarkus
```

[Reference](https://quarkus.io/guides/cli-tooling)

### graylog

```
cd <graylog_stack_folder>
docker-compose up -d
```

### jaeger

```
cd <opentelemetry_stack_folder>
docker-compose up -d
```

### Prometheus

Install locally and run prometheus.

```
# On Mac
brew install prometheus

cd <prometheus_stack_folder>
prometheus
```

---

## Running the applications

### API Service 0

```
cd quarkus-rest-service-0
quarkus dev -Ddebog=5005
```

### API Service 1

```
cd quarkus-rest-service-1
quarkus dev -Ddebog=5006
```

### API Service 0

```
cd quarkus-rest-service-2
quarkus dev -Ddebog=5007
```

---

## Bootstrap the applications from scratch

Bootstrap quarkus-rest-service-0

```
quarkus create app org.acme:quarkus-rest-service-0 \
--extension=resteasy-jackson,\
smallrye-metrics,\
logging-gelf,\
opentelemetry-exporter-otlp,\
elytron-security-properties-file,\
rest-client,\
rest-client-jackson
```

Run

```
quarkus dev -Ddebog=5005
```

---

Bootstrap quarkus-rest-service-1

```
quarkus create app org.acme:quarkus-rest-service-1 \
--extension=resteasy-jackson,\
smallrye-metrics,\
logging-gelf,\
opentelemetry-exporter-otlp,\
```

Run

```
quarkus dev -Ddebog=5006
```

---

Bootstrap quarkus-rest-service-2

```
quarkus create app org.acme:quarkus-rest-service-2 \
--extension=resteasy-jackson,\
smallrye-metrics,\
logging-gelf,\
opentelemetry-exporter-otlp,\
smallrye-fault-tolerance

```

Run

```
quarkus dev -Ddebog=5007
```

---
