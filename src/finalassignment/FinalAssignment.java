package finalassignment;

public class FinalAssignment {

    public static int[][] solve(int[][] maze, Point start, Point end) {
        visit(maze, start, end);
        return maze;
    }

    public static boolean visit(int[][] maze, Point pt, Point end) {
        if (isVisitable(maze, pt)) {
            maze[pt.x][pt.y] = 1;
            if (!isEnd(maze, end) && !tryOneOut(maze, pt, end)) {
                maze[pt.x][pt.y] = 0;
            }
        }
        return isEnd(maze, end);
    }

    //確認是否遇到牆壁
    public static boolean isVisitable(int[][] maze, Point pt) {
        return maze[pt.x][pt.y] == 0;
    }

    //確認當前座標是否為1
    public static boolean isEnd(int[][] maze, Point end) {
        return maze[end.x][end.y] == 1;
    }

    //遇到叉路
    public static boolean tryOneOut(int[][] maze, Point pt, Point end) {
        return visit(maze, new Point(pt.x, pt.y + 1), end)
                || visit(maze, new Point(pt.x + 1, pt.y), end)
                || visit(maze, new Point(pt.x, pt.y - 1), end)
                || visit(maze, new Point(pt.x - 1, pt.y), end);
    }

    public static void main(String[] args) {
        int[][] maze = new int[][]{
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 0, 2, 2, 0, 0, 0, 0, 2, 2},
            {2, 2, 2, 0, 2, 2, 0, 2, 2, 0, 2, 2},
            {2, 2, 2, 0, 0, 0, 0, 2, 2, 0, 2, 2},
            {2, 2, 2, 0, 2, 2, 0, 2, 2, 0, 2, 2},
            {2, 2, 2, 0, 2, 2, 0, 2, 2, 0, 2, 2},
            {2, 2, 2, 2, 2, 2, 0, 2, 2, 0, 2, 2},
            {2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}};

        for (int[] i : FinalAssignment.solve(maze, new Point(1, 1), new Point(8, 10))) {
            for (int j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}

class Point {

    final int x;
    final int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
