package solution;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
	List<Integer>[] adj;
	boolean[] visited;
	boolean[] marked;
	public  boolean canFinish(int numCourses, int[][] prerequisites) {
		adj = new ArrayList[numCourses];
		for(int i = 0; i < numCourses; i++) {
			adj[i] = new ArrayList<>();
		}
		visited = new boolean[numCourses];
		marked = new boolean[numCourses];
		for(int i =0; i < prerequisites.length;i++) {
			adj[prerequisites[i][0]].add(prerequisites[i][1]);
		}
		for(int i = 0; i < numCourses; i++) {
			if(!visited[i]) {
				if(isCyclic(i)) {
					return false;
				}
			}
		}
		return true;
	}
	public boolean isCyclic(int i) {
		visited[i] = true;
		for(Integer j: adj[i]) {
			if(!visited[j]) {
				if(isCyclic(j)) {
					return true;
				}
			}else if(!marked[j]) {
				return true;
			}
		}
		marked[i] = true;
		return false;
	}
	public static void main(String[] args) {
		CourseSchedule cs = new CourseSchedule();
		int numCourses = 2;
		int [][] prerequisites = {{1,0}};
		System.out.println(cs.canFinish(numCourses,prerequisites));
	}

}
