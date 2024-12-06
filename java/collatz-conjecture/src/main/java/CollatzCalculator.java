class CollatzCalculator {

    int computeStepCount(int start) {
        if (start < 1) {
            throw new IllegalArgumentException("Only positive integers are allowed");
        }
        return compute(start);
    }

    //recursive
    int compute(int start) {
        int count =0;
//        System.out.print(start + "  ");

        if (start == 1){
            return 0;
        } else if (start % 2 == 0){
            start = start / 2;
//            System.out.println("Even calling compute..");
        } else {
//            System.out.println("Odd");
            start = start * 3 + 1;
        }
        count = compute(start) + 1;
        return count;
    }

}
