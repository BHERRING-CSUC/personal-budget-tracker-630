#!/bin/sh
set -euo pipefail

# Always run from the repo root
cd "$(dirname "$0")/budgettracker"

./mvnw test
