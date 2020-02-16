package com.lupus.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;
import java.util.Map.Entry;

import com.lupus.utils.Factorizer;

public class PrimApp {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        System.out.print("Enter number: ");
        System.out.flush();
        
        BufferedReader ir = new BufferedReader(new InputStreamReader(in));
        
        String line = null;
        
        while ((line = ir.readLine()).length() > 0) {
            try {
                long num = Long.parseLong(line);
                
                if (num < 2) {
                    System.err.println(String.format("Entered number has to be greater or equals 2, but is %d", num));
                    System.err.flush();
                } else {
                    Map<Long, Long> factorMap = Factorizer.factorize(num);
                    System.out.println(String.format("%d=%s", num, getFactorMapAsString(factorMap)));
                    
                    
                }
            } catch (NumberFormatException e) {
                System.err.println(String.format("%s is not a number.", line));
                System.err.flush();
            }
            System.out.print("Enter number: ");
            System.out.flush();
        }
        
        // TODO Auto-generated method stub
        System.out.println("Good bye.");
        System.exit(0);
        
    }

    private static String getFactorMapAsString(Map<Long, Long> factorMap) {
        StringBuffer buf = new StringBuffer();
        boolean start = true;
        
        for (Entry<Long, Long> entry : factorMap.entrySet()) {
            long factor = entry.getKey();
            long multiplicity = entry.getValue();
            
            for (long i = 0; i < multiplicity; i++) {
                buf.append(String.format("%s%d", !start ? "*" : "", factor));
                start = false;
            }
        }
        return buf.toString();
    }

}
