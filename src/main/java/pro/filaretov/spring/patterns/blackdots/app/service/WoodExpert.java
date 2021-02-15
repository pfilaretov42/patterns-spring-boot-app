package pro.filaretov.spring.patterns.blackdots.app.service;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Expert in music instruments' wood.
 */
@Service
@Slf4j
public class WoodExpert {

    @PostConstruct
    public void postConstruct() {
        log.info("Wood expert is here");
    }
}
