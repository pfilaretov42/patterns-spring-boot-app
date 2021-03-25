package pro.filaretov.spring.patterns.blackdots.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.filaretov.spring.patterns.blackdots.app.dto.BeanDTO;
import pro.filaretov.spring.patterns.blackdots.app.service.BeanRegisterService;

/**
 * Controller to register new beans at runtime, without server restart
 */
@RestController
@RequestMapping("/api/v1/beans")
@RequiredArgsConstructor
public class BeanRegisterController {

    private final BeanRegisterService registerService;

    @PostMapping("/register")
    public String register(@RequestBody BeanDTO beanDTO) {
        registerService.register(beanDTO.getBeanName(), beanDTO.getClassName());
        return "registered";
    }
}
