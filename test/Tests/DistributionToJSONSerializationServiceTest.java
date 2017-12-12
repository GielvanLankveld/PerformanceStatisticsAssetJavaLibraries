/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import PerformanceStatisticsLibrary.Distribution;
import PerformanceStatisticsLibrary.DistributionToJSONSerializationService;
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
        String result = DistributionToJSONSerializationService.serialize(distribution);
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
        Distribution result = DistributionToJSONSerializationService.deserialize(JSONObject);
        
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
