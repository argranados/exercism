import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;

class GrepTool {

    String grep(String pattern, List<String> flags, List<String> files) {
        StringBuilder result = new StringBuilder();
        Pattern regexPattern = Pattern.compile(pattern);

        for (String file : files) {
            try {
                List<String> lines = Files.readAllLines(Paths.get(file));
                int i = 0;
                for (String line : lines) {
                    System.out.print(line);
                    i++;
                    boolean match = false;

                    if (flags.contains("-i")) {
                        if (line.toLowerCase().contains(pattern.toLowerCase())) {
                            match = true;
                        }
                    } else if (flags.contains("-x")) {
                        if (line.equals(pattern)) {
                            match = true;
                        }
                    } else {
                        if (line.contains(pattern)) {
                            match = true;
                        }
                    }

                    if ( match ) {
                        if (flags.contains("-n")) {
                            result.append(i).append(":");
                        }
                        if (flags.contains("-l")) {
                            result.append(file);
                            break;
                            
                        }
                        
                        result.append(line).append("\n");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println(result.toString()+ " .");
        return result.toString().replaceFirst("\n$", "");
    }

}