package my.project;

import java.util.Random;

/**
 * Created by User on 17.03.2016.
 */
public class Model {
    //program's random number
    private int value;

    private Random rand = new Random();
    private final int RAND_MAX = 100;

    //counter for user's attempts
    private int counter = 0;

    //variables to direct user
    private int left_border ;
    private int right_border ;

    // The Program logic

    int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    int getLeft_border() {
        return left_border;
    }

    public void setLeft_border(int left_border) {
        this.left_border = left_border;
    }

    int getRight_border() {
        return right_border;
    }

    public void setRight_border(int right_border) {
        this.right_border = right_border;
    }

    int getCounter(){
        return counter;
    }

    //Increase counter value
    void increaseCounter(){
        counter++;
    }

    //Constructor
    public Model(){
        setLeft_border(0);
        setRight_border(RAND_MAX);
    }

    /**
     * this method generate random integer
     * from min to max, including maximum
     * @param min minimum random number
     * @param max maximum random number
     * @return random int [min;max]
     */

     public int rand(int min, int max) {
        return min+rand.nextInt((max-min)+1);
    }

    /**
     * in this method generate random integer from 0 to RAND_MAX
     * @return random int (0;RAND_MAX)
     */
     public int rand() {
        return rand.nextInt(RAND_MAX-1)+1;
    }

    /**
     * This method return true if user's guessed a value
     * @param value is a random number
     * @param attempt is user's attempt to guess
     * @return equality of values
     */
    public boolean equals(int value, int attempt){
        return value == attempt;
    }

    /**
     * Checks if user's value is bigger or smaller then a random one
     * @param value is a random number
     * @param attempt is user's attempt to guess
     * @return difference between values
     */
    public boolean isBigger(int value, int attempt){
        return value > attempt;
    }

    /**
     * A method describes one player's step
     * if random number is bigger then user's, we set new bound and repeat a step
     * If user's number is equal to a random one, user wins
     * And if it's not, we know that random number is smaller, we set new bound and repeat a step
     * Counter counts, how many steps has user done
     * @return equality of user's and random numbers
     */
    public boolean step(int attempt){
        increaseCounter();

        if (isBigger(value, attempt) && attempt > left_border)
            setLeft_border(attempt);

        else if (equals(value,attempt))
            return true;

        else //value is smaller then user's attempt
            setRight_border(attempt);

        return false;
    }

}
