package domain;

import com.count.phrases.domain.BusinessException;
import com.count.phrases.domain.Counter;

import org.junit.Test;

import static org.junit.Assert.*;

public class CounterTest {

    @Test
    public void validInput() {

        Counter counter = new Counter();

        assertEquals("4 letters", counter.processText("hola"));
        assertEquals("5 letters", counter.processText("hello"));
    }

    @Test(expected = BusinessException.class)
    public void invalidInput() {

        Counter counter = new Counter();

        counter.processText("");
    }
}