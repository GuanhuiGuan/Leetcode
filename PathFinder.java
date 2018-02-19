package nearestPosition;
import java.util.*;

public class PathFinder implements Robot{
	int m, n;
	int[][] map, dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
	
	public void explore(int[][] map, int[] pos) {
		this.map = map;
		if(map == null || map.length == 0 || map[0].length == 0)	return;
		m = map.length;
		n = map[0].length;
		
		int[] next = searchNearest(pos);
		while(next != null) {
			// printMap
			printMap();
			// move row first, then move column
			//up
			while(next[0] - pos[0] < 0) moveUp(pos);
			// down
			while(next[0] - pos[0] > 0) moveDown(pos);
			// left
			while(next[1] - pos[1] < 0) moveLeft(pos);
			// right
			while(next[1] - pos[1] > 0) moveRight(pos);
			
			// set cur and next
			pos = new int[] {next[0], next[1]};
			next = searchNearest(pos);
		}
		System.out.println("Output Map");
		printMap();
	}
	
	public void printMap() {
		System.out.println("______________________");
		for(int[] line: map) {
			String s = "";
			for(int i: line)	s += i + " ";
			System.out.println(s);
		}
		System.out.println("______________________");
	}
	
	public int[] searchNearest(int[] pos) {
		Queue<int[]> q = new LinkedList<>();
		// mark if visited
		int[][] visited = new int[m][n];
		q.offer(pos);
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			map[cur[0]][cur[1]] = 0;
			visited[cur[0]][cur[1]] = 1;
			for(int[] dir: dirs) {
				int[] next = new int[] {dir[0]+cur[0], dir[1]+cur[1]};
				if(next[0] < 0
						|| next[0] >= m
						|| next[1] < 0
						|| next[1] >= n
						|| visited[next[0]][next[1]] == 1)	continue;
				// found
				if(map[next[0]][next[1]] == 1) {
					return next;
				}
				// if not, put it queue for next search
				q.offer(next);
			}
		}
		return null;
	}
	
	public void moveUp(int[] pos) {
		if(pos[0] == 0)	return;
		pos[0]--;
		map[pos[0]][pos[1]] = 0;
	}
	
	public void moveDown(int[] pos) {
		if(pos[0] == m-1)	return;
		pos[0]++;
		map[pos[0]][pos[1]] = 0;
	}
	
	public void moveLeft(int[] pos) {
		if(pos[1] == 0)	return;
		pos[1]--;
		map[pos[0]][pos[1]] = 0;
	}
	
	public void moveRight(int[] pos) {
		if(pos[1] == n-1)	return;
		pos[1]++;
		map[pos[0]][pos[1]] = 0;
	}
}
