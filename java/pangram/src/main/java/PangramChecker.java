import java.util.Arrays;

public class PangramChecker {

    String abc = "abcdefghijklmnopqrstuvwxyz";

    public boolean isPangram(String input) {
        input = input.toLowerCase();
        for (Character c : abc.toCharArray()) {
            if ( !input.contains(c.toString())){
                return false;
            }
        }
        return true;
    }

}
