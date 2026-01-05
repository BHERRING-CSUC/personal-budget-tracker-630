FROM mcr.microsoft.com/devcontainers/base:alpine-3.22

# Install Java 17 and Maven
RUN apk add --no-cache \
    openjdk17 \
    openjdk17-jdk \
    maven \
    git \
    curl \
    wget

# Set JAVA_HOME
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk
ENV PATH="${JAVA_HOME}/bin:${PATH}"

# Switch to vscode user
USER vscode

WORKDIR /workspaces
