class RnaTranscription {

    String transcribe(String dnaStrand) {
        StringBuilder rna = new StringBuilder(dnaStrand.length());
        for (int i = 0; i < dnaStrand.length(); i++) {
            if (dnaStrand.charAt(i) == 'C') {
                rna.insert(i, 'G');
            } else if (dnaStrand.charAt(i) == 'G') {
                rna.insert(i, 'C');
            } else if (dnaStrand.charAt(i) == 'T') {
                rna.insert(i, 'A');
            } else if (dnaStrand.charAt(i) == 'A') {
                rna.insert(i, 'U');
            }
        }

        return rna.toString();
    }

}
