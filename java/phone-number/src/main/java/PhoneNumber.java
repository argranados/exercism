class PhoneNumber {
    String number;
    String areaCode;
    String exchangeCode;
    String subscriberNumber;

    PhoneNumber(String numberString) {
        if (numberString.matches(".*[!@#$%^&*,?\":{}|<>]+.*")) {
            throw new IllegalArgumentException("punctuations not permitted");
            
        }
        if (numberString.matches(".*[a-zA-Z]+.*")) {
            throw new IllegalArgumentException("letters not permitted");
            
        }
        
        extractNumber(numberString);
        if (number.charAt(0) != '1' && number.length() == 11) {
            throw new IllegalArgumentException("11 digits must start with 1");
            
        }
        if (number.length() > 11) {
            throw new IllegalArgumentException("must not be greater than 11 digits");
            
        }
        if (number.length() == 11 && number.charAt(0) == '1') {
            number = number.substring(1);
        }
        if (number.length() < 10) {
            throw new IllegalArgumentException("must not be fewer than 10 digits");
        }
        if (number.length() != 10) {
            throw new IllegalArgumentException("Number must be 10 or 11 digits");
        }
        if (number.charAt(0) == '1') {
            throw new IllegalArgumentException("area code cannot start with one");
            
        }
        if (areaCode.charAt(0) == '0') {
            throw new IllegalArgumentException("area code cannot start with zero");
            
        }
        if (exchangeCode.charAt(0) == '0') {
            throw new IllegalArgumentException("exchange code cannot start with zero");
            
        }
        if (exchangeCode.charAt(0) == '1') {
            throw new IllegalArgumentException("exchange code cannot start with one");
            
        }

    }

    String getNumber() {        
        return number;
    }

    void extractNumber(String numberString) {
        this.number = numberString.replaceAll("[^0-9]", "");
        this.areaCode = number.length() == 10 ? number.substring(0, 3) : number.substring(1, 4);
        this.exchangeCode = number.length() == 10 ? number.substring(3, 6) : number.substring(4, 7);
        this.subscriberNumber = number.length() == 10 ? number.substring(6) : number.substring(7);
    }

}