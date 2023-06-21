#!/bin/bash
# Mettre à jour le code source
git pull
# Construire le projet avec Maven
bash mvnw package -P prod -e
# Construire l'image Docker
docker build --no-cache -t image-spring-locmns .
# Arreter le conteneur existant
docker stop conteneur-spring-locmns
# Supprimer le conteneur existant
docker rm -f conteneur-spring-locmns
# Lancer un nouveau conteneur
docker run -d --net backend --ip 172.18.0.14 --name=conteneur-spring-locmns -p 8282:8282 -v uploaded_files:/uploads image-spring-locmns
