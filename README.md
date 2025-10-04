# GPT-Minecraft-Server

1. Ajoute tes URLs de plugins dans `plugins.txt`.
2. `scripts/sync_plugins.sh` télécharge ces plugins dans `server/data/plugins`.
3. Le workflow GitHub Actions build le plugin Lobby et publie un artefact `server-bundle.zip`.
4. Pour lancer en local ou sur un serveur: `docker compose -f server/docker-compose.yml up -d`.
