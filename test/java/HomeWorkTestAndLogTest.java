
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class HomeWorkTestAndLogTest {
    private HomeWorkTestAndLog homeWorkTestAndLog;

    @BeforeEach
    void init (){
        homeWorkTestAndLog = new HomeWorkTestAndLog();
    }

    @ParameterizedTest
    @MethodSource("fillSliceParams")
    void sliceTest(int[] in, int [] out) {
        Assertions.assertArrayEquals(out, homeWorkTestAndLog.checkTheArray(in));
    }

    static Stream<Arguments> fillSliceParams() {
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.arguments(new int[] {1,5,4,8,2,1,4,8,6,4,5,77,1}, new int[] {5,77,1}));
        list.add(Arguments.arguments(new int[] {4}, new int[] {}));
        list.add(Arguments.arguments(new int[] {1,5,4,8,2,1,4,8,6,5,77,1}, new int[] {8,6,5,77,1}));
        return list.stream();
    }

    @Test
    void checkTheArray1() {
    int [] array = {1,1,1,4,3,4,2,41,2,421,56};
    int [] result= {2,41,2,421,56};
        Assertions.assertArrayEquals(homeWorkTestAndLog.checkTheArray(array),result);
    }

    @Test
    void checkIfArrayContainsOneAndFour() {
        int [] array = {0,0,0,1,1,5,6,7,0};
        Assertions.assertFalse(homeWorkTestAndLog.checkIfArrayContainsOneAndFour(array));
    }

    @Test
    void checkException(){
        int [] array = {0,0,0,1,1,5,6,7,0};
        Assertions.assertThrows(RuntimeException.class, ()->homeWorkTestAndLog.checkTheArray(array));
    }

    @Test
    void checkNoException(){
        int [] array = {0,0,0,1,1,5,6,7,0};
        Assertions.assertDoesNotThrow(()->homeWorkTestAndLog.checkIfArrayContainsOneAndFour(array));
    }
}