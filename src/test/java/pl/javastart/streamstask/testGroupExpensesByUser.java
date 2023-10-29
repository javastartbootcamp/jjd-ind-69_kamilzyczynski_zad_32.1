package pl.javastart.streamstask;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testGroupExpensesByUser {

    private StreamsTask streamsTask;
    private List<User> users;
    private List<Expense> expenses;
    @Before
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
}
