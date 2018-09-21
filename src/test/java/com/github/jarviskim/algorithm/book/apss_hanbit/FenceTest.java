package com.github.jarviskim.algorithm.book.apss_hanbit;

import com.github.jarviskim.algorithm.book.apss_hanbit.fence.Fence;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class FenceTest {

    @Test
    public void test() {
        Fence fence = new Fence();
        double[] xi = new double[] { 3, 6, 8, 12, 17, 20, 26, 28, 32 };
        double[] hi = new double[] { 10, 5, 13, 6, 4, 10, 17, 14, 4 };
        List<Integer> course = fence.solve(xi, hi);
        assertArrayEquals(new int[] { 1, 3, 7, 8, 9 }, course.stream().mapToInt(i -> i).toArray());
        print(course);

        double[] xi2 = new double[] { 0.1, 0.15, 0.89, 1.23, 1.87, 2.95, 3.23, 3.85, 4.13, 4.26, 4.95, 5.08, 5.47, 5.6, 6.26, 6.86, 7.23, 7.68, 8.85, 9.53 };
        double[] hi2 = new double[] { 26.64, 4.36, 16.92, 42.16, 12.15, 92.13, 64.16, 97.17, 81.66, 1.44, 19.35, 40.35, 30.71, 27.2, 34.08, 99.14, 84.81, 39.8, 9.86, 8.74 };
        List<Integer> course2 = fence.solve(xi2, hi2);
        assertArrayEquals(new int[] { 1, 6, 8, 16, 20 }, course2.stream().mapToInt(i -> i).toArray());
        print(course2);
    }

    private void print(List<Integer> result) {
        result.forEach(integer -> System.out.printf("%3d", integer));
        System.out.println();
    }
}

