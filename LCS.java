import java.util.Random;

public class LCS {
	
	private static int testCases=100;
	private static String[] randomInput= new String[testCases];
	private static String letters="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static void main(String[] args) {
		Random random=new Random();
		int m=0;
		for (int i=0;i<testCases;i++){
			int randomNumber=random.nextInt(101-1)+1;
			randomInput[i]=generateRandomString(randomNumber);
		}

		for (int i=0;i<(testCases/2);i++){
			int result;
			result=LCS(randomInput[m],randomInput[m+1],randomInput[m].length(),randomInput[m+1].length());
			System.out.println(randomInput[m]);
			System.out.println(randomInput[m+1]+"\n");
			m+=2;
		}
	}

	public static String generateRandomString(int length){
		Random random=new Random();
		String output="";
		for (int i=0;i<length;i++){
			int randomNumber=random.nextInt(26-0)+0;
			output+=letters.charAt(randomNumber);
		}
		return output;
	}
	
	public static String reverse(String input){
		String output="";
		for (int i=input.length()-1;i>=0;i--){
			output+=input.charAt(i);
		}
		return output;
	}
	
	public static int LCS(String input1, String input2, int m,int n){
		int[][] dp=new int[m+1][n+1];
		for (int i=0;i<=m;i++){
			for (int j=0;j<=n;j++){
				if (i==0||j==0)
					dp[i][j]=0;
				else if (input1.charAt(i-1)==input2.charAt(j-1))
					dp[i][j]=dp[i-1][j-1]+1;
				else
					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
			}
		}
		//traverses through the array to get result
		int row=m;
		int col=n;
		String result="";
		while (dp[row][col]!=0){
			if (dp[row][col]==dp[row-1][col]){
				row--;
			}
			else if (dp[row][col]==dp[row][col-1]){
				col--;
			}
			else{
				result+=input1.charAt(row-1);
				row--;
				col--;
			}
		}
		result=reverse(result);
		System.out.println("Longest LCS is " +dp[m][n]);
		System.out.println("Result is " +result);
	
		return dp[m][n];
	}
}
