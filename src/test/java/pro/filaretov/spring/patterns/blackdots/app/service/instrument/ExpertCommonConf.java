package pro.filaretov.spring.patterns.blackdots.app.service.instrument;

import javax.annotation.PostConstruct;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.filaretov.spring.patterns.blackdots.app.service.InstrumentsService;
import pro.filaretov.spring.patterns.blackdots.app.service.instrument.parts.WoodExpert;

/**
 * Common configuration for several expert tests, e.g. {@link PianoExpert}, {@link ViolinExpert}
 */
@Configuration
public class ExpertCommonConf {

    @MockBean
    InstrumentsService instrumentsService;

    @PostConstruct
    public void init() {
        System.out.println("ExpertCommonConf INIT");
    }

    @Bean
    public WoodExpert woodExpert() {
        return new WoodExpert();
    }
}
