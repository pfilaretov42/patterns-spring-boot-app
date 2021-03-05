package pro.filaretov.spring.patterns.blackdots.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.filaretov.spring.patterns.blackdots.app.dto.BeanDTO;
import pro.filaretov.spring.patterns.blackdots.app.util.CustomClassLoader;

/**
 * Controller to register new beans at runtime, without server restart
 */
@RestController
@RequestMapping("/api/v1/beans")
public class BeanRegisterController {

    @Autowired
    private CustomClassLoader classLoader;

    @Autowired
    private GenericApplicationContext context;

    @PostMapping("/register")
    public String register(@RequestBody BeanDTO beanDTO) {
        String beanName = beanDTO.getBeanName();

        Class<?> beanClass = classLoader.findClass(beanDTO.getClassName());

        BeanDefinitionRegistry beanFactory = (BeanDefinitionRegistry) context.getBeanFactory();

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(beanClass);
        beanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);
        beanFactory.registerBeanDefinition(beanName, beanDefinition);

        // now, bean definition is registered, and we need to call getBean()
        // so that the bean is created from the bean definition
        context.getBean(beanName);

        return "registered";
    }
}
