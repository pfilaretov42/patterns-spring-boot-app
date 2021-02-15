package pro.filaretov.spring.patterns.blackdots.app.service;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Expert in adjusting pianos.
 */
@Service
@Slf4j
public class PianoExpert {

    @PostConstruct
    public void postConstruct() {
        log.info("Piano expert is here");
    }

    public void adjust() {
        log.info("piano adjusted");
    }
}
