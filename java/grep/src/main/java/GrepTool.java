import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GrepTool {

    String grep(String pattern, List<String> flags, List<String> files) {
        StringBuilder result = new StringBuilder();
        Pattern regexPattern = Pattern.compile(pattern);

        for (String file : files) {
            try {
                List<String> lines = Files.readAllLines(Paths.get(file));
                for (String line : lines) {
                    int i = 1;
                    Matcher matcher = regexPattern.matcher(line);
                    if (matcher.find()) {
                        if (flags.contains("-n")) {
                            result.append(i + 1).append(":");
                        }
                        result.append(line); //.append(System.lineSeparator());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result.toString();
    }

}