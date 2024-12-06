class RaindropConverter {

    String convert(int number) {
        String sound = "";

        if(isDivisible(number, 3)){
            sound = sound.concat("Pling");
        }
        if (isDivisible(number, 5)) {
            sound = sound.concat("Plang");
        }
        if (isDivisible(number, 7)) {
            sound = sound.concat("Plong");
        }
        if (sound.isEmpty()) {
            sound = String.valueOf(number);
        }

        return sound;
    }

    private boolean isDivisible(int number, int divisible) {
            return (number % divisible == 0);
        }

}
