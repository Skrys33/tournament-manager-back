#!/bin/bash

echo "Cleaning and building the project with Gradle..."
./gradlew clean build

echo "Starting the services with Docker Compose."
docker-compose up -d