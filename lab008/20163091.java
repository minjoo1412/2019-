import java.util.*;

// ---------- Graph class -------------

class Graph {
    int numofnodes;  // the number of nodes in the graph
    private int[][] AdjMatrix; // Adjacency matrix
    private int[] visited; // mark the visitied node


    Graph() {
        // Graph constructor.
        numofnodes = 0;
    }

    void Init(int n) {
        numofnodes = n;
        // now create 2 dimensional array of numofnodes * numofnodes
        AdjMatrix = new int[numofnodes][numofnodes];
        for(int i = 0; i < numofnodes; i++) {
            // initialize all entries to 0
            for(int j = 0; j < numofnodes; j++)
                AdjMatrix[i][j] = 0;  // initialize the adjacency matrix
        }

    }


	void Edge(int n1, int n2) {
    AdjMatrix[n1][n2] = 1;
    AdjMatrix[n2][n1] = 1;
	}

	void Bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
    q.offer(v);
    visited = new int[numofnodes];
    int[] viar = new int[numofnodes];
    viar[v] = 1;
    int n = 0;
    int visit;
    while(true){
      if(q.isEmpty() == true){
        break;
      }
      for(int i = 0; i<numofnodes; i++){
        if(AdjMatrix[q.peek()][i] == 1){
          if(viar[i]==0){
            q.offer(i);
            viar[i] = 1;
            }
        }
        }
        visited[n] = q.poll();
        n++;
      }
    for(int i = 0; i<numofnodes; i++){
      System.out.print(visited[i] + " ");
	   }
  }

}
