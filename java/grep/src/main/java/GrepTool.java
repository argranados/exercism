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
                    boolean matchCase = false;
                    boolean matchWholeLine = false;
                    boolean matchInvert = false;
                    boolean matchDefault = false;

                    if (flags.contains("-i")) { // ignore case
                        if (line.toLowerCase().contains(pattern.toLowerCase())) {
                            matchCase = true;
                        }
                    } 
                    if (flags.contains("-x")) { // match whole line
                        if (line.equals(pattern)) {
                            matchWholeLine = true;
                        }
                    } 
                    if (flags.contains("-v")) { // invert match : print lines that do not contain the pattern
                            matchInvert = !line.contains(pattern);
                    }
                    if (flags.isEmpty() || flags.contains("-n" ) || flags.contains("-l" )) { // default match
                        if (line.contains(pattern)) {
                            matchDefault = true;
                        }
                        
                    } 

                    if (flags.contains("-l") && (matchDefault || matchCase || matchWholeLine || matchInvert)) {
                        result.append(file);
                        break;  
                    }
                    // these two flags cannot exlude each other need to be compared as a pair    
                    if (flags.size() == 2 && (matchWholeLine && !matchInvert)) {
                        continue;
                    }

                    if ( matchDefault ) {
                        if (flags.contains("-n")) { // print line numbers
                            result.append(i).append(":");
                        }
                        result.append(line).append("\n");
                        continue;
                    } 
                    if (matchCase ) {
                        if (flags.contains("-n")) { // print line numbers
                            result.append(i).append(":");
                        }
                        result.append(line).append("\n");
                        continue;
                    } 

                    if (matchInvert) {   // print lines that do not contain the pattern
                        if (flags.contains("-n")) { 
                            result.append(i).append(":");
                        }
                        result.append(line).append("\n");
                        continue;
                    } 


                    if (matchWholeLine) {
                        if (flags.contains("-n")) { // print line numbers
                            result.append(i).append(":");
                        }
                        result.append(line).append("\n");
                        continue;
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