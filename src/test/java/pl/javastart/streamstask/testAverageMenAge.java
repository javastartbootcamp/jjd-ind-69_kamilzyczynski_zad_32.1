package pl.javastart.streamstask;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class testAverageMenAge {

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
    public void shouldReturn22_25() {
        // when
        Double averageMenAge = streamsTask.averageMenAge(users);

        // then
        assertEquals(22.25, averageMenAge);
    }

}
