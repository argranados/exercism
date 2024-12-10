import java.util.Arrays;
import java.util.List;

class TwelveDays {

    String verse(int verseNumber) {
        String baseVerse = "On the %s day of Christmas my true love gave to me: ";
        int dayNumber = verseNumber;

        List<String> verseList = List.of(
                "",
                "a Partridge in a Pear Tree.",
                "two Turtle Doves",
                "three French Hens",
                "four Calling Birds",
                "five Gold Rings",
                "six Geese-a-Laying",
                "seven Swans-a-Swimming",
                "eight Maids-a-Milking",
                "nine Ladies Dancing",
                "ten Lords-a-Leaping",
                "eleven Pipers Piping",
                "twelve Drummers Drumming"
        );

        List<String> daysList = List.of("","first","second","third","fourth","fifth","sixth","seventh","eighth","ninth","tenth","eleventh","twelfth");
        String verse = String.format(baseVerse, daysList.get(dayNumber));

        for (int i = verseNumber; i > 0; i--) {
            verse += verseList.get(i);
            if ( i == 2) {
                verse +=", and ";
            } else if (i > 2) {
                verse +=", ";
            }
        }

        return verse+"\n";
    }

    String verses(int startVerse, int endVerse) {
        String verses = "";
        for (int i = startVerse; i <= endVerse; i++) {
            verses += verse(i);
            if (i != endVerse){
                verses += "\n";
            }
        }
        return verses;
    }
    
    String sing() {
        return verses(1,12);
    }

}