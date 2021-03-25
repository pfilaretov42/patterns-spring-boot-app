package pro.filaretov.spring.patterns.blackdots.app.controller;

import javax.annotation.PostConstruct;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import pro.filaretov.spring.patterns.blackdots.app.service.BeanRegisterService;
import pro.filaretov.spring.patterns.blackdots.app.service.InstrumentsService;
import pro.filaretov.spring.patterns.blackdots.app.service.LegacyInstrumentsService;

/**
 *
 */
@TestConfiguration
@MockBean(BeanRegisterService.class)
@MockBean(InstrumentsService.class)
@MockBean(LegacyInstrumentsService.class)
public class ControllerTestConfig {

    @PostConstruct
    public void init() {
        System.out.println("ControllerTestConfig INIT");
    }

}
