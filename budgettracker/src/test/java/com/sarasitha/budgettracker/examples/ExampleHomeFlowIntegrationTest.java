// EXAMPLE TEST (CSCI 630): Reference implementation for Integration test (full Spring). Do not delete.
package com.sarasitha.budgettracker.examples;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Tag("example")
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ExampleHomeFlowIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAnonymousAccess() throws Exception {
        // Access login page
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));

        // Access root page (should land on "landing" as per security config permitAll)
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("landing"));
    }
}
