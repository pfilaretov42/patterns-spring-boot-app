# patterns-spring-boot-app
Spring patterns app which uses [custom spring boot starter](https://github.com/pfilaretov/patterns-spring-boot-starter)
and integrates [legacy app](https://github.com/pfilaretov/patterns-spring-boot-legacy). 

## How to run

1) Build [legacy app](https://github.com/pfilaretov/patterns-spring-boot-legacy) using `mvn install`
1) Build [custom spring boot starter](https://github.com/pfilaretov/patterns-spring-boot-starter) using `mvn install`
1) Run spring boot app
    1) You may need to add `-Djava.awt.headless=false` JVM parameter to run the app, 
       since starter uses `JOptionPane` as a conditional check.