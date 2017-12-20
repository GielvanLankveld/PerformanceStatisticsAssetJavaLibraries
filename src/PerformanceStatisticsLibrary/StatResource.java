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

/**
 *
 * @author Giel van Lankveld
 * Open University of the Netherlands
 */
public class StatResource {
    
    //This resource contains the critical t values for two-tailed paired-samples t-tests at a significance level of alpha=0.05
    private static Double[] CriticalTTablePairedTTest;
    
    private StatResource() {
        CriticalTTablePairedTTest = new Double[] {
            0.00,
            12.71,
            4.30,
            3.18,
            2.78,
            2.57,
            2.45,
            2.36,
            2.31,
            2.26,
            2.23,
            2.20,
            2.18,
            2.16,
            2.14,
            2.13,
            2.12,
            2.11,
            2.10,
            2.09,
            2.09,
            2.08,
            2.07,
            2.07,
            2.06,
            2.06,
            2.06,
            2.05,
            2.05,
            2.05,
            2.04,
            2.03,
            2.03,
            2.03,
            2.03,
            2.03,
            2.02,
            2.02,
            2.02,
            2.02,
            2.02,
            2.01,
            2.01,
            2.01,
            2.01,
            2.01,
            2.01,
            2.01,
            2.01,
            2.01,
            2.01,
            2.00,
            2.00,
            2.00,
            2.00,
            2.00,
            2.00,
            2.00,
            2.00,
            2.00,
            2.00,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.99,
            1.98,
            1.98,
            1.98,
            1.98,
            1.98,
            1.98,
            1.98,
            1.98,
            1.98,
            1.98,
            1.96};
    }
    
    public static Double getCriticalTTablePairedTTestValue(int DF) {
        if (DF == 0) {
            //There is no value for 0 degrees of freedom
            return null;
        } else if (DF > 101) {
            //The critical t value remains constant between 101 and infinity so return 101
            return CriticalTTablePairedTTest[101];
        } else {
            //Return the listed value
            return CriticalTTablePairedTTest[DF];
        }
    }
}
