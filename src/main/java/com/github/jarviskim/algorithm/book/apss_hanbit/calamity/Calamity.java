package com.github.jarviskim.algorithm.book.apss_hanbit.calamity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Calamity {

    public static char FIRE = 'F';
    public static char ACTOR = 'Y';
    public static char SERENITY = 'O';
    public static char EXIT = 'E';

    private int xx;

    private Position actor;

    private Position exit;

    private char[][] map;

    private int n;

    private int m;

    public Calamity(int xx, String[] data) {
        this.xx = xx;

        map = new char[ data.length ][];
        for ( int index = 0; index < data.length; index++ ) {
            String row = data[ index ].toUpperCase();
            map[ index ] = row.toCharArray();
        }

        this.m = map.length;
        this.n = this.map[ 0 ].length;

        init();
    }

    private void init() {
        for ( int y = 0; y < this.m; y++ ) {
            for ( int x = 0; x < this.n; x++ ) {
                if ( this.map[ y ][ x ] == ACTOR ) {
                    this.actor = new Position(x, y);
                } else if ( this.map[ y ][ x ] == EXIT ) {
                    this.exit = new Position(x, y);
                }
            }
        }
    }

    public MoveHistory findLoad() {
        boolean notExit = true;
        char[][] map = newCopiedMap();

        int xx = 0;
        MoveHistory moveHistory = new MoveHistory();
        Position currentActor = new Position(this.actor.x, this.actor.y);
        while ( notExit ) {
            printMap(map, currentActor);
            move(currentActor, map, moveHistory);
            if ( currentActor.x == exit.x && currentActor.y == exit.y ) {
                moveHistory.escape();
                break;
            }
            if ( map[ exit.y ][ exit.x ] == FIRE || map[ currentActor.y ][ currentActor.x ] == FIRE ) {
                break;
            }
            xx = fire(map, xx);
        }

        return moveHistory;
    }

    private boolean canMove(Position actor, int directionX, int directionY, char[][] map) {
        if ( directionX == 0 && directionY == 0 ) {
            return false;
        }
        int x = actor.x + directionX;
        int y = actor.y + directionY;
        return (0 <= x && x < n)
                && (0 <= y && y < m)
                && (map[ y ][ x ] == SERENITY || map[ y ][ x ] == EXIT);
    }

    private void move(Position currentActor, char[][] map, MoveHistory moveHistory) {
        int directionY = getMoveDirection(currentActor.y, this.exit.y);
        int directionX = getMoveDirection(currentActor.x, this.exit.x);

        if ( canMove(currentActor, 0, directionY, map ) ) {
            moveHistory.addHistory(0, getMoveDirection(currentActor.y, this.exit.y));
            currentActor.y += directionY;
        } else if ( canMove(currentActor, directionX, 0, map) ) {
            moveHistory.addHistory(getMoveDirection(currentActor.x, this.exit.x), 0);
            currentActor.x += directionX;
        }
    }

    private int getMoveDirection(int from, int to) {
        if ( from == to ) {
            return 0;
        }
        int direction = (((from + 1) - (to + 1)) * -1);
        direction = direction / Math.abs(direction);
        return direction;
    }


    private int fire(char[][] map, int xx) {
        xx = ++xx % (this.xx + 1);
        if ( xx == this.xx ) {
            Queue<Position> list = new LinkedList<>();
            for ( int y = 0; y < m; y++ ) {
                for ( int x = 0; x < n; x++ ) {
                    if ( map[ y ][ x ] == FIRE ) {
                        list.add(new Position(x, y));
                    }
                }
            }

            for ( Position position : list ) {
                int y = position.y;
                int x = position.x;
                if ( y + 1 < m ) map[ y + 1 ][ x ] = FIRE;
                if ( y - 1 >= 0 ) map[ y - 1][ x ] = FIRE;
                if ( x + 1 < n ) map[ y ][ x + 1 ] = FIRE;
                if ( x - 1 >= 0 ) map[ y ][ x - 1 ] = FIRE;
            }
        }

        return xx;
    }

    private char[][] newCopiedMap() {
        char[][] copiedMap = new char[ this.map[ 0 ].length ][];
        for ( int index = 0; index < this.map.length; index++ ) {
            copiedMap[ index ] = this.map[ index ].clone();
        }

        copiedMap[ actor.y ][ actor.x ] = SERENITY;

        return copiedMap;
    }

    public static class MoveHistory {
        private boolean escaped = false;

        private List<Character> directions = new ArrayList<>();

        public void escape() {
            this.escaped = true;
        }

        public void addHistory(int directionX, int directionY) {
            if ( directionY == 1 ) {
                directions.add('D');
            } else if ( directionY == -1 ) {
                directions.add('U');
            } else if ( directionX == 1 ) {
                directions.add('R');
            } else if ( directionX == -1 ) {
                directions.add('L');
            }
        }

        public int getCount() {
            return directions.size();
        }

        public String historyToString() {
            StringBuilder builder = new StringBuilder();
            for ( Character direction : directions ) {
                builder.append(direction);
            }
            return builder.toString();
        }

        public List<Character> getDirections() {
            return directions;
        }

        public boolean escaped() {
            return escaped;
        }

    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    void printMap(char[][] map, Position actor) {
        for ( int y = 0; y < m; y++ ) {
            for ( int x = 0; x < n; x++ ) {
                if ( y == actor.y && x == actor.x ) {
                    System.out.print(ACTOR + " ");
                } else {
                    System.out.print(map[ y ][ x] + " ");
                }
            }
            System.out.println();
        }

        System.out.println("========================================");
    }

}
