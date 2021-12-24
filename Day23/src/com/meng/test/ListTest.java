package com.meng.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ListTest {

    

    @Test
    public void testListRemove() {

        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//
    }
    private static void updateList(List list) {
//        list.remove(2);
        list.remove(new Integer(2));
    }

}
