// EXAMPLE TEST (CSCI 630): Reference implementation for MVC test (Controller slice). Do not delete.
package com.sarasitha.budgettracker.examples;

import com.sarasitha.budgettracker.config.WebSecurityConfig;
import com.sarasitha.budgettracker.controller.TransactionController;
import com.sarasitha.budgettracker.model.User;
import com.sarasitha.budgettracker.repository.IncomeRepository;
import com.sarasitha.budgettracker.repository.TransactionRepository;
import com.sarasitha.budgettracker.service.UserService;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Tag("example")
@WebMvcTest(TransactionController.class)
@Import(WebSecurityConfig.class)
public class ExampleTransactionControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionRepository transactionRepository;

    @MockBean
    private IncomeRepository incomeRepository;

    @MockBean
    private UserService userService;

    // Needed for WebSecurityConfig to start up
    @MockBean
    private UserDetailsService userDetailsService;

    @Test
    void testAnonymousAccessRoot_ReturnsLandingPage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("landing"));
    }

    @Test
    @WithMockUser(username = "alice")
    void testAuthenticatedAccessRoot_ReturnsHomePageWithModel() throws Exception {
        // Setup mocks
        User mockUser = new User();
        mockUser.setId(42L);
        mockUser.setUsername("alice");

        given(userService.findByUsername("alice")).willReturn(mockUser);
        given(transactionRepository.findByUserId(42L)).willReturn(Collections.emptyList());
        given(incomeRepository.findByUserId(42L)).willReturn(Collections.emptyList());

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(model().attributeExists("transactions"))
                .andExpect(model().attributeExists("incomeList"));
    }
}
