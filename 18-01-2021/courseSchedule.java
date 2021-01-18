class Solution {
    boolean[] visited;
    List<Integer>[] graph;
    public boolean canFinish(int n, int[][] preq) {
        graph = new List[n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++) graph[i] = new LinkedList<>();
        for(int i = 0; i < preq.length; i++) graph[preq[i][1]].add(preq[i][0]);
        for(int i = 0; i < n; i++) {
            if(!visited[i] && hasCycle(i,i,i)) return false;
            visited[i] = true;
        }
        return true;
    }
    private boolean hasCycle(int v, int u, int s) {
        visited[v] = true;
        for(int w : graph[v]) {
            if(!visited[w]) {
                if(hasCycle(w, v, s)) return true;    
            } else if(w == s || w == u) return true;
        }
        visited[v] = false;
        return false;
    }
}