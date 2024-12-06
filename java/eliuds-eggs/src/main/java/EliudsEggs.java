public class EliudsEggs {
    public int eggCount(int number) {

        String binaryNum = Integer.toBinaryString(number);
        System.out.println(binaryNum);
        int count = 0;
        for (int i = 0; i < binaryNum.length(); i++) {
            if (binaryNum.charAt(i) == '1'){
                count++;
            }
        }
        return count;
    }
}
