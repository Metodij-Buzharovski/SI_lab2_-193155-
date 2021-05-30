import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    SILab2 object = new SILab2();

    private List<Time> createList(Time... elements){
        return new ArrayList<>(Arrays.asList(elements));
    }
    private List<Integer> returnList(Integer... elements){
        return new ArrayList<>(Arrays.asList(elements));
    }

    @Test
    void multipleConditionTest(){
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> object.function(createList(new Time(-1, 0, 0))));
        assertEquals(ex.getMessage(), "The hours are smaller than the minimum");
        ex = assertThrows(RuntimeException.class, () -> object.function(createList(new Time(25, 0, 0))));
        assertEquals(ex.getMessage(), "The hours are grater than the maximum");
        assertEquals(returnList(20), object.function(createList(new Time(0, 0, 20))));
        ex = assertThrows(RuntimeException.class, () -> object.function(createList(new Time(1, -1, 0))));
        assertEquals(ex.getMessage(), "The minutes are not valid!");
        ex = assertThrows(RuntimeException.class, () -> object.function(createList(new Time(1, 61, 0))));
        assertEquals(ex.getMessage(), "The minutes are not valid!");
        ex = assertThrows(RuntimeException.class, () -> object.function(createList(new Time(0, 0, -1))));
        assertEquals(ex.getMessage(), "The seconds are not valid");
        ex = assertThrows(RuntimeException.class, () -> object.function(createList(new Time(0, 0, 60))));
        assertEquals(ex.getMessage(), "The seconds are not valid");
        ex = assertThrows(RuntimeException.class, () -> object.function(createList(new Time(24, 1, 0))));
        assertEquals(ex.getMessage(), "The time is greater than the maximum");
        ex = assertThrows(RuntimeException.class, () -> object.function(createList(new Time(24, 0, 1))));
        assertEquals(ex.getMessage(), "The time is greater than the maximum");
        assertEquals(returnList(86400), object.function(createList(new Time(24, 0, 0))));
    }
}
