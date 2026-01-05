#!/bin/sh
set -euo pipefail

# Always run from the repo root
cd "$(dirname "$0")/budgettracker"

find_jdk() {
  if [ -d /usr/lib/jvm/java-17-openjdk ]; then
    echo /usr/lib/jvm/java-17-openjdk
    return 0
  fi

  if [ -d /usr/lib/jvm/default-jvm ]; then
    echo /usr/lib/jvm/default-jvm
    return 0
  fi

  if command -v java >/dev/null 2>&1; then
    local java_path resolved_home
    java_path="$(command -v java)"
    resolved_home="$(readlink -f "$java_path" 2>/dev/null || echo "$java_path")"
    resolved_home="${resolved_home%/bin/java}"
    if [ -d "$resolved_home" ]; then
      echo "$resolved_home"
      return 0
    fi
  fi

  return 1
}

if [ -z "${JAVA_HOME:-}" ]; then
  if ! JAVA_HOME="$(find_jdk)"; then
    echo "ERROR: Java 17 not found. Install JDK 17 or set JAVA_HOME." >&2
    exit 1
  fi
fi

export JAVA_HOME
export PATH="$JAVA_HOME/bin:$PATH"

# Ensure wrapper is executable
if [ ! -x ./mvnw ]; then
  chmod +x ./mvnw
fi

# Start the Spring Boot app (uses in-memory H2 by default)
./mvnw spring-boot:run
