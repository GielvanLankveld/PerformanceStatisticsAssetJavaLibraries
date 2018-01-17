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
import PerformanceStatisticsLibrary.DistributionRiskAssessor;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Giel van Lankveld
 * Open University of the Netherlands
 */
public class DistributionRiskAssessorTest {
    
    public DistributionRiskAssessorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of StudentToGroupAssessment method, of class DistributionRiskAssessor.
     */
    @Test
    public void testStudentToGroupAssessment() throws Exception {
        System.out.println("StudentToGroupAssessment");
        double score = 0.0;
        Distribution distribution = null;
        boolean expResult = false;
        boolean result = DistributionRiskAssessor.StudentToGroupAssessment(score, distribution);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GroupComparison method, of class DistributionRiskAssessor.
     */
    @Test
    public void testGroupComparison() throws Exception {
        System.out.println("GroupComparison");
        Distribution group1 = null;
        Distribution group2 = null;
        int expResult = 0;
        int result = DistributionRiskAssessor.GroupComparison(group1, group2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
