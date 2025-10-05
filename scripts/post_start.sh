#!/usr/bin/env bash
set -euo pipefail
export COMPOSE_FILE=server/docker-compose.yml
docker compose exec mc rcon-cli --password "$RCON_PASSWORD" gamerule keepInventory false
docker compose exec mc rcon-cli --password "$RCON_PASSWORD" gamerule doMobSpawning true
docker compose exec mc rcon-cli --password "$RCON_PASSWORD" gamerule doMobLoot true
docker compose exec mc rcon-cli --password "$RCON_PASSWORD" gamerule spawnRadius 3
docker compose exec mc rcon-cli --password "$RCON_PASSWORD" difficulty normal
docker compose exec mc rcon-cli --password "$RCON_PASSWORD" chunky world world
docker compose exec mc rcon-cli --password "$RCON_PASSWORD" chunky radius 1000
docker compose exec mc rcon-cli --password "$RCON_PASSWORD" chunky start
