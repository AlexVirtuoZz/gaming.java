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

    //StringBuilder to track step / distance statistics
    StringBuilder statistics =  new StringBuilder();

    /**
     * A method to let user know his range of numbers
     * @param left_border of range
     * @param right_border of range
     * @return range of borders
     */
     String ranging(int left_border, int right_border) {
        return "My number is ranging from "+left_border+" to "+right_border+" , excluding borders";
    }

    /**
     * A method to count which distance to a random value was on each step
     * @param counter is a number of step
     * @param value is a random number
     * @param attempt is user's current input
     * @return  step \ distance statistic
     */
    String stepStatistics(int counter, int value, int attempt){
       return "On "+ counter +" step your distance to a random value was "+ Math.abs((value-attempt))+"\n";
    }

    /**
     * A method to show user's step statistic
     * @param counter counts each step
     * @return step quantity
     */
     String statistics(int counter){
        return "You've won me in "+counter+" steps! Nice result!\nLet's try again and beat your own highscore !";
    }

     void printMessage(String message){
        System.out.println(message);
    }

}
