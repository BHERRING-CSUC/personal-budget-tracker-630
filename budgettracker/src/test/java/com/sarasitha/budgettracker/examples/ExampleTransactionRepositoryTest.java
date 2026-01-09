// EXAMPLE TEST (CSCI 630): Reference implementation for Repository test (JPA slice). Do not delete.
package com.sarasitha.budgettracker.examples;

import com.sarasitha.budgettracker.model.Category;
import com.sarasitha.budgettracker.model.Transaction;
import com.sarasitha.budgettracker.model.User;
import com.sarasitha.budgettracker.repository.TransactionRepository;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("example")
@DataJpaTest
@ActiveProfiles("test")
public class ExampleTransactionRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    void testFindByUserId_ReturnsOnlyUserTransactions() {
        // Arrange
        User user1 = new User();
        user1.setUsername("user1");
        user1.setPassword("pass1");
        entityManager.persist(user1);

        User user2 = new User();
        user2.setUsername("user2");
        user2.setPassword("pass2");
        entityManager.persist(user2);

        Transaction t1 = new Transaction();
        t1.setTitle("Lunch");
        t1.setAmount(15.00);
        t1.setDate(LocalDate.now());
        t1.setCategory(Category.FOOD);
        t1.setUser(user1);
        entityManager.persist(t1);

        Transaction t2 = new Transaction();
        t2.setTitle("Gas");
        t2.setAmount(40.00);
        t2.setDate(LocalDate.now());
        t2.setCategory(Category.TRANSPORT);
        t2.setUser(user2);
        entityManager.persist(t2);

        entityManager.flush();

        // Act
        List<Transaction> result = transactionRepository.findByUserId(user1.getId());

        // Assert
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getTitle()).isEqualTo("Lunch");
        assertThat(result.get(0).getUser().getId()).isEqualTo(user1.getId());
    }
}
