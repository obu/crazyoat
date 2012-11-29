/*
 * A distribution has the following features:
 * 1. sample size -- number of items in the sample
 * 2. sum         -- sum of all item values
 * 
 * Each item has an id.  Each item has a value.
 * Given id, its value should be returned.
 */
package dev.oat.distribution;

/**
 *
 * @author obu
 */
interface IDistribution {

    void setSampleSize(long sampleSize);
    long getSampleSize();
    
    void setSum(double sum);
    double getSum();
    
    double getValue(long id);
    
}
