
public class Main {
    public static void main(String[] arg) {
        int[][] gridData = {
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 1, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 1, 0 },
                { 0, 0, 1, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 2, 1, 0, 0, 0 } }; // 2 is bobs position, 1 is blocked, 0 can be visited

        Map grid = new Map(gridData);
        MapHelper solution = new MapHelper();
        System.out.println(solution.countReachableCells(grid));
    }
}
