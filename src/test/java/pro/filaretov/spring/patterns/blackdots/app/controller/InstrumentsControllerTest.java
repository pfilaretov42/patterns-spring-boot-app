package pro.filaretov.spring.patterns.blackdots.app.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@WebMvcTest
@ContextConfiguration(classes = ControllerTestConfig.class)
class InstrumentsControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void getAll() throws Exception {
        mvc.perform(get("/api/v1/instruments")).
            andExpect(MockMvcResultMatchers.status().isOk());
    }
}