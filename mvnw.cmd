@REM ----------------------------------------------------------------------------
@REM Apache Maven Wrapper startup script for TEAM CONNECT project
@REM Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements.
@REM ----------------------------------------------------------------------------

@IF "%MVNW_VERBOSE%"=="true" (SET "MVNW_VERBOSE_FLAG=--debug") ELSE (SET "MVNW_VERBOSE_FLAG=")

@REM Set the required Maven version for TEAM CONNECT
SET "MAVEN_VERSION=3.8.5"

@REM Verify if Maven is already installed or download it
IF NOT EXIST ".mvn/wrapper/maven-wrapper.properties" (
    ECHO "Maven wrapper properties file not found. Please check your .mvn/wrapper directory."
    EXIT /B 1
)

@SET "__MVNW_ERROR__="
@SET "__MVNW_CMD__="

@FOR /F "tokens=1* delims==" %%A IN ('powershell -NoProfile -Command "(Get-Content -Raw '.mvn/wrapper/maven-wrapper.properties').replace('distributionUrl=', '').replace(' ','')"') DO (
    SET "__MVNW_CMD__=%%B"
)

IF NOT "%__MVNW_CMD__%"=="" (
    SET MAVEN_HOME=%USERPROFILE%\.m2\wrapper\dists\%MAVEN_VERSION%
    IF EXIST "%MAVEN_HOME%\bin\mvn.cmd" (
        CALL "%MAVEN_HOME%\bin\mvn.cmd" %*
    ) ELSE (
        ECHO "Maven not found, downloading..."
        ECHO "Downloading Maven %MAVEN_VERSION% for TEAM CONNECT project"
        SET DOWNLOAD_URL=https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/%MAVEN_VERSION%/apache-maven-%MAVEN_VERSION%-bin.zip
        powershell -Command "Invoke-WebRequest -Uri %DOWNLOAD_URL% -OutFile maven.zip"
        powershell -Command "Expand-Archive -Path maven.zip -DestinationPath %MAVEN_HOME%"
        CALL "%MAVEN_HOME%\bin\mvn.cmd" %*
    )
) ELSE (
    ECHO "Unable to determine Maven distribution URL."
    EXIT /B 1
)
