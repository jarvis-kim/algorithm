package com.github.jarviskim.algorithm.book.apss_hanbit.greed;

/**
 * (욕심장이 기법)
 * 1Chapter 1 Section의 알고리즘.
 * 내가 푼 방식과 달라 책에서 설명된 브레인스토밍 설명을 토대로 코드로 옮김.
 */
public class MinimumTimeOfBook {

    private static int MAX_VALUE = Integer.MAX_VALUE;

    private int memorySize;

    private int osSize;

    private int availableMemory;

    private int[] timeOfMemories;

    private App[] apps;

    public MinimumTimeOfBook(int osSize, int memorySize) {
        this.memorySize = memorySize;
        this.osSize = osSize;
        this.availableMemory = memorySize - osSize;
        this.timeOfMemories = new int[ this.availableMemory + 1 ];
    }

    public void apps(int... args) {
        if ( args.length % 2 != 0 ) {
            throw new IllegalArgumentException("짝수여야합니다.");
        }
        apps = new MinimumTimeOfBook.App[ args.length / 2 ];
        int appIndex = 0;
        for ( int index = 0; index < args.length; index += 2 ) {
            apps[ appIndex++ ] = new MinimumTimeOfBook.App(args[ index ], args[ index + 1 ]);
        }
    }

    public int minimumTime() {
        this.timeOfMemories[ 0 ] = 0;
        for ( int index = 1; index < this.timeOfMemories.length; index++ ) {
            this.timeOfMemories[ index ] = MAX_VALUE;
        }

        for ( App app : apps ) {
            for ( int memory = 1; memory < timeOfMemories.length; memory++ ) {
                if ( memory - app.memory >= 0
                        && timeOfMemories[ memory - app.memory ] != MAX_VALUE
                        && timeOfMemories[ memory ] > timeOfMemories[ memory - app.memory ] + app.time ) {

                    timeOfMemories[ memory ] = timeOfMemories[ memory - app.memory ] + app.time;
                }
            }
        }

        return timeOfMemories[ timeOfMemories.length - 1 ];
    }

    public static class App {
        int time;
        int memory;

        public App(int time, int memory) {
            this.time = time;
            this.memory = memory;
        }
    }

}
