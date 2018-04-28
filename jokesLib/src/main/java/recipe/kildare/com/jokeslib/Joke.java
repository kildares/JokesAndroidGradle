package recipe.kildare.com.jokeslib;

import java.util.Random;

public class Joke {

    public static String getJoke()
    {

        String[] jokes = {
                "What is red an smells like blue paint? RED PAINT!",
                "Why aren' koalas actual bears? They don't meet the koalafications!",
                "What do you call bears with no ears? B!"};

        return jokes[new Random().nextInt(3)];
    }

}
