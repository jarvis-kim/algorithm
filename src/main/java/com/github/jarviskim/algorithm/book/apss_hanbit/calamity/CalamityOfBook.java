package com.github.jarviskim.algorithm.book.apss_hanbit.calamity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 책의 브레인 스토밍을 보고 코드 작성.
 */
public class CalamityOfBook {

    private static int FIRE = Integer.MAX_VALUE;

    private static int EXIT = -1;

    private static int SAFE = 0;

    private static int ACTOR = 1;

    private int[][] initMap;

    private Position exit;

    private int x;

    private int m;

    private int n;

    public CalamityOfBook(int x, String[] data) {
        this.x = x;

        initMap = new int[ data.length ][];
        for ( int i = 0; i < data.length; i++ ) {
            String row = data[ i ].toUpperCase();
            char[] rowChar = row.toCharArray();
            initMap[ i ] = new int[ rowChar.length ];
            for ( int j = 0; j < rowChar.length; j++ ) {
                int value = 0;
                if ( rowChar[ j ] == 'F' ) {
                    value = FIRE;
                } else if ( rowChar[ j ] == 'Y' ) {
                    value = ACTOR;
                } else if ( rowChar[ j ] == 'E' ) {
                    value = EXIT;
                    exit = new Position(j, i);
                }

                initMap[ i ][ j ] = value;
            }
        }

        this.m = initMap.length;
        this.n = initMap[ 0 ].length;
    }

    public MoveHistory findLoad() {
        Solver solver = new Solver();
        int count = solver.solve();

        MoveHistory moveHistory = new MoveHistory();
        moveHistory.setCount(count);
        moveHistory.setDirection(solver.getDirection());
        moveHistory.setEscaped(solver.escaped);

        return moveHistory;
    }

    class Solver {
        private Queue<List<Position>> queue;

        private int[][] map;

        private char[][] direction;

        private boolean escaped = false;

        public String getDirection() {
            StringBuilder builder = new StringBuilder();

            int y = exit.y;
            int x = exit.x;

            char dir;
            boolean doNext = true;
            do {
                dir = direction[ y ][ x ];
                switch ( dir ) {
                    case 'D':
                        builder.append('U');
                        y++;
                        break;
                    case 'U':
                        builder.append('D');
                        y--;
                        break;
                    case 'R':
                        builder.append('L');
                        x++;
                        break;
                    case 'L':
                        builder.append('R');
                        x--;
                        break;
                    default:
                        doNext = false;
                        break;
                }

                if ( !(0 <= y && y < m) || !(0 <= x && x < n) ) {
                    doNext = false;
                }

            } while ( doNext );

            return builder.reverse().toString();
        }

        public int solve() {
            direction = new char[ m ][ n ];
            queue = new LinkedList<>();
            List<Position> initPosition = new ArrayList<>(1);
            initPosition.add(getInitPosition());
            queue.add(initPosition);



            map = newCopiedMap();
            int xx = 0;
            List<Position> positions = null;
            while ( (positions = queue.poll()) != null ) {
                move(positions);
                if ( map[ exit.y ][ exit.x ] > -1 && map[ exit.y ][ exit.x ] < FIRE ) {
                    escaped = true;
                    break;
                }

                xx = ++xx % (x + 1);
                if ( xx == x ) {
                    fire();
                }
                print();
            }

            return map[ exit.y ][ exit.x ] - 1;
        }

        void move(List<Position> positions) {
            List<Position> nextPositions = new ArrayList<>(4);

            for ( Position position : positions ) {
                int y = position.y;
                int x = position.x;
                if ( map[ y ][ x ] == FIRE ) {
                    continue;
                }

                if ( y + 1 < n && (map[ y + 1 ][ x ] == SAFE || map[ y + 1 ][ x ] == EXIT) ) {
                    map[ y + 1 ][ x ] = map[ y ][ x ] + 1;
                    nextPositions.add(new Position(x, y + 1));
                    direction[ y + 1 ][ x ] = 'U';
                }
                if ( y - 1 >= 0 && (map[ y - 1 ][ x ] == SAFE || map[ y - 1 ][ x ] == EXIT) ) {
                    map[ y - 1 ][ x ] = map[ y ][ x ] + 1;
                    nextPositions.add(new Position(x, y - 1));
                    direction[ y - 1 ][ x ] = 'D';
                }
                if ( x + 1 < m && (map[ y ][ x + 1 ] == SAFE || map[ y ][ x + 1 ] == EXIT) ) {
                    map[ y ][ x + 1 ] = map[ y ][ x ] + 1;
                    nextPositions.add(new Position(x + 1, y));
                    direction[ y ][ x + 1 ] = 'L';
                }
                if ( x - 1 >= 0 && (map[ y ][ x - 1 ] == SAFE || map[ y ][ x - 1 ] == EXIT) ) {
                    map[ y ][ x - 1 ] = map[ y ][ x ] + 1;
                    nextPositions.add(new Position(x - 1, y));
                    direction[ y ][ x - 1 ] = 'R';
                }
            }

            queue.add(nextPositions);
        }

        void fire() {
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
                if ( y + 1 < m ) {
                    map[ y + 1 ][ x ] = FIRE;
                }
                if ( y - 1 >= 0 ) {
                    map[ y - 1 ][ x ] = FIRE;
                }
                if ( x + 1 < n ) {
                    map[ y ][ x + 1 ] = FIRE;
                }
                if ( x - 1 >= 0 ) {
                    map[ y ][ x - 1 ] = FIRE;
                }
            }
        }

        void print() {
            for ( int y = 0; y < m; y++ ) {
                for ( int x = 0; x < n; x++ ) {
                    if ( map[ y ][ x ] == FIRE ) {
                        System.out.print("F ");
                    } else if ( map[ y ][ x ] > 0 ) {
                        System.out.print(map[ y ][ x] + " ");
                    } else if ( map[ y ][ x ] == -1 ) {
                        System.out.print("E ");
                    } else {
                        System.out.print("O ");
                    }
                }
                System.out.println();
            }

            System.out.println("====================================\n");
        }
    }

    public static class MoveHistory {
        private boolean escaped = false;

        private int count = 0;
        private String direction = "";

        void setCount(int count) {
            this.count = count;
        }

        void setDirection(String direction) {
            this.direction = direction;
        }

        public int getCount() {
            return count;
        }

        public String getDirection() {
            return direction;
        }


        void setEscaped(boolean escaped) {
            this.escaped = escaped;
        }

        public boolean escaped() {
            return escaped;
        }

    }

    private int[][] newCopiedMap() {
        int[][] copiedMap = new int[ initMap.length ][];
        for ( int index = 0; index < initMap.length; index++ ) {
            copiedMap[ index ] = initMap[ index ].clone();
        }
        return copiedMap;
    }

    private Position getInitPosition() {
        for ( int y = 0; y < initMap.length; y++ ) {
            for ( int x = 0; x < initMap.length; x++ ) {
                if ( initMap[ y ][ x ] == 1 ) {
                    return new Position(x, y);
                }
            }
        }

        return null;
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
