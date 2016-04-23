package my.project;


import java.util.Scanner;

/**
 * Created by User on 17.03.2016.
 */
public class Controller {
    int attempt;
    Scanner sc = new Scanner(System.in);

    //StringBuilder to track step / distance statistics
    StringBuilder statistics =  new StringBuilder();;

    // Constructor
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;

    }

    // The Work method

    /**
     * First, we set a random number
     * Then we welcome our user and show him bounds of a random number
     * After user's finally won, we greet him and show, how much steps it took
     */
    public void game() {
        model.setValue(model.rand());
        view.printMessage(view.WELCOME);
        view.printMessage(view.ranging(model.getLeft_border(),model.getRight_border()));
        while (!step()){
            step();
        }
        view.printMessage(view.CONGRATS);
        view.printMessage(statistics.toString());
        view.printMessage(view.statistics(model.getCounter()));
    }

    // The Utility methods
    //A method to input number with scanner. If input is wrong, we point it out and repeat an attempt
    public int inputIntValueWithScanner(Scanner sc) {
        while (!sc.hasNextInt()){
            view.printMessage(view.WRONG_INPUT);
            sc.next();}
        return sc.nextInt();
    }

    /**
     * A method describes one player's step
     * First we check, if number is out of bounds
     * Then, if random number is bigger then user's, we set new bound and repeat a step
     * If user's number is equals to a random one, user wins
     * And if it's not, we know that random number is smaller, we set new bound and repeat a step
     * Counter counts, how many steps has user done
     * @return
     */
    boolean step() {
        model.increaseCounter();

        attempt = inputIntValueWithScanner(sc);

        statistics.append("On "+ model.getCounter()+" step your distance to a random value was "+ Math.abs((model.getValue()-attempt))+"\n");

        if (attempt >= model.getRight_border() || attempt <= model.getLeft_border()){
            view.printMessage(view.OUT_OF_BOUNDS);
            view.printMessage(view.ranging(model.getLeft_border(), model.getRight_border()));
            return false;}

        else if (model.isBigger(model.getValue(), attempt)){
            view.printMessage(view.NUMBER_BIGGER);
            model.setLeft_border(attempt);}

        else if (model.equals(model.getValue(), attempt))
            return true;

        else {model.setRight_border(attempt);
        view.printMessage(view.NUMBER_SMALLER);}
        view.printMessage(view.ranging(model.getLeft_border(), model.getRight_border()));

        return false;
    }
}
