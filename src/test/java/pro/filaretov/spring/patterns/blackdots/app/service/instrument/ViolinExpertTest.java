package pro.filaretov.spring.patterns.blackdots.app.service.instrument;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pro.filaretov.spring.patterns.blackdots.app.domain.MusicInstrument;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ViolinExpertTestConf.class)
class ViolinExpertTest {

    @Autowired
    private ViolinExpert violinExpert;

    @Test
    void getType() {
        assertEquals(MusicInstrument.VIOLIN, violinExpert.getType());
    }
}