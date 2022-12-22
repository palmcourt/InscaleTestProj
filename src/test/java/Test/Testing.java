package Test;

import com.google.common.collect.Multimap;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.util.*;

public class Testing {

    public static void main(String args[]) {


        System.out.println(System.getProperty("user.dir"));

        MultiValuedMap<String, Map<String, String>> map = new ArrayListValuedHashMap<>();

        Map<String, String> map1 = new HashMap<>();
        map1.put("Christopher", "Connely");

        Map<String, String> map2 = new HashMap<>();
        map2.put("Frank", "Christopher");

        Map<String, String> map3 = new HashMap<>();
        map3.put("Christopher", "Minka");

        Map<String, String> map4 = new HashMap<>();
        map4.put("Connely", "Jackson");

        Map<String, String> map5 = new HashMap<>();
        map5.put("Jackson", "Frank");

        Map<String, String> map6 = new HashMap<>();
        map6.put("Minka", "Jackson");

        Map<String, String> map7 = new HashMap<>();
        map7.put("Jackson", "Connely");

        Map<String, String> map8 = new HashMap<>();
        map8.put("Lawrence", "Zimmerman");

        Map<String, String> map9 = new HashMap<>();
        map9.put("Mariotte", "Tova");

        map.put("L789C349", map1);
        map.put("A897N450", map2);
        map.put("M098Q585", map3);
        map.put("L789C349", map4);
        map.put("L789C349", map5);
        map.put("A897N450", map6);
        map.put("L789C349", map7);
        map.put("L789C349", map8);
        map.put("L789C349", map9);

        System.out.println(map.values());
        System.out.println(map.entries());
        System.out.println(map.size());

        List<String> firstNames = new ArrayList<>();
        List<String> lastNames = new ArrayList<>();
        List<String> postCodes = new ArrayList<>();

        for (Map.Entry<String, Map<String, String>> entry : map.entries()) {

            System.out.println(entry.getKey() + "\n   FName :" + entry.getValue().keySet().toString().replace("[", " ").replace("]", " ").trim() + "\n   LName :" + entry.getValue().values().toString().replace("[", " ").replace("]", " ").trim());
            firstNames.add(entry.getValue().keySet().toString().replace("[", " ").replace("]", " ").trim());
            lastNames.add(entry.getValue().values().toString().replace("[", " ").replace("]", " ").trim());
            postCodes.add(entry.getKey());

        }

        System.out.println(firstNames);
        System.out.println(lastNames);
        System.out.println(postCodes);

    }
}
