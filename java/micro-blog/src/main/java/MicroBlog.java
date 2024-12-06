import java.util.stream.Collectors;

class MicroBlog {
    public String truncate(String input) {

        String resultString = input.codePoints().limit(5)
                .mapToObj(c -> Character.toString(c))
                .collect(Collectors.joining());
        System.out.println(resultString);

        return resultString;
    }
}
