import java.util.regex.Pattern;

class LargestSeriesProductCalculator {
    String inputNumber;

    LargestSeriesProductCalculator(String inputNumber) {
        this.inputNumber = inputNumber;
        if ( !inputNumber.isEmpty() && !Pattern.compile("^\\d+$").matcher(inputNumber).find()){
            throw new IllegalArgumentException("String to search may only contain digits.");
        }

    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        long bigger = 0;

        if (numberOfDigits > inputNumber.length()){
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        }
        if ( numberOfDigits < 0){
            throw new IllegalArgumentException("Series length must be non-negative.");
        }

        for (int i = 0; i < inputNumber.length() - numberOfDigits +1; i++) {
            String serie = inputNumber.substring(i, i + numberOfDigits);
            System.out.println(serie);
            long result = 1;
            for (String str : serie.split("")){
                result *= Integer.parseInt(str);
                System.out.println("series multiplcation "+ result);
            }
            if (result > bigger){
                bigger = result;
            }
        }
        System.out.println(bigger);
        return bigger;
    }
}
