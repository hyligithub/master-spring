package com.masterspring.common.demo.dmyh;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapTest {  
    public static void main(String[] args) {  
  
        HashMap<String, String> keySetMap = new HashMap<String, String>();  
        HashMap<String, String> entrySetMap = new HashMap<String, String>();  
  
        Map map = new HashMap();
        map.put("1", null);
        Long tmp1 = (Long)map.get("1");
        tmp1 = tmp1/10;
        if(tmp1 == null){
        	System.out.print("---");
        }
        
        
        for (int i = 0; i < 1000000; i++) {  
            keySetMap.put("" + i, "keySet");  
        }  
        for (int i = 0; i < 1000000; i++) {  
            entrySetMap.put("" + i, "entrySet");  
        }  
  
        long startTimeOne = System.currentTimeMillis();  
        Iterator<String> keySetIterator = keySetMap.keySet().iterator();  
        for(String s:keySetMap.keySet()){
        	String tmp = s;
        }
        
//        while (keySetIterator.hasNext()) {  
//            String key = keySetIterator.next();  
////            String value = keySetMap.get(key);  
////            System.out.println(value);  
//        }  
  
        System.out.println("keyset spent times:"  
                + (System.currentTimeMillis() - startTimeOne));  
  
        long startTimeTwo = System.currentTimeMillis();  
  
        Iterator<Entry<String, String>> entryKeyIterator = entrySetMap  
                .entrySet().iterator();  
        for(Entry<String, String> e:entrySetMap.entrySet()){
        	e.getKey();
        }
        
//        while (entryKeyIterator.hasNext()) {  
//            Entry<String, String> e = entryKeyIterator.next();  
////            e.getValue();
////            System.out.println(e.getValue());  
//        }  
        System.out.println("entrySet spent times:"  
                + (System.currentTimeMillis() - startTimeTwo));  
  
    }  
}  