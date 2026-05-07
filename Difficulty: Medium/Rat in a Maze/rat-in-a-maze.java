

class Solution {
    
    ArrayList<String> ans;
    public ArrayList<String> ratInMaze(int[][] maze) {
        
        ans = new ArrayList<String>();
        int n = maze.length;
        boolean[][] vis = new boolean[n][n];
        vis[0][0] = true;
        solve(maze, 0, 0, "", vis);
        Collections.sort(ans, (a, b) -> a.compareTo(b));
        
        return ans;
        
    }
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    char[] dir = {'U', 'D', 'L', 'R'};
    
    public boolean areFeasible(int x, int y, int n) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
    
    public void solve(int[][] maze, int x, int y, String str, boolean[][] vis) {
        
        int n = maze.length;
        
        if (x < 0 || y < 0 || x >= n || y >= n) {
            return;
        }
        
        if (x == n-1 && y == n-1) {
            ans.add(str);
            return;
        }
        
        for (int ind = 0; ind < 4; ind++) {
            
            int curX = x + dx[ind];
            int curY = y + dy[ind];
            char curDir = dir[ind];
            
            if (areFeasible(curX, curY, n) && maze[curX][curY] == 1 && !vis[curX][curY]) {
                vis[curX][curY] = true;
                solve(maze, curX, curY, new String(str+curDir), vis);
                vis[curX][curY] = false;
            }
            
        }
        
    }
    
    
}





