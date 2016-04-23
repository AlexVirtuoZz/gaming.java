package my.project;

import java.util.Random;

/**
 * Created by User on 17.03.2016.
 */
public class Model {
    private int value;
    private Random rand = new Random();
    private final int RAND_MAX = 100;

    //counter for user's attempt
    private short counter = 0;

    //variables to direct user
    private int left_border = 0;
    private int right_border = RAND_MAX;

    // The Program logic

     int getValue() {
        return value;
    }

     void setValue(int value) {
        this.value = value;
    }
     int getLeft_border() {
        return left_border;
    }

     void setLeft_border(int left_border) {
        this.left_border = left_border;
    }

     int getRight_border() {
        return right_border;
    }

     void setRight_border(int right_border) {
        this.right_border = right_border;
    }

    int getCounter(){
        return counter;
    }

    //Increase counter value
    void increaseCounter(){
        counter++;
    }
    /**
     * in this method generate random integer
     * from min to max, including maximum
     * @param min minimum random number
     * @param max maximum random number
     * @return random int [min;max]
     */

     int rand(int min, int max) {
        return min+rand.nextInt((max-min)+1);
    }

    /**
     * in this method generate random integer from 0 to RAND_MAX
     * @return random int [0;RAND_MAX]
     */
     int rand() {
        return rand.nextInt(RAND_MAX+1);
    }

    /**
     * This method return true is user's guessed a value
     * @param value is a random number
     * @param attempt is user's attempt to guess
     * @return
     */
    boolean equals(int value, int attempt){
        if (value == attempt)
            return true;
        return false;
    }

    /**
     * Checks if user's value is bigger or smaller then a random one
     * @param value is a random number
     * @param attempt is user's attempt to guess
     * @return
     */
    boolean isBigger(int value, int attempt){
        if (value > attempt)
            return true;
        return false;
    }

}
