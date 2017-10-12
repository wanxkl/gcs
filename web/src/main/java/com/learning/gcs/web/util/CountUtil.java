package com.learning.gcs.web.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CountUtil {
    public static void fillZero(List list,Object[] object ,int i,int j){
        if (i>j){
            return;
        }
        if (i==(Integer.parseInt(object[0].toString()))){
            list.add(Integer.parseInt(object[1].toString()));
        }else{
            list.add(0);
            i++;
            fillZero(list,object,i,j);
        }
    }
}
