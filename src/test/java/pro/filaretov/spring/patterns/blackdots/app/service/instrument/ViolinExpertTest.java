package pro.filaretov.spring.patterns.blackdots.app.service.instrument;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import pro.filaretov.spring.patterns.blackdots.app.domain.MusicInstrument;

@ContextHierarchy(
    {
        @ContextConfiguration(classes = ExpertCommonConf.class),
        @ContextConfiguration(classes = ViolinExpertTestConf.class)
    }
)
class ViolinExpertTest extends AbstractExpertTest {

    @Autowired
    private ViolinExpert violinExpert;

    @Test
    void getType() {
        assertEquals(MusicInstrument.VIOLIN, violinExpert.getType());
    }

    @Test
    void getStringsType() {
        assertEquals("nylon", violinExpert.getStringsType());
    }
}