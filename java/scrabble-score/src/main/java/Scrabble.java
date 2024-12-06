import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Scrabble {
    List<Checker> checkers = new ArrayList<>();
    String word;

    Scrabble(String word) {
        this.word = word.toUpperCase();
        Checker checker1 = new Checker(1, Arrays.asList('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'));
        checkers.add(checker1);
        Checker checker2 = new Checker(2, Arrays.asList('D', 'G'));
        checkers.add(checker2);
        Checker checker3 = new Checker(3, Arrays.asList('B', 'C', 'M', 'P'));
        checkers.add(checker3);
        Checker checker4 = new Checker(4, Arrays.asList('F', 'H', 'V', 'W', 'Y'));
        checkers.add(checker4);
        Checker checker5 = new Checker(5, Arrays.asList('K'));
        checkers.add(checker5);
        Checker checker6 = new Checker(8, Arrays.asList('J', 'X'));
        checkers.add(checker6);
        Checker checker7 = new Checker(10, Arrays.asList('Q', 'Z'));
        checkers.add(checker7);
    }

    int getScore() {
        int score = 0;
        for (Character c : word.toCharArray()) {
            for (Checker checker : checkers) {
                if (checker.check(c) > 0) {
                    score += checker.check(c);
                }
            }
        }
        return score;
    }

    class Checker {
        int value;
        List<Character> letterList;

        Checker (int value, List<Character> letters) {
            this.value = value;
            this.letterList = letters;
        }

        public int check(Character character) {
            if (letterList.contains(character)){
                return value;
            }
            return 0;
        }
    }

}
