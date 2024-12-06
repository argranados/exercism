public class Hamming {
    String leftStrand;
    String rightStrand;

    public Hamming(String leftStrand, String rightStrand) {
        this.rightStrand = rightStrand;
        this.leftStrand = leftStrand;

        if (!(leftStrand.length() == rightStrand.length())) {
            throw  new IllegalArgumentException("strands must be of equal length");
        }
    }

    public int getHammingDistance() {

        int counter=0;
        for (int i = 0; i < leftStrand.length(); i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
                counter++;
            }
        }
        return counter;
    }
}
