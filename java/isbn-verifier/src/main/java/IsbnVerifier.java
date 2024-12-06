class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        int multipllier = 10;
        int sum=0;
        stringToVerify = stringToVerify.replace("-","");

        if (stringToVerify.length() != 10) {
            return false;
        }
        for (String digit : stringToVerify.split("")){
            int number;
                try {
                    number = Integer.parseInt(digit);
                } catch (IllegalArgumentException ex) {
                    if (digit.equals("X") && stringToVerify.indexOf("X") == stringToVerify.length()-1 ){
                        number = 10;
                    } else {
                        return false;
                    }
                }
            sum += number * multipllier--;
        }
        return sum != 0 && (sum) % 11 == 0;
    }

}
