import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;

class LuhnValidator {

    boolean isValid(String candidate) {
        int sum = 0;
        candidate = candidate.replace(" ","");

        if (candidate.length() < 2){
            return false;
        }

        if(! Pattern.compile("^\\d+$").matcher(candidate).find()){
            return false;
        }

        String[] strArray = candidate.split("");
//        System.out.println(Arrays.toString(strArray));
        Collections.reverse(Arrays.asList(strArray));
//        System.out.println(Arrays.toString(strArray));
        int [] intArray = Arrays.stream(strArray).mapToInt(Integer::parseInt).toArray();

        for (int i = 1; i < intArray.length; i = i +2) {
//            System.out.println(intArray[i] +"  " + (intArray[i] *2));
            int duplicate = (intArray[i] *2);
            int newValue = duplicate > 9 ? duplicate - 9 : duplicate;
            intArray[i] = newValue;

        }
            sum = Arrays.stream(intArray).sum();
//            System.out.println(Arrays.toString(intArray) + " sum:" +sum );

        return sum % 10 == 0;
    }

}
