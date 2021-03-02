package pro.filaretov.spring.patterns.blackdots.app.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Music instrument.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MusicInstrument {

    public static final String PIANO = "Grand Piano";
    public static final String VIOLIN = "Stradivari Violin";
    public static final String TRIANGLE = "Silver Triangle";

    private String type;

    @Override
    public String toString() {
        return type;
    }
}
