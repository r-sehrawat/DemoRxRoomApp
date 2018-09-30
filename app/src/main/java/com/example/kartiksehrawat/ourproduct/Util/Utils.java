package com.example.kartiksehrawat.ourproduct.Util;

import java.util.Arrays;

/**
 * Created by kartiksehrawat on 07/07/18.
 */

public class Utils {


    public static boolean validate(String ...  str){

        for(String sr : Arrays.asList(str)){
            if(sr.isEmpty()){
                return false;
            }
        }
        return true;
    }
}
