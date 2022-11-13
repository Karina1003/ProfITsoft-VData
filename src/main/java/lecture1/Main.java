package lecture1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        //Task 1
        int[] array = new int[]{1,2,-7,5,4,-65,321,65,-87,34, 1};
        for(int i:returnPositive(array)){
            System.out.println(i);
        }

        //Task 2
        List<String> list = List.of("This #is a #good #day. The #similar weather was a #day #ago", "#It #is a #silver #plate I bought a #day #ago", "I sold a #silver plate. It #is great");
        System.out.println(topFiveHashTags(list));

        //Task 3
        List<Shape> listFigures = new ArrayList<>();
        listFigures.add(new Cube(4.5));
        listFigures.add(new Cube (8));
        listFigures.add(new Cylinder(3,12.3));
        listFigures.add(new Sphere(6.7));
        listFigures.add(new Cylinder(3,12.3));
        System.out.println("Order before sorting:");
        for(Shape shape:listFigures) {
            System.out.println(shape.toString());
        }
        sortByVolume(listFigures);
        System.out.println("Order after sorting:");
        for(Shape shape:listFigures) {
            System.out.println(shape.toString());
        }
    }

    /**
     * Method filters and sorts an int array and returns only positive (>=0) numbers
     * @param array - int array to be filtered and sorted
     * @return int[] arrayPositive - array of positive ints
     */
    public static int[] returnPositive (int[] array) {
        return Arrays.stream(array)
                .boxed()
                .filter(i -> i>=0)
                .sorted(Comparator.reverseOrder())
                .mapToInt(i->i)
                .toArray();
    }

    /**
     * The method searches a list of Strings to find 5 most frequent hashtags
     * @param list - list of Strings to be looked through
     * @return Map topFiveHashTags - a LinkedHashMap with 5 most frequent hashtags
     */
    public static Map<String,Integer> topFiveHashTags (List<String> list) {
        Map<String,Integer> map = new LinkedHashMap<>();
        Set<String> uniqueWords = new HashSet<>();
        if(list != null) {
            for (String string : list) {
                string = string.replaceAll("[,.!?]", " ");
                String[] strArray = string.split(" ");
                for (String s : strArray) {
                    if (s.startsWith("#") && uniqueWords.add(s)) {
                        if (!map.containsKey(s)) {
                            map.put(s, 1);
                        } else {
                            map.put(s, map.get(s) + 1);
                        }
                    }
                }
                uniqueWords.clear();
            }
        }
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue(),(n,m)->n,LinkedHashMap<String,Integer>::new));
    }

    /**
     * The method sorts figured by volume in ascending order
     * @param list - a list of figures
     */
    public static void sortByVolume (List<Shape> list) throws NullPointerException {
        list.sort((o1, o2) -> {
            if (o1 != null && o2 != null) {
                if (o1.getVolume() > o2.getVolume()) {
                    return 1;
                } else if (o1.getVolume() < o2.getVolume()) {
                    return -1;
                } else return 0;
            } else throw new NullPointerException("Object in this list can`t be null");
        });
    }
}
