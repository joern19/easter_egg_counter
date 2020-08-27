# Easter Egg Counter
This is a very small rest API for a counter on my Website.

----------
\
&nbsp;

# Installation

[Pull from Dockerhub](Pull-from-Dockerhub-:arrow_down:) or [Build from sources](Build-from-sources-:hammer:)

[Run the container](Run-the-container-:whale:)

----------

## Pull from Dockerhub :arrow_down:

```bash
docker pull joern19/quarkus-counter:latest
```

### Build from sources :hammer:

Building the native Executable Binary
```bash
mvn package -Pnative -Dquarkus.native.container-build=true
```

Containerize it
```bash
docker build -f src/main/docker/Dockerfile.native -t joern19/quarkus-counter:custom .
```

### Run the container :whale:

```bash
docker run -p8080:8080 joern19/quarkus-counter -e MONGODB_CONNECTION_STRING=<your connection string> -e DATABASE_NAME=<your database Name>
```

----------
\
\
\
\
&nbsp;

# Endpoints
name | method | endpoint | returns | description
--- | --- | --- | --- |--- 
redirect | GET | / | 301 | redirect to my Website
getValue | GET | /counter/value | 204 | get the value of the counter
addOne | POST | /counter/addOne | 200 | add one to the counter