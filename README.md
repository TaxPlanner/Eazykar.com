# EasyKar.com

## Development

To start your application in the dev profile, simply run:

    ./mvnw 

## Building for production

To optimize the eazykar application for production, run:

    ./mvnw -Pprod clean package

To ensure everything worked, run:

    java -jar target/*.war

## Using Docker to simplify development (WIP & optional)

To run app (dev version) in docker, execute following commands in root folder of app (i.e. same location as this file)

    ./mvnw clean package jib:dockerBuild
    docker-compose -f src/main/docker/app.dev.yml up -d
    
    docker-compose -f src/main/docker/app.yml up -d

## Continuous Integration (optional)

coming soon ...

