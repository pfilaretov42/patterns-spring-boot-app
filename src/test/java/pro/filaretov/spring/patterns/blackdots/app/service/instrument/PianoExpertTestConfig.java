package pro.filaretov.spring.patterns.blackdots.app.service.instrument;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.filaretov.spring.patterns.blackdots.app.service.InstrumentsService;
import pro.filaretov.spring.patterns.blackdots.app.service.instrument.parts.StringExpert;

@Configuration
public class PianoExpertTestConfig {

    @MockBean
    InstrumentsService instrumentsService;

    @Bean
    public PianoExpert pianoExpert() {
        return new PianoExpert();
    }

    @Bean
    public StringExpert stringExpert() {
      return new StringExpert();
    }
}
