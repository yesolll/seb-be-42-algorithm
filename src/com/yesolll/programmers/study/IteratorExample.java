package com.yesolll.programmers.study;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {
    
    public static void main(String[] args) {
        
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("안녕");
        arrayList.add("또리머예요");
        arrayList.add("다들 코로나 걸리지 마세요");
        
    
        Iterator<String> iterator = arrayList.iterator();
        
        while(iterator.hasNext()){              // 읽어올객체가 남아있다면
            String str = iterator.next();       // 객체를 읽어오기
            System.out.println(str);
        }

    }
}
