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

import java.lang.reflect.Field;
import java.util.*;

/**
 *
 * @author Giel van Lankveld
 * Open University of the Netherlands
 */
public class DistributionToJSONSerializationService {
    public static String serialize (Distribution distribution) throws PerformanceStatisticsException {
        //This method provides a simple JSON serializer
        //This serializer does not support JSON array structures (to be added in the future)
        
        //Prepare variables
        String JSONObject = "";
        
        //Serialize distribution object to JSON
        JSONObject += "{";
        JSONObject += "\"mean\":" + Double.toString(distribution.mean) ;
        JSONObject += ",\"min\":" + Double.toString(distribution.min);
        JSONObject += ",\"max\":" + Double.toString(distribution.max);
        JSONObject += ",\"sum\":" + Double.toString(distribution.sum);
        JSONObject += ",\"skewness\":" + Double.toString(distribution.skewness);
        JSONObject += ",\"kurtosis\":" + Double.toString(distribution.kurtosis);
        JSONObject += ",\"variance\":" + Double.toString(distribution.variance);
        JSONObject += ",\"standardDeviation\":" + Double.toString(distribution.standardDeviation);
        JSONObject += ",\"n\":" + Long.toString(distribution.n);
        JSONObject += ",\"helper1\":" + Double.toString(distribution.helper1);
        JSONObject += ",\"helper2\":" + Double.toString(distribution.helper2);
        JSONObject += ",\"helper3\":" + Double.toString(distribution.helper3);
        JSONObject += ",\"normal\":" + Boolean.toString(distribution.normal);
        JSONObject += "}";
        
        return JSONObject;
    }
    
    public static Distribution deserialize (String JSONObject) throws PerformanceStatisticsException {
        //This method provides a simple JSON deserializer
        //This deserializer does not support JSON array structures (to be added in the future)
        
        //Prepare variables
        Distribution distribution = new Distribution();        
        List<String> fields = new ArrayList<>();
        List<String> values = new ArrayList<>();
        String[] temp;
        
        //Remove accolades
        JSONObject = JSONObject.replace("{", "");
        JSONObject = JSONObject.replace("}", "");
        
        //Split into variables
        temp = JSONObject.split(",");
        
        //Split the variables into fields and values
        for (String str: temp){
            String[] temp2;
            temp2 = str.split(":");
            fields.add(temp2[0]);
            values.add(temp2[1]);
        }
        
        //Convert into distribution
        distribution.mean = Double.parseDouble(values.get(0));
        distribution.min = Double.parseDouble(values.get(1));
        distribution.max = Double.parseDouble(values.get(2));
        distribution.sum = Double.parseDouble(values.get(3));
        distribution.skewness = Double.parseDouble(values.get(4));
        distribution.kurtosis = Double.parseDouble(values.get(5));
        distribution.variance = Double.parseDouble(values.get(6));
        distribution.standardDeviation = Double.parseDouble(values.get(7));
        distribution.n = Long.parseLong(values.get(8));
        distribution.helper1 = Double.parseDouble(values.get(9));
        distribution.helper2 = Double.parseDouble(values.get(10));
        distribution.helper3 = Double.parseDouble(values.get(11));
        distribution.normal = Boolean.parseBoolean(values.get(12));
        
        return distribution;
    }
}
