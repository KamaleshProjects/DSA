package com.dsa.vec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class VecArrTest {

    @Test
    public void testVecArrInsert_Length_Pop_Insert_Delete() {
        VecArr<Integer> vecArr = new VecArr<>();
        for (int i = 0; i < 10; i++) {
            vecArr.append(i);
        }
        int poppedElement = vecArr.pop();
        Assertions.assertEquals(9, poppedElement);
        Assertions.assertEquals(9, vecArr.length());
        vecArr.insert(3, 3);
        for (int i = 0; i < 4; i++) {
            Assertions.assertEquals(i, vecArr.get(i));
        }
        Assertions.assertEquals(3, vecArr.get(4));
        for (int i = 5; i < vecArr.length(); i++) {
            Assertions.assertEquals(i - 1, vecArr.get(i));
        }
        System.out.println(vecArr);
    }

    @Test
    public void testFullGrowthFullShrink() {
        VecArr<Integer> vecArr = new VecArr<>();
        for (int i = 0; i < 100; i++) {
            vecArr.append(i);
        }
        Assertions.assertEquals(100, vecArr.length());
        for (int i = 0; i < 100; i++) {
            vecArr.pop();
        }
        Assertions.assertEquals(0, vecArr.length());
    }

    @Test
    public void performanceTestAppend_10000Elements_CompareArrayList() {
        VecArr<Integer> vecArr = new VecArr<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            vecArr.append(i);
        }
        long end = System.nanoTime();
        System.out.println("vecArr inserting 10000 elements took:: " + (end - start) + " nanoseconds");
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
        }
        end = System.nanoTime();
        System.out.println("arrayList inserting 10000 elements took:: " + (end - start) + " nanoseconds");
    }
}
