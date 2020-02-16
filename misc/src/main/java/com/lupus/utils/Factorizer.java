package com.lupus.utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Factorizer {
    
    /**
     * Private constructor.
     */
    private Factorizer() {};
    
    /**
     * 
     * @param number
     * @return
     */
    public static Map<Long, Long> factorize(long number) {
        Map<Long, Long> rc = new LinkedHashMap<Long, Long>();
        long remaingFactor = number;
        long currentFactor = 2;
        long currentCount = 0;
        
        long start = System.currentTimeMillis();
        
        while(remaingFactor > 1) {
            while (remaingFactor % currentFactor == 0 && remaingFactor > 1) {
                remaingFactor /= currentFactor;
                currentCount++;
            }
            
            if (currentCount > 0) {
                rc.put(currentFactor, currentCount);
            }
            
            currentCount = 0;
            currentFactor += 1+currentFactor % 2;
        }
        
        
        System.out.println(String.format("factorize() [%dms]", System.currentTimeMillis() - start));
        System.out.flush();
        
        return rc;
    }
}
