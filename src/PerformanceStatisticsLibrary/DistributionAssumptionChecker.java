/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PerformanceStatisticsLibrary;

import java.util.Objects;

/**
 *
 * @author Giel van Lankveld
 * Open University of the Netherlands
 */
 class DistributionAssumptionChecker {
    protected static boolean processNormalityAssumption(final Distribution distribution) {
        // This function evaluates the class fields to determine if the distribution is normal.
        // The basic result is that a distribution is normal but the assessment of
        // skewness and kurtosis my change this result.
        // Checks for normality are based on Chapter 5 of: Field (2009) Discovering statistics
        // using SPSS. Pp 136-139. ISBN: 978-1-84787-906-6, ISBN: 978-1-84787-907-3.
        // A strict interpretation of these checks is used (tresholds of 1.96 and 2.58).
        // Definitions:
        // A small sample is a sample with n < 30.
        // A large sample is a sample with n >= 30.
        
        final int SMALL_SAMPLE_MAX = 29;
        final Double SMALL_SAMPLE_THRESHOLD = 1.96;
        final Double LARGE_SAMPLE_THRESHOLD = 2.58;
        
        Boolean normal = true;
        
        Double skew = distribution.skewness;
        Double kurt = distribution.kurtosis;
        Double mean = distribution.mean;
        Double stdDev = distribution.standardDeviation;
        Long n = distribution.n;
        
        // This check can only be performed on distributions with a standard deviation that is not zero
        if (stdDev != 0) {
            // Calculate the z-scores of skewness and kurtosis
            Double zSkew = (skew - mean) / stdDev;
            Double zKurt = (kurt - mean) / stdDev;

            // Assumption checks are based on the size of n (see explanation above)
            if (n < SMALL_SAMPLE_MAX) {
                if ((zSkew >= SMALL_SAMPLE_THRESHOLD)&&(zSkew <= -SMALL_SAMPLE_THRESHOLD))
                    normal = false;
            } else {
                if ((zSkew >= LARGE_SAMPLE_THRESHOLD)&&(zSkew <= -LARGE_SAMPLE_THRESHOLD))
                    normal = false;
            }
        } else {
            // On a distribution with too few samples the assumptions cannot be checked.
            // On these small distributions the normality is set to false.
            
            normal = false;
        }
        
        return normal;
    }
}
