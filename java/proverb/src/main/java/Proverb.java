class Proverb {
    String[] words;

    Proverb(String[] words) {
        this.words = words;
    }

    String recite() {
        StringBuilder proverb = new StringBuilder();

        int wordsLeft = words.length;
        int index = 0;
        while (wordsLeft > 0 ) {
            if (wordsLeft > 1) {
                String p = String.format("For want of a %s the %s was lost.\n", words[index], words[index + 1]);
                proverb.append(p);
                index++;
            } else {
                proverb.append(String.format("And all for the want of a %s.", words[0]));
            }
            wordsLeft--;

        }
        return proverb.toString();
    }

}
