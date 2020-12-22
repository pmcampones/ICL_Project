package tests;

import parser.Parser;

import java.io.ByteArrayInputStream;
import java.util.Random;

/**
* MIEI
* @author Ana Josefa Matos - 49938
* @author Pedro Camponês - 50051
**/

public class TestUtils {

    public static final int DEFAULT_LEN = 20;

    public static final int MAX_RAND = 100;

    public static void writeToToken(String exp) {
        exp += "\n";
        byte[] expBytes = exp.getBytes();
        Parser.ReInit(new ByteArrayInputStream(expBytes));
    }
    
    public static String genSameOpStr(int[] nums, String operator) {
        StringBuilder expWriter = new StringBuilder("");
        for (int i = 0; i < nums.length - 1; i++)
            expWriter.append(nums[i]).append(operator);
        expWriter.append(nums[nums.length - 1]);
        return expWriter.toString();
    }
    
    public static int[] getNumsArray() {
        int[] nums = new int[DEFAULT_LEN];
        Random r = new Random();
        for (int i = 0; i < DEFAULT_LEN; i++)
            nums[i] = r.nextInt(MAX_RAND) + 1;
        return nums;
    }
}
