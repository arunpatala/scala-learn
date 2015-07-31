import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{

	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());
		TrieNode t = new TrieNode(false);
		for(int i=0;i<N;i++)
			t.insert(br.readLine());
		int M = parseInt(br.readLine());
		for(int i=1;i<=M;i++)
		{
			System.out.println("Case #"+i+":");
			String si = br.readLine();
			List<String> s = t.search(si);
			System.out.println(s);
			if(s.size()==0)System.out.println("No match.");
			else for(String str:s) 
				if(!str.equals(""))
				System.out.println(si+str);
		}

		br.close();
	}

}
class TrieNode{

	TrieNode[] child;
	boolean end;
	public TrieNode(boolean end){
		child = new TrieNode[26];
		this.end = end;
	}

	public void insert(String str){
		int i = str.charAt(0)-'a';
		boolean e = str.length()==1;
		if(child[i]==null)
			child[i] = new TrieNode(e);
		if(!e)
			child[i].insert(str.substring(1));
	}
	public List<String> search(String str){
		if(str.length()==0){
			return strings();
		}
		int i = str.charAt(0)-'a';
		if(child[i]!=null) return child[i].search(str.substring(1));
		else return new LinkedList<String>();
	}
	public List<String> strings(){
		List<String> ret = new LinkedList<>();
		if(end) ret.add("");
		for(int i=0;i<26;i++)
			if(child[i]!=null)
				for(String s:child[i].strings())
					ret.add(((char)(i+'a'))+s);

		return ret;

	}
}
