package scn1.algh.hot100;

import java.util.*;

public class Main {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            map.computeIfAbsent(new String(charArray), k -> new ArrayList<>()).add(str);
            /*if(map.containsKey(new String(charArray))){
                List<String> strings = map.get(new String(charArray));
                strings.add(str);
                map.put(new String(charArray),strings);
            }else{
                map.getOrDefault(new String(charArray),new ArrayList<>());
                List<String> strings = map.get(new String(charArray));
                strings.add(str);
                map.put(new String(charArray),strings);
            }*/
        }
        return new ArrayList<>(map.values());
    }


}
