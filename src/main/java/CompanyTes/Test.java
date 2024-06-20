import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test {

    class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int numIslands(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        Queue<Pair> queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        int[][] visited = new int[row][col];

        int ans = 0;

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    queue.add(new Pair(i, j));
                    visited[i][j] = 1;

                    while (!queue.isEmpty()) {
                        Pair pair = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int r = dRow[k] + pair.row;
                            int c = dCol[k] + pair.col;

                            if (r >= 0 && r < row && c >= 0 && c < col && visited[r][c] == 0 && grid[r][c] == 1) {
                                visited[r][c] = 1;
                                queue.add(new Pair(r, c));
                            }
                        }
                    }
                    ans++;
                }
            }
        }
        return ans;
    }
    public static List<Integer> processQueries(int[][] queries, int[] memory) {
        List<Integer> results = new ArrayList<>();

        for (int[] query : queries) {
            if (query[0] == 0) {
                int x = query[1];
                int index = findFreeBlock(memory, x);
                results.add(index);
            } else {
                int index = query[1];
                int length = eraseBlock(memory, index);
                results.add(length);
            }
        }

        return results;
    }

    private static int findFreeBlock(int[] memory, int x) {
        for (int i = 0; i <= memory.length - x; i++) {
            boolean free = true;
            for (int j = i; j < i + x; j++) {
                if (memory[j] == 1) {
                    free = false;
                    break;
                }
            }
            if (free) {
                for (int j = i; j < i + x; j++) {
                    memory[j] = 1;
                }
                return i;
            }
        }
        return -1;
    }

    private static int eraseBlock(int[] memory, int index) {
        if (index < 0 || index >= memory.length || memory[index] == 0) {
            return -1;
        }
        int length = 0;
        while (index < memory.length && memory[index] == 1) {
            memory[index] = 0;
            index++;
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
       // int[][] queries = {{0, 2}, {0, 1}, {0, 1}, {1, 0}, {1, 1}, {1, 3}, {0, 4}};
        int[][] queries = {{0, 2}, {0, 1}, {0, 1}, {1, 0}, {1, 1}, {1, 3}, {0, 4}};

        int[] memory = new int[13];
        List<Integer>
                results = processQueries(queries, new int[]{0,1,0,0,0,1,1,0,0,0,1,0,0});
        System.out.println(results); // Output: [2, 0, -1, 1, 1, -1, -1]
   // }
    //public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 0}
        };

        Test solution = new Test();
       // System.out.println(solution.numIslands(grid)); // Output: 5
    }








}
