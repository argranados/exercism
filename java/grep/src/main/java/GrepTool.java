import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GrepTool {

    String grep(String pattern, List<String> flags, List<String> files) {
        StringBuilder result = new StringBuilder();

        for (String file : files) {
            try {
                List<String> lines = Files.readAllLines(Paths.get(file));
                int i = 0;
                for (String line : lines) {
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
                    
                    // match whole word
                    if (flags.isEmpty() || flags.contains("-n" ) || flags.contains("-l" )) { // default match
                        String wordPattern = "\\b" + Pattern.quote(pattern) + "\\b";
                        Pattern wordRegexPattern = Pattern.compile(wordPattern);
                        Matcher wordMatcher = wordRegexPattern.matcher(line);
                        if (wordMatcher.find()) {
                            matchDefault = true;
                        }
                    }
                    
                    // -l and -x use case
                    if (flags.size() == 2 && (matchWholeLine && !matchInvert)) {
                        continue;
                    }

                    // -l flag logic
                    if ((flags.contains("-l") || files.size() > 1 ) && (matchDefault || matchCase || matchWholeLine || matchInvert)) {
                        result.append(file);
                        if ( files.size() > 1 ) {
                            if ( flags.size() == 1 && flags.contains("-l")) {  // this means FILES_NAMES only
                                result.append("\n");
                                break;
                            } else if ( flags.size() == 2 & flags.contains("-n")) { // File Flag Takes Precedence Over Line Number Flag
                                result.append("\n");
                                continue;
                            } else {                       // this means there are more flags, so will append the line
                                result.append(":");
                            }
                        }  else {                          // this means only one file is being processed and flag is -l => FILES_NAMES_ONLY
                             break; 
                        }

                    }

                    if ( matchDefault | matchCase | matchWholeLine | matchInvert ) {
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
 
        return result.toString().replaceFirst("\n$", "");
    }

}