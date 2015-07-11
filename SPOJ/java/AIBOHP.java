import java.io.*;



class Main{
	static int palin(char[] S){
		int N = S.length;
		int[][] Z = new int[2][N+2];
		for(int l=1;l<=N;l++)
			for(int i=1;i<=N-l+1;i++)
		{
			int j = i+l-1;
			if(S[(i-1)%2]==S[j-1]) Z[i%2][j] = Z[(i+1)%2][j-1];
					else Z[i%2][j] = 1+java.lang.Math.min(Z[(i+1)%2][j],Z[i%2][j-1]);
		}
		return Z[1][N];
	}

	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	 
		int t = Integer.parseInt(br.readLine());
		while(t--!=0){
			System.out.println(palin(br.readLine().toCharArray()));
		}
	}

}

