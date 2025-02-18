import java.util.HashMap;
import java.util.Map;

class NucleotideCounter {
    
    Map<Character, Integer> nucleotideCounts; 

    NucleotideCounter(String sequence) {
        nucleotideCounts = new HashMap<>();
        
        nucleotideCounts.put('A', 0);
        nucleotideCounts.put('C', 0);
        nucleotideCounts.put('G', 0);
        nucleotideCounts.put('T', 0);
        
        for (char nucleotide : sequence.toCharArray()) {
            if (!nucleotideCounts.containsKey(nucleotide)) {
                throw new IllegalArgumentException();
            }
            nucleotideCounts.put(nucleotide, nucleotideCounts.get(nucleotide) + 1);
        }
        
    }

    Map<Character, Integer> nucleotideCounts() {
        return nucleotideCounts;
    }

}