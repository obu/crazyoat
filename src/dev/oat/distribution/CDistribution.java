/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.oat.distribution;

/**
 *
 * @author obu
 */
public abstract class CDistribution implements IDistribution {
    
    private long MinValue;
    private long MaxValue;
    private long sampleSize;
    private double sum;
    
    public void setMinValue(long MinValue) {
        this.MinValue = MinValue;
    }

    public void setMaxValue(long MaxValue) {
        this.MaxValue = MaxValue;
    }


    public long getMinValue() {
        return MinValue;
    }

    public long getMaxValue() {
        return MaxValue;
    }
    

    @Override
    public void setSampleSize(long sampleSize) {
        this.sampleSize = sampleSize;
    }

    @Override
    public long getSampleSize() {
        return sampleSize;
    }

    @Override
    public void setSum(double sum) {
        this.sum = sum;
    }

    @Override
    public double getSum() {
        return sum;
    }
    
    
    
}
