package com.example.kartiksehrawat.ourproduct.Util;

import android.util.Log;

import com.example.kartiksehrawat.ourproduct.Activity.DeepLinkActivity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by kartiksehrawat on 07/07/18.
 */

public class Utils {


    public Utils(){

    }
    public static final String BASE_URL="http://mediplus.com";

    public static boolean validate(String ...  str){

        for(String sr : Arrays.asList(str)){
            if(sr.isEmpty()){
                return false;
            }
        }
        return true;
    }

    public  void invokeDeeplink(DeepLinkActivity deepLinkActivity, String uri) {
        try {
            Class cls = Class.forName("com.example.kartiksehrawat.ourproduct.Util.Utils");
            int index = uri.lastIndexOf("/");
            Log.i("deeplink",uri.substring(index+1));
            Method method= cls.getDeclaredMethod(uri.substring(index+1),String.class);
            method.invoke(this,uri.substring(index+1));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


     private void test1(String str){
         Log.d("test1","callled");

    }

    private void test2(String str){
        Log.d("test2","callled");

    }


}
