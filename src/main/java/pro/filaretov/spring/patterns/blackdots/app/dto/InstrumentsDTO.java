package pro.filaretov.spring.patterns.blackdots.app.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pro.filaretov.spring.patterns.blackdots.app.domain.MusicInstrument;

/**
 *
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InstrumentsDTO {

    private String batchId;
    private List<MusicInstrument> instrumentList;
}
