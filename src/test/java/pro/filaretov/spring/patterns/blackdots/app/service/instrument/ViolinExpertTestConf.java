package pro.filaretov.spring.patterns.blackdots.app.service.instrument;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pro.filaretov.spring.patterns.blackdots.app.service.instrument.parts.StringExpert;

/**
 * Test configuration for {@link ViolinExpertTest}.
 */
@Configuration
@Import(ExpertCommonConf.class)
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
