<img src="https://img.shields.io/badge/java-%23ED8B00.svg?&style=for-the-badge&logo=java&logoColor=white"/> * * *  <img src="https://img.shields.io/badge/spring%20-%236DB33F.svg?&style=for-the-badge&logo=spring&logoColor=white"/>  * * *  <img src="https://img.shields.io/badge/docker%20-%230db7ed.svg?&style=for-the-badge&logo=docker&logoColor=white"/> * * * [![made-with-sphinx-doc](https://img.shields.io/badge/Made%20with-Gradle-1f425f.svg)](https://www.sphinx-doc.org/)

# TourGuide - Api Gateway

OpenClassrooms - Project 8 / TourGuide App - Api Gateway

---

For deploiement, please refer to users microservice readme: https://github.com/ludovictuccio/TourGuide-Users

---

## To run microservice:

- **With your IDE**: refer to **application.properties** to set valid proxies url

- **With Docker**: the jar hosted on GitHub is for a Docker deployment ("localhost" changed with the image Docker)

## For Docker deploiement:

1. Install Docker Desktop: <br/>
https://docs.docker.com/docker-for-windows/ or https://docs.docker.com/docker-for-mac/

2. To use the **Dockerfile**, you must run on the package root: 
- `docker build -t tourguide-api-gateway .`
- `docker run -d -p 8080:8080 tourguide-api-gateway`

3. To run all microservices on the same network, with a Docker-Compose deploiement: <br/>
If you want to deploy all TourGuide microservices, use the **docker-compose.yml** on the package root, after each Dockerfile deployment for the 4 microservices, running:
- `docker network create tourguide-net`
- `docker-compose up -d`
