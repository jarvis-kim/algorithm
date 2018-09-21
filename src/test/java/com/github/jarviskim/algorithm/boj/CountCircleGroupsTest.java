package com.github.jarviskim.algorithm.boj;

import com.github.jarviskim.algorithm.boj.a10216_CountCircleGroups.CountCircleGroups;
import org.junit.Assert;
import org.junit.Test;

public class CountCircleGroupsTest {

    @Test
    public void test1() {
        CountCircleGroups.Station[] stations = create(new int[] { 0, 0, 1 }, new int[] { 1, 0, 1 });
        Assert.assertEquals(1, CountCircleGroups.solve(stations));
    }

    @Test
    public void test2() {
        CountCircleGroups.Station[] stations = create(new int[] { 0, 0, 1 }, new int[] { 2, 0, 1 }, new int[] { 10, 0, 5 });
        Assert.assertEquals(2, CountCircleGroups.solve(stations));
    }

    private CountCircleGroups.Station[] create(int[]... input) {
        CountCircleGroups.Station[] stations = new CountCircleGroups.Station[ input.length ];
        for ( int i = 0; i < input.length; i++ ) {
            CountCircleGroups.Station station = new CountCircleGroups.Station(i, input[ i ][ 0 ], input[ i ][ 1 ], input[ i ][ 2 ]);
            stations[ i ] = station;
        }

        return stations;
    }
}
