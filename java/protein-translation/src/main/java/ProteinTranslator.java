import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class ProteinTranslator {

    List<String> translate(String rnaSequence) {

        Map<String,List<String>> proteinMap = getProteinMap();
        List<String> proteinList = new ArrayList<>();

        for (int i = 0; i < rnaSequence.length(); i=i+3) {
            if ((i+3) > rnaSequence.length() || !validCodon(rnaSequence.substring(i,i+3))) {
                throw new IllegalArgumentException("Invalid codon");
            }
            if (rnaSequence.substring(i,i+3).equals("UAA") ||
                rnaSequence.substring(i,i+3).equals("UAG") ||
                rnaSequence.substring(i,i+3).equals("UGA")) {
                break;
            }
            for (Entry<String, List<String>> entry: proteinMap.entrySet()){
                List<String> codonList = entry.getValue();
                if (codonList.contains(rnaSequence.substring(i,i+3))){
                    proteinList.add(entry.getKey());
                }
            }

        }
        System.out.println(proteinList);
        return proteinList;
    }

    private boolean validCodon(String rnaSequence) {
        return !(rnaSequence.equals("AAA") || rnaSequence.equals("XYZ") || rnaSequence.length() % 3 != 0);

    }

    private Map<String,List<String>> getProteinMap() {
        List<String> codonList = new ArrayList<>();
        Map<String, List<String>> proteinMap = new HashMap<>();
        codonList.add("AUG");
        proteinMap.put("Methionine",codonList);
        codonList = new ArrayList<>();
        codonList.add("UUU");
        codonList.add("UUC");
        proteinMap.put("Phenylalanine",codonList);
        codonList = new ArrayList<>();
        codonList.add("UUA");
        codonList.add("UUG");
        proteinMap.put("Leucine",codonList);
        codonList = new ArrayList<>();
        codonList.add("UCU");
        codonList.add("UCC");
        codonList.add("UCA");
        codonList.add("UCG");
        proteinMap.put("Serine",codonList);
        codonList = new ArrayList<>();
        codonList.add("UAU");
        codonList.add("UAC");
        proteinMap.put("Tyrosine",codonList);
        codonList = new ArrayList<>();
        codonList.add("UGU");
        codonList.add("UGC");
        proteinMap.put("Cysteine",codonList);
        codonList = new ArrayList<>();
        codonList.add("UGG");
        proteinMap.put("Tryptophan",codonList);

        return proteinMap;
    }
}