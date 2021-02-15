package pro.filaretov.spring.patterns.blackdots.app.service;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Expert in adjusting violins.
 */
@Service
@Slf4j
public class ViolinExpert {

    private WoodExpert woodExpert;

    @PostConstruct
    public void postConstruct() {
        log.info("Violin expert is here");
    }
}
