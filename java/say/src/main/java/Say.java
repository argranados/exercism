import java.util.HashMap;
import java.util.Map;

public class Say {

    public String say(long number) {
        System.out.println(number);

        if (number < 0 || number > 999_999_999_999L){
            throw new IllegalArgumentException();
        }

        int thousand = 0;
        int million = 0;
        long billion = 0;
        String stringValue = "";
        String billiondString ="";
        String milliondString ="";
        String thousandString ="";
        String hundredString = "";
        if (number == 0 ) { {
            return getStringValue(number);
        }}
        if (number / 1000000000 > 0){
            billion = number / 1000000000;
            number = number % 1000000000;
            billiondString = getStringValue(billion) + " " + "billion ";
        }
        if (number / 1000000 > 0){
            million = (int) number / 1000000;
            number = number % 1000000;
            milliondString = getStringValue(million) + " " + "million ";
        }
        if (number / 1000 > 0){
            thousand = (int) number / 1000;
            number = number % 1000;
            thousandString = getStringValue(thousand) + " " + "thousand ";
        }
        if (number > 0 ) {
            hundredString =  getStringValue(number);
        }
        stringValue = billiondString + milliondString + thousandString + hundredString;
        System.out.println(stringValue);
        return stringValue.trim();
    }

    public String getStringValue(long number) {
        String stringNumber = "";
        Map<Integer, Integer> digitsMap = mapPlaceValueOfDigit(number);

        //get string value for units
        if (digitsMap.size() == 1) {
            stringNumber = getNameOfDigit(digitsMap.get(1));
        }
        //get string value for tens
        if (digitsMap.size() == 2) {
            String tens  = getNameOfTens(digitsMap.get(2));
            String units = getNameOfDigit(digitsMap.get(1));
            if (number < 20){
                stringNumber = units+tens;
            } else if (units.equals("zero")) {
                stringNumber = tens;
            } else {
                stringNumber = tens + "-" + units;
            }
        }
        //get string value for hundreds
        if (digitsMap.size() == 3) {
            String hundreds = getNameOfDigit(digitsMap.get(3));
            String tens  = getNameOfTens(digitsMap.get(2));
            String units = getNameOfDigit(digitsMap.get(1));
            if (units.equals("zero")) {
                stringNumber = hundreds + " "+"hundred";
            } else {
                stringNumber = hundreds + " " + "hundred" + " " + tens + "-" + units;
            }
        }

        return stringNumber;
    }

    private Map<Integer, Integer> mapPlaceValueOfDigit(long number) {
        Map<Integer, Integer> digitsMap = new HashMap<>();
        if (number == 0) {
            digitsMap.put(1,0);
        }
        int counter = 1;
        while (number > 0) {
                int digit = (int) (number % 10);
                digitsMap.put(counter++ , digit);
                number = number / 10;
        }
        return digitsMap;
    }

    private String getNameOfDigit(int digit) {
        String stringNumber ="";
        switch (digit) {
            case 0 : stringNumber = "zero";
                break;
            case 1 : stringNumber = "one";
                break;
            case 2 : stringNumber = "two";
                break;
            case 3 : stringNumber = "three";
                break;
            case 4 : stringNumber = "four";
                break;
            case 5 : stringNumber = "five";
                break;
            case 6 : stringNumber = "six";
                break;
            case 7 : stringNumber = "seven";
                break;
            case 8 : stringNumber = "eight";
                break;
            case 9 : stringNumber = "nine";
                break;
            default : stringNumber ="";
        }
        return stringNumber;
    }

    private String getNameOfTens(int tens) {
        String stringNumber ="";
        switch (tens) {
            case 1 : stringNumber = "teen";
                break;
            case 2 : stringNumber = "twenty";
                break;
            case 3 : stringNumber = "thirty";
                break;
            case 4 : stringNumber = "forty";
                break;
            case 5 : stringNumber = "fifty";
                break;
            case 6 : stringNumber = "sixty";
                break;
            case 7 : stringNumber = "seventy";
                break;
            case 8 : stringNumber = "eighty";
                break;
            case 9 : stringNumber = "ninety";
                break;
            default : stringNumber ="";
        }
        return stringNumber;
    }
}

