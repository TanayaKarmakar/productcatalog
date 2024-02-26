package com.app.hard;

public class ReachingPointsLeetcode780 {
    private static boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while(tx > sx && ty > sy) {
            if(tx > ty)
                tx = tx % ty;
            else
                ty = ty % tx;
        }

        if(sx == tx && ty >= sy)
            return (ty - sy) %tx == 0;
        else if(sy == ty && tx >= sx)
            return (tx - sx) % ty == 0;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(reachingPoints(1,1,3,5));
        System.out.println(reachingPoints(1,1,1,1));
    }
}
