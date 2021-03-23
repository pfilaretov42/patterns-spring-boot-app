package pro.filaretov.spring.patterns.blackdots.app.service.instrument;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Test configuration for {@link PianoExpertTest}.
 */
@TestConfiguration
public class PianoExpertTestConfig {

    @Bean
    public PianoExpert pianoExpert() {
        return new PianoExpert();
    }

}
