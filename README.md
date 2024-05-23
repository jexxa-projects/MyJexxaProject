
[![Maven Test Build](https://github.com/jexxa-projects/MyJexxaProject/actions/workflows/mavenBuild.yml/badge.svg)](https://github.com/jexxa-projects/MyJexxaProject/actions/workflows/mavenBuild.yml)
[![New Release](https://github.com/jexxa-projects/MyJexxaProject/actions/workflows/newRelease.yml/badge.svg)](https://github.com/jexxa-projects/MyJexxaProject/actions/workflows/newRelease.yml)

# MyJexxaProject
This template can be used to start your own Jexxa application
 
##  Requirements

*   Java 21+ installed
*   IDE with maven support 
*   [Optional] Docker or Kubernetes if you want to run your application in a container. See [here](README-GitHub.md) for more information.   
*   [Optional] A locally running [developer stack](deploy/developerStack.yml) providing a Postgres database, ActiveMQ broker, and Swagger-UI 

## Build the Project

*   Checkout the new project in your favorite IDE

*   Without running [developer stack](deploy/developerStack.yml):
    ```shell
    mvn clean install -P '!integrationTests'

    java -jar "-Dio.jexxa.config.import=src/test/resources/jexxa-local.properties" target/myjexxaproject-jar-with-dependencies.jar
    ```

*   [Optional] **With** running [developer stack](deploy/developerStack.yml):
    ```shell
    mvn clean install
    
    java -jar "-Dio.jexxa.config.import=src/test/resources/jexxa-test.properties" target/myjexxaproject-jar-with-dependencies.jar
    ```

*   Now you can use `curl` to access your application, or open  [http://localhost:7503/BoundedContext/isRunning](http://localhost:7503/BoundedContext/isRunning) in your browser:
    ```Console
    curl -X GET  http://localhost:7503/BoundedContext/isRunning
    ```
    Response should look as follows 
    ```Console
    true
    ```
*   [Optional] See [here](https://github.com/jexxa-projects/JexxaTutorials/blob/main/BookStore/README-OPENAPI.md#explore-openapi) how to use the application with Swagger-UI

## Start Developing your Project

### Set up your project on GitHub  

To continuously build and deploy your application, we recommend using GitHub as described [here](README-GitHub.md).

### Package Structure
To organize our code we recommend the following package structure that is based on the concepts of Domain Driven Design:

``` 
(com.github.jexxaproject)
    applicationservice
    domain
    |    <use case 1>
    |    ...
    |    <use case n>    
    domainservice    
    infrastructure
    |    drivenadapter
    |    |    persistence
    |    |    messaging
    |    drivingadapter
    |    |    messaging
    MyJexxaProject.java
```

### Cleanup Readme

After successfully set up your new project, you should clean up the text of README as described [here](https://www.makeareadme.com)    
