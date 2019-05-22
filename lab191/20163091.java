import java.util.*;
import java.util.Stack;

// offset

/**
 * Maze Class
 *
 */

class Maze {

	Pos[] positi;
	private int[][] maze;	// 2 dim array for maze
	private int[][] mark;	// 2 dim array for visit marking

	class Pos{
		int x;
		int y;
	}

	public Maze(int m, int p) {
		maze = new int[m + 2][p + 2];
		mark = new int[m + 2][p + 2];
		for(int i = 0; i < m + 2; i++)
			for(int j = 0; j < p + 2; j++) {
				maze[i][j] = 1;
				mark[i][j] = 0;
			}
	}

	// create the maze structure
	public void SetWall(int i, int j, int val) {
		maze[i][j] = val;
	}


	public void Path(int m, int p) {
		Pos posit = new Pos();
		Pos posit2 = new Pos();
		posit.x = 1;
		posit.y = 1;
		posit2.x = 1;
		posit2.y = 1;
		Stack<Integer> mystack = new Stack<>();
		while(true){
			mark[posit.x][posit.y] = 1;

			switch(1){	//E, SE, NE, N, NW, W, SW, S
				case 1:
					if(maze[posit.x][posit.y+1] == 0 && mark[posit.x][posit.y+1] == 0){
						posit.y++;
						mystack.push(1);
						break;
					}
				case 2:
					if(maze[posit.x+1][posit.y+1] == 0 && mark[posit.x+1][posit.y+1] == 0){
						posit.x++;
						posit.y++;
						mystack.push(2);
						break;
					}
				case 3:
					if(maze[posit.x-1][posit.y+1] == 0 && mark[posit.x-1][posit.y+1] == 0){
						posit.x--;
						posit.y++;
						mystack.push(3);
						break;
					}
				case 4:
					if(maze[posit.x-1][posit.y] == 0 && mark[posit.x-1][posit.y] == 0){
						posit.x--;
						mystack.push(4);
						break;
					}
				case 5:
					if(maze[posit.x-1][posit.y-1] == 0 && mark[posit.x-1][posit.y-1] == 0){
						posit.x--;
						posit.y--;
						mystack.push(5);
						break;
					}
				case 6:
					if(maze[posit.x][posit.y-1] == 0 && mark[posit.x][posit.y-1] == 0){
						posit.y--;
						mystack.push(6);
						break;
					}
				case 7:
					if(maze[posit.x+1][posit.y-1] == 0 && mark[posit.x+1][posit.y-1] == 0){
						posit.x++;
						posit.y--;
						mystack.push(7);
						break;
					}
				case 8:
					if(maze[posit.x+1][posit.y] == 0 && mark[posit.x+1][posit.y] == 0){
						posit.x++;
						mystack.push(8);
						break;
					}
				defult:
					if(posit.x == 1 && posit.y == 1){
						System.out.println("No path in the maze.");
						return;
					}
					int lastpos = (int)mystack.pop();
					switch(lastpos){
						case 1:
							posit.y--;
							break;
						case 2:
							posit.x--;
							posit.y--;
							break;
						case 3:
							posit.x++;
							posit.y--;
							break;
						case 4:
							posit.x++;
							break;
						case 5:
							posit.x++;
							posit.y++;
							break;
						case 6:
							posit.y++;
							break;
						case 7:
							posit.x--;
							posit.y++;
							break;
						case 8:
							posit.x--;
							break;
					}
					break;
			}

			if(posit.x == m && posit.y == p){
				break;
			}
		}

		int call = mystack.size();
		int[] stacknum = new int[call];
		for(int i = call-1; i >= 0; i--){
			stacknum[i] = mystack.pop();
		}

		int setnum = 0;
		System.out.println("(" + posit2.x + "," + posit2.y + ")");
		for(int i = 0; i < call; i++){
			switch(stacknum[i]){
				case 1:
					posit2.y++;
					break;
				case 2:
					posit2.x++;
					posit2.y++;
					break;
				case 3:
					posit2.x--;
					posit2.y++;
					break;
				case 4:
					posit2.x--;
					break;
				case 5:
					posit2.x--;
					posit2.y--;
					break;
				case 6:
					posit2.y--;
					break;
				case 7:
					posit2.x++;
					posit2.y--;
					break;
				case 8:
					posit2.x++;
					break;
			}
			System.out.println("(" + posit2.x + "," + posit2.y + ")");
		}

		//stack and switch


	}

};
