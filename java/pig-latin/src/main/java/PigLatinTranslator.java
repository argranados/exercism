import java.util.StringTokenizer;

class PigLatinTranslator {
    public static final String PIG_SUFFIX = "ay";

    public String translate(String word) {
        StringTokenizer tokenizer = new StringTokenizer(word);
        String translated = new String();

        while (tokenizer.hasMoreTokens()) {
            translated += translateWord(tokenizer.nextToken()) + " ";
        }

        return translated.trim();
    }

    String translateWord(String word) {
        if (beginsWithVowel(word) || beginsWithXRorYT(word) ) {        // RULE 1
            return word.concat(PIG_SUFFIX);
        } else {
            return beginsWithOneOrMoreConsonants(word) + PIG_SUFFIX; // RULE 2,3,4
        }
    }

    boolean beginsWithVowel(String word) {  
        char firstLetter = word.toLowerCase().charAt(0);
        return (firstLetter == 'a' ||
                firstLetter == 'e' ||
                firstLetter == 'i' ||
                firstLetter == 'o' ||
                firstLetter == 'u');
    }

    String beginsWithOneOrMoreConsonants(String word) {
        StringBuilder suffix = new StringBuilder();
        boolean BEGIN_OF_WORD=true;     // it is true only in first iteration of while loop
        
        while (word.length() > 1 && !beginsWithVowel(word)) {
            if (beginsWithQU(word)) {
                suffix.append(word.substring(0,2));
                word = word.substring(2);
                System.out.println( "Begins with QU "+suffix + " " + word);
                continue;
            } else if (beginsWithY(word)) { // YTreatedLikeAConsonantAtTheBeginningOfAWord
                if (BEGIN_OF_WORD) {
                    suffix.append(word.charAt(0)); 
                    word = word.substring(1);
                    break;    
                } else {    // YTreatedLikeAVowelAtTheEndOfAConsonantCluster
                    break;
                }
            }
            suffix.append(word.charAt(0)); 
            word = word.substring(1);
            BEGIN_OF_WORD = false;
        }

        word = word.concat(suffix.toString());
        System.out.println(word);
        return word;
    }

    boolean beginsWithQU(String word) {
        if (word.length() < 2) {
            return false;
        }
        return word.toLowerCase().substring(0,2).equals("qu");        
    }

    boolean beginsWithXRorYT(String word) {
        String startChars = word.substring(0, 2);
            return startChars.equals("xr") || startChars.equals("yt");        
    }

    boolean beginsWithY(String word) {
        return word.toLowerCase().charAt(0) == 'y';
    }
    

}