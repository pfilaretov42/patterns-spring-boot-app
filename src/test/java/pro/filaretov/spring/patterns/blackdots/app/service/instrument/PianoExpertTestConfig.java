package pro.filaretov.spring.patterns.blackdots.app.service.instrument;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Test configuration for {@link PianoExpertTest}.
 */
@Configuration
public class PianoExpertTestConfig {

    @Bean
    public PianoExpert pianoExpert() {
        return new PianoExpert();
    }

}
