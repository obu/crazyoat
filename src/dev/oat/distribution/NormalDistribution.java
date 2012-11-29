/*
 * 
 * 
 */
package dev.oat.distribution;
import java.util.Random;

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

    private double[] sequence = new double[MAX_SEQUENCE];

    public NormalDistribution(long seed) {
        this.seed = seed;
        rand.setSeed(seed);
        getSequence();
    }   
    
    private void getSequence() {
        for (int i = 0; i< MAX_SEQUENCE; i++) 
            sequence[i] = rand.nextGaussian();
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
        throw new UnsupportedOperationException("Not supported yet.");
    }


    
}
