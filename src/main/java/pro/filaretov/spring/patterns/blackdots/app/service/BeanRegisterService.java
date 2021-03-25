package pro.filaretov.spring.patterns.blackdots.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Service;
import pro.filaretov.spring.patterns.blackdots.app.util.CustomClassLoader;

/**
 * Service to register new beans at runtime, without server restart
 */
@Service
@RequiredArgsConstructor
public class BeanRegisterService {

    private final CustomClassLoader classLoader;
    private final GenericApplicationContext context;

    public void register(String beanName, String className) {
        Class<?> beanClass = classLoader.findClass(className);

        BeanDefinitionRegistry beanFactory = (BeanDefinitionRegistry) context.getBeanFactory();

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(beanClass);
        beanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);
        beanFactory.registerBeanDefinition(beanName, beanDefinition);

        // now, bean definition is registered, and we need to call getBean()
        // so that the bean is created from the bean definition
        context.getBean(beanName);
    }
}
