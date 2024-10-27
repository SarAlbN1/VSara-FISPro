#!/bin/sh
# ----------------------------------------------------------------------------
# Apache Maven Wrapper startup script for TEAM CONNECT project
# ----------------------------------------------------------------------------

MAVEN_VERSION="3.8.5"
MVNW_VERBOSE_FLAG=""

if [ "$MVNW_VERBOSE" = "true" ]; then
  MVNW_VERBOSE_FLAG="--debug"
fi

if [ ! -f ".mvn/wrapper/maven-wrapper.properties" ]; then
  echo "Maven wrapper properties file not found. Please check your .mvn/wrapper directory."
  exit 1
fi

MAVEN_HOME="$HOME/.m2/wrapper/dists/apache-maven-$MAVEN_VERSION"

if [ -x "$MAVEN_HOME/bin/mvn" ]; then
  exec "$MAVEN_HOME/bin/mvn" "$@"
else
  echo "Maven not found, downloading..."
  echo "Downloading Maven $MAVEN_VERSION for TEAM CONNECT project"
  DOWNLOAD_URL="https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/$MAVEN_VERSION/apache-maven-$MAVEN_VERSION-bin.zip"
  curl -o maven.zip $DOWNLOAD_URL
  unzip maven.zip -d "$MAVEN_HOME"
  exec "$MAVEN_HOME/bin/mvn" "$@"
fi
