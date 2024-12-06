class PrimeCalculator {

    int nth(int nth) {
        int count=0, number = 1;

        if (nth < 1){
            throw new IllegalArgumentException();
        }

        while(count != nth) {
            if(isPrime(++number)){
                count++;
//                System.out.print(number + " ");
            }
        }

        return number;
    }

    boolean isPrime(int number) {
        if (number == 2 || number == 3) {
            return true;
        } else {
            int maxDiv = (int) Math.sqrt(number);
            for (int i = 2; i <= maxDiv; i++) {
                if (number % i == 0){
                    return false;
                }
            }
            return true;
        }
    }

}

//This is the simplest way to check if a number is prime. 
// It involves dividing the number by all integers starting 
// from 2 up to the square root of the number.
//
//If the number is divisible by any of these integers, it is not a prime number.
//If none of these integers divide the number, then it is a prime number.
//        Example: To check if 29 is prime, check divisibility by all integers 
//        from 2 to √29 (approximately 5.39). Since 29 is not divisible
//        by 2, 3, or 5, it is a prime number.
//https://www.geeksforgeeks.org/prime-number-formulas/
