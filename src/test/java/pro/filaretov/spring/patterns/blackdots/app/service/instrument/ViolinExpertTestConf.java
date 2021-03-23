package pro.filaretov.spring.patterns.blackdots.app.service.instrument;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import pro.filaretov.spring.patterns.blackdots.app.service.instrument.parts.StringExpert;

/**
 * Test configuration for {@link ViolinExpertTest}.
 */
@TestConfiguration
public class ViolinExpertTestConf {

    @Bean
    public ViolinExpert violinExpert() {
        return new ViolinExpert();
    }

    @Bean
    public StringExpert stringExpert() {
        return new StringExpert();
    }
}
