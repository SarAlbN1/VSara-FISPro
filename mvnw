#!/bin/sh
# ----------------------------------------------------------------------------
# Apache Maven Wrapper startup script for TEAM CONNECT project
# ----------------------------------------------------------------------------

MAVEN_VERSION="3.8.5"
MVNW_VERBOSE_FLAG=""

# Check for verbosity setting
if [ "$MVNW_VERBOSE" = "true" ]; then
  MVNW_VERBOSE_FLAG="--debug"
fi

# Verify the presence of the Maven wrapper properties file
if [ ! -f ".mvn/wrapper/maven-wrapper.properties" ]; then
  echo "Error: Maven wrapper properties file not found. Please check your .mvn/wrapper directory."
  exit 1
fi

# Define the Maven home directory based on the specified version
MAVEN_HOME="$HOME/.m2/wrapper/dists/apache-maven-$MAVEN_VERSION"

# Function to download Maven if not present
download_maven() {
  echo "Maven not found in $MAVEN_HOME. Downloading Maven $MAVEN_VERSION for TEAM CONNECT project."
  DOWNLOAD_URL="https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/$MAVEN_VERSION/apache-maven-$MAVEN_VERSION-bin.zip"
  
  # Use curl to download Maven with error handling
  if command -v curl >/dev/null 2>&1; then
    echo "Downloading Maven from: $DOWNLOAD_URL"
    curl -L -o maven.zip "$DOWNLOAD_URL" || { echo "Error: Failed to download Maven with curl."; exit 1; }
  elif command -v wget >/dev/null 2>&1; then
    echo "Downloading Maven using wget from: $DOWNLOAD_URL"
    wget -O maven.zip "$DOWNLOAD_URL" || { echo "Error: Failed to download Maven with wget."; exit 1; }
  else
    echo "Error: Neither curl nor wget is available for downloading Maven."
    exit 1
  fi

  # Unzip the downloaded file and move it to Maven home
  echo "Extracting Maven..."
  unzip -q maven.zip -d "$MAVEN_HOME" || { echo "Error: Failed to unzip Maven."; rm -f maven.zip; exit 1; }
  rm -f maven.zip
  echo "Maven installed successfully at $MAVEN_HOME."
}

# Check if Maven is already installed
if [ -x "$MAVEN_HOME/bin/mvn" ]; then
  echo "Using existing Maven installation at $MAVEN_HOME"
else
  # Download Maven if not installed
  download_maven
fi

# Run Maven with any additional arguments passed to the script
exec "$MAVEN_HOME/bin/mvn" "$@" $MVNW_VERBOSE_FLAG
