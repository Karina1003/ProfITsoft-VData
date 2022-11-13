package lecture1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;


class MainTest {

    //Task 1
    @Test
    void testReturnPositive() {
        int[] testArray = Main.returnPositive(new int[]{1,2,-3,4,0,-5,-12});
        Assertions.assertArrayEquals(new int[] {4,2,1,0}, testArray);
    }

    @Test
    void testReturnPositiveAllNegative() {
        int[] testArray = Main.returnPositive(new int[]{-1,-2,-3,-4,-5,-12});
        Assertions.assertArrayEquals(new int[] {}, testArray);
    }

    @Test
    void testReturnPositiveNulls() {
        int[] testArray = Main.returnPositive(new int[]{});
        Assertions.assertArrayEquals(new int[] {}, testArray);
    }

    //Task 2
    @Test
    void testTopFiveHashTags() {
        List<String> testList = List.of("#a,#b,#b #c, e, #d","#a,#c,#e","#a,#a,#c,#e,#d","#a,#f");
        Map<String,Integer> testMap = Main.topFiveHashTags(testList);
        Map<String,Integer> checkMap = new LinkedHashMap<>();
        checkMap.put("#a",4);
        checkMap.put("#c",3);
        checkMap.put("#d",2);
        checkMap.put("#e",2);
        checkMap.put("#b",1);
        Assertions.assertEquals(checkMap, testMap);
    }

    @Test
    void testTopFiveHashTagsNulls() {
        List<String> testList = new ArrayList<>();
        Map<String,Integer> testMap = Main.topFiveHashTags(testList);
        Map<String,Integer> checkMap = new LinkedHashMap<>();
        Assertions.assertEquals(checkMap, testMap);
    }

    @Test
    void testTopFiveHashTagsLessThanFive() {
        List<String> testList = List.of("#a,#b,#b","#a","#a, f");
        Map<String,Integer> testMap = Main.topFiveHashTags(testList);
        Map<String,Integer> checkMap = new LinkedHashMap<>();
        checkMap.put("#a",3);
        checkMap.put("#b",1);
        Assertions.assertEquals(checkMap, testMap);
    }

    //Task 3
    @Test
    void testSortByVolume() {
        List<Shape> testList = new ArrayList<>();
        testList.add(new Sphere(3.5));
        testList.add(new Cube(12));
        testList.add(new Cylinder(2.12, 13));
        Main.sortByVolume(testList);
        List<Shape> checkList = new LinkedList<>();
        checkList.add(new Sphere(3.5));
        checkList.add(new Cylinder(2.12, 13));
        checkList.add(new Cube(12));
        Assertions.assertEquals(checkList, testList);
    }

    @Test
    void testSortByVolumeAllNulls() {
        List<Shape> testList = new ArrayList<>();
        Main.sortByVolume(testList);
        List<Shape> checkList = new LinkedList<>();
        Assertions.assertEquals(checkList, testList);
    }

    @Test
    void testSortByVolumeNullValue() {
        List<Shape> testList = new ArrayList<>();
        testList.add(new Sphere(3.5));
        testList.add(null);
        testList.add(new Cylinder(2.12, 13));
        NullPointerException nullPointerException =
                Assertions.assertThrows(NullPointerException.class,
                                        () -> Main.sortByVolume(testList));
        Assertions.assertEquals("Object in this list can`t be null", nullPointerException.getMessage());
    }
}