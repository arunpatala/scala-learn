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
			TrieNode t = new TrieNode(false);
			boolean valid = true;
			for(int i=0;i<N&&valid;i++)
				valid = valid && t.insert(br.readLine());
			if(valid) System.out.println("YES");
			else System.out.println("NO");
		}

		br.close();
	}

}
class TrieNode{

	TrieNode[] child;
	boolean end;
	public TrieNode(boolean end){
		child = new TrieNode[10];
		this.end = end;
	}

	public boolean insert(String str){
		int i = str.charAt(0)-'0';
		boolean e = str.length()==1;
		if(end) { return false;}
		if(child[i]==null)
			child[i] = new TrieNode(e);
		else if(e) 
		{return false;}
		if(!e)
			if(!child[i].insert(str.substring(1)))
			{ return false;}
		return true;
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
