package com.alucar.util;

import android.content.Context;

public class Util {

    public static int getDrawable(Context context, String image){
        return context.getResources().getIdentifier("drawable/" + image, null, context.getPackageName());
    }

    public static int getDrawableHD(Context context, String image){
        return context.getResources().getIdentifier("drawable/" + image + "_hd", null, context.getPackageName());
    }
}
