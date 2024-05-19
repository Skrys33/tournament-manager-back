# Tournament Manager Backend - Kotlin Ktor Koin MongoDB

This repository contains a Kotlin Ktor application, along with a Docker Compose configuration for setting up the mongo database. Below, you'll find instructions on how to install and deploy the application.

## Improvement ideas
- Secure API (e.g. Bearer token)
- Document the API (e.g. swagger)
- Tests
- Modify architecture to suit project scale (e.g. Hexagonal Architecture)
- Optimize ranking calculation based on the scale of data to handle
- ...


## Prerequisites

Before you proceed, ensure you have the following software installed on your system:

- Java 11
- Docker
- Docker Compose
- Git

## Installation

Follow these steps to set up and run the application:

1. Clone this repository to your local machine:

   ```shell
   git clone https://github.com/Skrys33/tournament-manager-back.git
   cd tournament-manager-back
   ```

2. Execute stating application file:

   ```shell
   ./start-tournament-back.sh
   ```