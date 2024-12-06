import java.util.*;
import java.util.stream.Collectors;

class HighScores {
    List<Integer> scoresList;

    public HighScores(List<Integer> highScores) {
        scoresList = new ArrayList<>(highScores);
    }

    List<Integer> scores() {
        return scoresList;
    }

    Integer latest() {
        return scoresList.getLast();
    }

    Integer personalBest() {
        return  Collections.max(scoresList);
    }

    List<Integer> personalTopThree() {
        return scoresList.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
    }

}
