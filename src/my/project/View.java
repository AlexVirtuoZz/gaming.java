package my.project;

/**
 * Created by User on 17.03.2016.
 */
public class View {
    // Text's constants
    final String WELCOME = "Hello, and welcome to gaming Java !\n" +
            "Let's play a game! I will think of a word and you will try to guess it." +
            " Ready? Let's go!";

    final String WRONG_INPUT = "Sorry, my number is integer. Try once again!";

    final String NUMBER_BIGGER = "Oops! Mistake! My number is bigger. Try once again!";

    final String NUMBER_SMALLER = "Oops! Mistake! My number is smaller. Try once again!";

    final String OUT_OF_BOUNDS = "Sorry, your number is out of range.";

    final String CONGRATS = "My congratulations! You've won me!";

    /**
     * A method to let user know his range of numbers
     * @param left_border of range
     * @param right_border of range
     * @return explanation
     */
     String ranging(int left_border, int right_border) {
        return "My number is ranging from "+left_border+" to "+right_border;
    }

    /**
     * A method to show user's step statistic
     * @param counter
     * @return
     */
     String statistics(int counter){
        return "You've won me in "+counter+" steps! Nice result!\nLet's try again and beat your own highscore!";
    }

     void printMessage(String message){
        System.out.println(message);
    }

}