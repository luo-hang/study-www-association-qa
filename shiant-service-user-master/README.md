Shiant Question Service
====

Develop Steps
----
1. Run Server.
    * Dev
    ```
    run StartServer.java
    ```
     * Prod
    ```
    nohup java -jar shiant-service-user-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod > log.out &
    ```
    nohup java -Xdebug -Xrunjdwp:transport=dt_socket,address=41000,server=y,suspend=n -jar shiant-service-user-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod > log.out &
    ```

