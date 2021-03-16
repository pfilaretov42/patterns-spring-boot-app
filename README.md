# patterns-spring-boot-app
Spring patterns app which uses [custom spring boot starter](https://github.com/pfilaretov/patterns-spring-boot-starter)
and integrates [legacy app](https://github.com/pfilaretov/patterns-spring-boot-legacy). 

## How to run

1) Build [legacy app](https://github.com/pfilaretov/patterns-spring-boot-legacy) using `mvn install`
1) Build [custom spring boot starter](https://github.com/pfilaretov/patterns-spring-boot-starter) using `mvn install`
1) Run spring boot app
    1) You may need to add `-Djava.awt.headless=false` JVM parameter to run the app, 
       since starter uses `JOptionPane` as a conditional check.
       

## How does it all work?

1. `SpringApplication` builds environment and passes it to `EnvironmentPostProcessor`s
1. `EnvironmentPostProcessor`s setup environment, e.g. `ProfileResolverEPP`
1. `SpringApplication` creates context and passes to `ApplicationContextInitialiser`s
1. `ApplicationContextInitialiser`s do whatever they want, taking into account that environment is ready
   but context is almost empty, i.e. no beans, `BeanPostProcessor`s or `BeanFactoryPostProcessor`s. 
   Example: `ProfileApplicationContextInitialiser`.
1. `BeanFactoryPostProcessor`s do whatever they want
1. `BeanPostProcessor`s do whatever they want, e.g. `InjectListBeanPostProcessor`