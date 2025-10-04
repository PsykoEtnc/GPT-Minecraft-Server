#!/usr/bin/env bash
set -euo pipefail
mkdir -p server/data/plugins
while IFS= read -r url; do
  if [ -z "$url" ]; then continue; fi
  fname=$(basename "${url%%\?*}")
  curl -L "$url" -o "server/data/plugins/$fname"
done < plugins.txt
