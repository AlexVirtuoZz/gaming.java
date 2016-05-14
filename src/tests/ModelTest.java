package tests;

import my.project.Model;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by virtuoz on 14.05.16.
 */
public class ModelTest {
    @Test
    public void testStep(){
       Model m = new Model();
       m.setValue(5);
       assertTrue(m.step(5));
       assertFalse(m.step(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRandom() {
        new Model().rand(1, -1);
    }
}
