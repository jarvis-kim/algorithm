package com.github.jarviskim.algorithm.book.apss_hanbit.greed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumTime {

    private int memorySize;

    private App[] apps;

    private int osMemory = 10;

    public MinimumTime(int osMemory, int memorySize) {
        this.osMemory = osMemory;
        this.memorySize = memorySize;
    }

    public void apps(int... args) {
        if ( args.length % 2 != 0 ) {
            throw new IllegalArgumentException("짝수여야합니다.");
        }
        apps = new App[ args.length / 2 ];
        int appIndex = 0;
        for ( int index = 0; index < args.length; index += 2 ) {
            apps[ appIndex++ ] = new App(args[ index ], args[ index + 1 ]);
        }
    }

    public Memory run() {
        Arrays.sort(apps);
        int memory = memorySize - osMemory;
        Memory result = new Memory();

        int index;
        while ( memory > 0 ) {
            for ( index = 0; index < apps.length; index++ ) {
                if ( memory >= apps[ index ].memory ) {
                    break;
                }
            }

            if ( index == apps.length ) {
                break;
            }

            memory -= apps[ index ].memory;
            result.time += apps[ index ].runTime;
        }

        if ( memory != 0 ) {
            result.time = -1;
        }

        return result;
    }

    public static class Memory {
        private int time = 0;
        List<App> apps = new ArrayList<>();

        public int getTime() {
            return time;
        }

        public List<App> getApps() {
            return apps;
        }
    }

    class App implements Comparable<App> {
        private int memory;
        private int runTime;

        private double score;

        public App(int runTime, int memory) {
            this.memory = memory;
            this.runTime = runTime;
            this.score = (double)  runTime/ memory;
        }

        public int getMemory() {
            return memory;
        }

        public int getRunTime() {
            return runTime;
        }

        @Override
        public int compareTo(App o) {
            return this.score == o.score ? 0
                    : this.score >= o.score ? 1 : -1;
        }
    }
}
