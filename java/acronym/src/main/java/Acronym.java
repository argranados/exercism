class Acronym {
    String phrase;

    Acronym(String phrase) {
        this.phrase = phrase;
    }

    String get() {
        phrase = phrase.replace("-"," ").replace("_", " ");
        String [] tokens= phrase.trim().split(" ");
        StringBuilder acronym = new StringBuilder();

        for (String token : tokens){
            if(!token.trim().isEmpty()){
                acronym.append(token.toUpperCase().charAt(0));
            }
        }
        return acronym.toString();
    }

}
