package solution;

public class MaximumCompatibilityScoreSum {
	public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int n = students.length;
        int m = n;
        boolean [] visited = new boolean[students.length];
        return GetMaxCS(students, mentors, n, m, 0, visited);
    }

    public int GetMaxCS(int [][] students, int [][] mentors, int n, int m, 
    int ind, boolean [] visited)
    {
        if(ind == n)
        return 0;
        int maxSum = 0;
        for(int j=0;j<m;j++)
        {
            if(visited[j])
            continue;

            visited[j] = true;
            int sum = GetSum(students[ind], mentors[j]) + 
                        GetMaxCS(students, mentors, n, m, ind+1, visited);
            visited[j] = false;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public int GetSum(int [] student, int [] mentor)
    {
        int sum = 0;
        for(int i=0;i<student.length;i++)
        {
            if(student[i] == mentor[i])
            sum++;
        }
        return sum;
    }

}
