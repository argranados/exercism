import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class DnDCharacter {
    int strength;
    int dexterity;
    int intelligence;
    int wisdom;
    int charisma;
    int constitution;

    DnDCharacter(){
        this.strength = ability(rollDice());
        this.dexterity = ability(rollDice());
        this.intelligence = ability(rollDice());
        this.wisdom = ability(rollDice());
        this.charisma = ability(rollDice());
        this.constitution = ability(rollDice());
    }

    int ability(List<Integer> scores) {
        List<Integer> scoreList = new ArrayList<>(scores);
        scoreList.sort(null);
        scoreList.remove(0);

        return scoreList.stream().mapToInt(i -> i).sum();
    }

    List<Integer> rollDice() {
        List<Integer> rollList = new ArrayList<>();
        Random random = new Random();
        int roll = 0;

        for (int i = 0; i < 4; i++) {
            roll = random.nextInt(5) +1;
            rollList.add(roll);
        }
        return rollList;
    }

    int modifier(int input) {
        return (int) Math.floor((input-10)/2.0);
    }

    int getStrength() {
        return strength;
    }

    int getDexterity() {
        return dexterity;
    }

    int getConstitution() {
        return constitution;
    }

    int getIntelligence() {
        return intelligence;
    }

    int getWisdom() {
        return wisdom;
    }

    int getCharisma() {
        return charisma;
    }

    int getHitpoints() {
        return 10 + modifier(getConstitution());
    }
}
