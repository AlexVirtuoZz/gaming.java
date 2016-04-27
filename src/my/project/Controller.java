package my.project;


import java.util.Scanner;

/**
 * Created by User on 17.03.2016.
 */
public class Controller {

    Scanner sc = new Scanner(System.in);

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
     * After user's finally won, we greet him and show statistics
     * @see my.project.Model#step
     */
    public void game() {
        model.setValue(model.rand());
        view.printMessage(view.WELCOME);
        view.printMessage(view.ranging(model.getLeft_border(),model.getRight_border()));

        int scValue = inputIntValueWithScanner(sc);
        while (!model.step(scValue)){
            directUser(scValue);
            view.printMessage(view.ranging(model.getLeft_border(),model.getRight_border()));
            view.statistics.append(view.stepStatistics(model.getCounter(), model.getValue(), scValue));
            scValue = inputIntValueWithScanner(sc);
        }

        view.printMessage(view.CONGRATS);
        view.printMessage(view.statistics.toString());
        view.printMessage(view.statistics(model.getCounter()));
    }

    // The Utility methods

    /**A method to input number with scanner.
     *  If input is wrong, we point it out and repeat an attempt
     *  If input muber is out of bounds, we point it out and repeat an attempt
     */
    public int inputIntValueWithScanner(Scanner sc) {
        while (!sc.hasNextInt() || sc.nextInt() >= model.getRight_border() || sc.nextInt() <= model.getLeft_border()){
            if (!sc.hasNextInt()) view.printMessage(view.WRONG_INPUT);
            else {
                view.printMessage(view.OUT_OF_BOUNDS);
                view.printMessage(view.ranging(model.getLeft_border(), model.getRight_border()));}
            sc.next();}
        return sc.nextInt();
    }

    //A method to direct user between an input and a random value
    public void directUser(int scValue) {
        if (model.isBigger(model.getValue(), scValue ))  view.printMessage(view.NUMBER_BIGGER);
        else  view.printMessage(view.NUMBER_SMALLER);
    }

}
