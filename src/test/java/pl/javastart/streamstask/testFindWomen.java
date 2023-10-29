package pl.javastart.streamstask;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class testFindWomen {

    private StreamsTask streamsTask;
    private List<User> users;

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
}
