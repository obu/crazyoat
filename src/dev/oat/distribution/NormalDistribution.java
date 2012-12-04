/*
 * 
 * 
 */
package dev.oat.distribution;
import java.util.Random;
import java.util.Date;

/**
 *
 * @author obu
 */
public class NormalDistribution extends CDistribution {

    static final int MAX_SEQUENCE = 1000;
    
    private double average;
    private double stdav;
    
    Random rand = new Random();
    private long seed;
    private static int index=0;

    private double[] sequence = new double[MAX_SEQUENCE];

    public NormalDistribution() {
        seed = (new Date()).getTime();
        rand.setSeed(seed);
        getSequence();
    }
    public NormalDistribution(long seed) {
        this.seed = seed;
        rand.setSeed(seed);
        getSequence();
    }   
    
    private void getSequence() {
        for (int i = 0; i< MAX_SEQUENCE; i++) {
            sequence[i] = rand.nextGaussian();
        }
    }
    
    
    public double getAverage() {
        return average;
    }

    public double getStdav() {
        return stdav;
    }

     public void setAverage(double average) {
        this.average = average;
    }

    public void setStdav(double stdav) {
        this.stdav = stdav;
    }

    @Override
    public double getValue(long id) {
        index = (int) (id % MAX_SEQUENCE);
        return sequence[index] + 1000;
    }


    
}
