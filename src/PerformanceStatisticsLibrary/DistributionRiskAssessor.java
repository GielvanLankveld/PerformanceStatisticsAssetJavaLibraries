/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package PerformanceStatisticsLibrary;

import static java.lang.Math.sqrt;

/**
 *
 * @author Giel van Lankveld
 * Open University of the Netherlands
 */
public class DistributionRiskAssessor {
    public static boolean StudentToGroupAssessment (double score, Distribution distribution) throws PerformanceStatisticsException {
        /*
            This function tests whether the student is at risk based on their distance from the group mean.
            The risk exists when a student is one or more standard deviations below the group mean.
        */
        
        if (score < (distribution.mean - distribution.standardDeviation)){
            //The student is at risk
            return true;
        } else {
            //The student is not at risk
            return false;
        }
    }
    
    public static int GroupComparison (Distribution group1, Distribution group2) throws PerformanceStatisticsException {
        /*
            This function runs a t-test to compare group means and returns an integer to signify which group is largest
            0 = the groups are statistically equal
            1 = group 1 is larger than group 2 (significantly significant)
            2 = group 2 is larger than group 1 (significantly significant)
        */
        
        //Do a t-test between the groups
        double T = (group1.mean - group2.mean) / sqrt((group1.n)+(group2.n));
        
        if (T <= 0.05){
            return 0;
        } else {
            return 1;
        }
    }
}
