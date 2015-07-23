import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TrieNode t = new TrieNode(false);
		while(true)
		{
			String s = br.readLine();
			if(s.equals("")) break;
			String rev = new StringBuilder(s).reverse().toString()
			t.insert(rev);
		}
		String str;
		while((str=br.readLine())!=null)
		{
			String rev = new StringBuilder(str).reverse().toString()
			System.out.println(t.search(rev));
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
	public String search(String str){
		int i = str.charAt(0)-'a';
		if(child[i]!=null)
			return child[i].search(str.substring(1));
		else 
	}

	public List<String> strings(){
		List<String> ret = new LinkedList<>();
		if(end) ret.add("");
		for(int i=0;i<=25;i++)
			if(child[i]!=null)
				for(String s:child[i].strings())
					ret.add(((char)(i+'0'))+s);

		return ret;

	}
}
