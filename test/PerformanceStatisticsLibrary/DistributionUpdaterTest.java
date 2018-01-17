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

import PerformanceStatisticsLibrary.Distribution;
import PerformanceStatisticsLibrary.DistributionUpdater;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Giel van Lankveld
 * Open University of the Netherlands
 */
public class DistributionUpdaterTest {
    
    public DistributionUpdaterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of updateDistribution method, of class DistributionUpdater.
     */
    @Test
    public void testUpdateDistribution() throws Exception {
        System.out.println("updateDistribution");
        Distribution distribution = null;
        double newScore = 0.0;
        DistributionUpdater instance = new DistributionUpdater();
        Distribution expResult = null;
        Distribution result = instance.updateDistribution(distribution, newScore);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
