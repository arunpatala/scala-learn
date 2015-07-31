import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{

	public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		while(T--!=0){
			int N = parseInt(br.readLine());
			TrieNode t = new TrieNode();
			boolean valid = true;
			for(int i=0;i<N;i++)
				valid = valid && insert(br.readLine(),t);
			System.out.println(t.strings());
			if(valid)
				System.out.println("YES");
			else 
				System.out.println("NO");
		}
		br.close();
	}

	public static boolean insert(String s, TrieNode t)
	{
		int k=0;
		while(k<s.length())
		{
			int i=s.charAt(k)-'0';
			if(t.child[i]==null)
			{
				t.child[i]=new TrieNode();
			}else{
				if(k==s.length()-1)return false;
			}
			t=t.child[i];
			if(t.end)return false;
			k++;
		}
		t.end=true;
		return true;
	}

}
class TrieNode{
	TrieNode[] child;
	boolean end=false;
	public TrieNode(){
		child = new TrieNode[10];
	}

	public List<String> strings(){
		List<String> ret = new LinkedList<>();
		if(end) ret.add("");
		for(int i=0;i<=9;i++)
			if(child[i]!=null)
				for(String s:child[i].strings())
					ret.add(((char)(i+'0'))+s);

		return ret;

	}

}
