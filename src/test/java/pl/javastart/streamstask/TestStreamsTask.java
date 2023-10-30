package pl.javastart.streamstask;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestStreamsTask {
    private StreamsTask streamsTask;
    private List<User> users;
    private List<Expense> expenses;

    @BeforeEach
    public void setUp() {
        // given
        streamsTask = new StreamsTask();
        users = new ArrayList<>();
        users.add(new User(1L, "Alicja", 20));
        users.add(new User(2L, "Dominik", 15));
        users.add(new User(3L, "Patrycja", 25));
        users.add(new User(4L, "Marcin", 30));
        users.add(new User(5L, "Tomek", 18));
        users.add(new User(6L, "Damian", 26));

        expenses = new ArrayList<>();
        expenses.add(new Expense(1L, "Buty", new BigDecimal("149.99"), ExpenseType.WEAR));
        expenses.add(new Expense(1L, "Sałatka", new BigDecimal("14.99"), ExpenseType.FOOD));
        expenses.add(new Expense(2L, "Bluza", new BigDecimal("100"), ExpenseType.WEAR));
        expenses.add(new Expense(2L, "Skarpetki", new BigDecimal("39"), ExpenseType.WEAR));
        expenses.add(new Expense(2L, "Pizza", new BigDecimal("25"), ExpenseType.FOOD));
    }

    @Test
    public void shouldReturnAverage22_25() {
        // when
        Double averageMenAge = streamsTask.averageMenAge(users);

        // then
        assertEquals(22.25, averageMenAge);
    }

    @Test
    public void shouldReturn2Women() {
        // when
        Collection<User> women = streamsTask.findWomen(users);

        // then
        assertEquals(2, women.size());
    }

    @Test
    public void shouldReturnAlicjaAndPatrycja() {
        // when
        Collection<User> women = streamsTask.findWomen(users);

        // then
        assertTrue(women.contains(new User(1L, "Alicja", 20)));
        assertTrue(women.contains(new User(3L, "Patrycja", 25)));
        assertFalse(women.contains(new User(2L, "Dominik", 15)));
        assertFalse(women.contains(new User(4L, "Marcin", 30)));
        assertFalse(women.contains(new User(5L, "Tomek", 18)));
        assertFalse(women.contains(new User(6L, "Damian", 26)));
    }

    @Test
    public void shouldReturn2UsersByExpenses() {
        // when
        Map<User, List<Expense>> result = streamsTask.groupExpensesByUser(users, expenses);

        // then
        assertEquals(2, result.size());
    }

    @Test
    public void shouldReturn3ExpensesForUser2() {
        // when
        Map<User, List<Expense>> result = streamsTask.groupExpensesByUser(users, expenses);
        User user2 = new User(2L, "Dominik", 15);

        // then
        assertTrue(result.containsKey(user2));
        assertEquals(3, result.get(user2).size());
    }

    @Test
    public void shouldReturn2UsersIdByExpenses() {
        // when
        Map<Long, List<Expense>> result = streamsTask.groupExpensesByUserId(users, expenses);

        // then
        assertEquals(2, result.size());
    }

    @Test
    public void shouldReturn3ExpensesForUserId2() {
        // when
        Map<Long, List<Expense>> result = streamsTask.groupExpensesByUserId(users, expenses);

        // then
        assertTrue(result.containsKey(2L));
        assertEquals(3, result.get(2L).size());
    }
}
