import java.util.HashMap;
import java.util.Map;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        Map<String, Integer> lettersMap = new HashMap<>();

        for (String letter : phrase.toLowerCase().split("")) {
            if (letter.equals("-") || letter.equals(" ")) {
                continue;
            }
            if (!lettersMap.containsKey(letter)){
                lettersMap.put(letter,1);
            } else {
                return false;
            }
        }
//        System.out.println(lettersMap);
        return true;
    }

}
