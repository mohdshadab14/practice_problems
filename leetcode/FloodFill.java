package leetcode;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class FloodFill {

    private static boolean[][] marker;

    public static void main(String[] args) {
        int[][] arr = {
                {0,0,0},
                {0,0,0}
        };

        floodFill(arr,0,0,0);

    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        marker = new boolean[image.length][image[0].length];
        paint(image,sr,sc,color,image[sr][sc]);
        return image;

    }
    public static int[][] paint(int[][] image,int sr,int sc,int color,int presentColor){
        int maxCols = image[0].length-1;
        int maxRows = image.length-1;
        if(!invalidIndex(sr,sc,maxRows,maxCols) && (marker[sr][sc]==false)) {
            marker[sr][sc] = true;
            if (!invalidIndex(sr - 1, sc, maxRows, maxCols)) {
                if (image[sr - 1][sc] == presentColor) {
                    image[sr-1][sc] = color;
                    paint(image, sr - 1, sc, color,presentColor);
                }
            }
            if (!invalidIndex(sr + 1, sc, maxRows, maxCols)){
                if(image[sr + 1][sc] == presentColor) {
                    image[sr+1][sc] = color;
                    paint(image, sr + 1, sc, color,presentColor);
                }
            }
            if (!invalidIndex(sr, sc - 1, maxRows, maxCols)) {
                if (image[sr][sc - 1] == presentColor) {
                    image[sr][sc-1] = color;
                    paint(image, sr, sc - 1, color,presentColor);
                }
            }
            if (!invalidIndex(sr, sc + 1, maxRows, maxCols)){
                if(image[sr][sc + 1] == presentColor) {
                    image[sr][sc+1] = color;
                    paint(image, sr, sc + 1, color,presentColor);
                }
            }
            image[sr][sc] = color;
        }
        return image;
    }
    private static boolean invalidIndex(int sr, int sc, int maxRows, int maxCols) {
        if(sr<0 ||sr>maxRows || sc<0 || sc>maxCols){
            return true;
        }else {
            return false;
        }
    }
}
