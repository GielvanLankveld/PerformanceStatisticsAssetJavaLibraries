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

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Giel van Lankveld
 * Open University of the Netherlands
 */
public class DistributionToJSONSerializationServiceTest {
    
    
    public DistributionToJSONSerializationServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialize method, of class DistributionToJSONSerializationService.
     */
    @Test
    public void testSerialize() {
        System.out.println("* DistributionToJSONSerializationService: serialize()");
        Distribution distribution = new Distribution();
        String expResult = "{\"mean\":0.0"
                            + ",\"min\":0.0"
                            + ",\"max\":0.0"
                            + ",\"sum\":0.0"
                            + ",\"skewness\":0.0"
                            + ",\"kurtosis\":0.0"
                            + ",\"variance\":0.0"
                            + ",\"standardDeviation\":0.0"
                            + ",\"n\":0"
                            + ",\"helper1\":0.0"
                            + ",\"helper2\":0.0"
                            + ",\"helper3\":0.0"
                            + ",\"normal\":false}";
        String result = "";
        try {
            result = DistributionToJSONSerializationService.serialize(distribution);
        }
        catch (PerformanceStatisticsException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of deserialize method, of class DistributionToJSONSerializationService.
     */
    @Test
    public void testDeserialize() {
        System.out.println("* DistributionToJSONSerializationService: deserialize()");
        String JSONObject = "{\"mean\":0.0"
                            + ",\"min\":0.0"
                            + ",\"max\":0.0"
                            + ",\"sum\":0.0"
                            + ",\"skewness\":0.0"
                            + ",\"kurtosis\":0.0"
                            + ",\"variance\":0.0"
                            + ",\"standardDeviation\":0.0"
                            + ",\"n\":0"
                            + ",\"helper1\":0.0"
                            + ",\"helper2\":0.0"
                            + ",\"helper3\":0.0"
                            + ",\"normal\":false}";
        Distribution result = new Distribution();
        try {
            result = DistributionToJSONSerializationService.deserialize(JSONObject);
        }
        catch (PerformanceStatisticsException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(0D,result.mean,0.00001);
        assertEquals(0D,result.min,0.00001);
        assertEquals(0D,result.max,0.00001);
        assertEquals(0D,result.sum,0.00001);
        assertEquals(0D,result.skewness,0.00001);
        assertEquals(0D,result.kurtosis,0.00001);
        assertEquals(0D,result.variance,0.00001);
        assertEquals(0D,result.standardDeviation,0.00001);
        assertEquals(0L,result.n);
        assertEquals(0D,result.helper1,0.00001);
        assertEquals(0D,result.helper2,0.00001);
        assertEquals(0D,result.helper3,0.00001);
        assertEquals(false,result.normal);
    }
    
}
