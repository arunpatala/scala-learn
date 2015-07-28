import java.io.*;
import java.util.*;
import static java.lang.Math.min;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Math.pow;

class Main{
	public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		while(T--!=0){
			String S = br.readLine();
			Node n = new Node(S,0);
			n.calc();
			n.calc1();
			System.out.println(new Node(S,0));
			System.out.println(min(n.C[0],min(n.C[1],n.C[2])));
			System.out.println(max(n.D[0],max(n.D[1],n.D[2])));
		}
		br.close();
	}
}

class Node{
	int i,j;
	Node l,r;
	int[] C = new int[3];//RGB
	int[] D = new int[3];//RGB
	public Node(String s, int ci){
		i=ci;
		char c = s.charAt(ci);
		if(c=='0')j=i;
		else if(c=='1'){
			l = new Node(s,i+1);
			j=l.j;
		} else{
			l = new Node(s,i+1);
			r = new Node(s,l.j+1);
			j=r.j;
		}
	}
	public void calc(){
		if(l==null&&r==null)
		{
			C[1]=1;	
		}
		else if(r==null){
			l.calc();
			C[0]=min(l.C[1],l.C[2]);
			C[1]=1+min(l.C[0],l.C[2]);
			C[2]=min(l.C[0],l.C[1]);
		}else if(l==null){
			r.calc();
			C[0]=min(r.C[1],r.C[2]);
			C[1]=1+min(r.C[0],r.C[2]);
			C[2]=min(r.C[0],r.C[1]);
		}else{
			l.calc();
			r.calc();
			C[0]=min(l.C[1]+r.C[2],l.C[2]+r.C[1]);
			C[1]=1+min(l.C[0]+r.C[2],l.C[2]+r.C[0]);
			C[2]=min(l.C[1]+r.C[0],l.C[0]+r.C[1]);
		}
		System.out.println(Arrays.toString(C));
	}
	public void calc1(){
		if(l==null&&r==null)
		{
			D[1]=1;	
		}
		else if(r==null){
			l.calc1();
			D[0]=max(l.D[1],l.D[2]);
			D[1]=1+max(l.D[0],l.D[2]);
			D[2]=max(l.D[0],l.D[1]);
		}else if(l==null){
			r.calc1();
			D[0]=max(r.D[1],r.D[2]);
			D[1]=1+max(r.D[0],r.D[2]);
			D[2]=max(r.D[0],r.D[1]);
		}else{
			l.calc1();
			r.calc1();
			D[0]=max(l.D[1]+r.D[2],l.D[2]+r.D[1]);
			D[1]=1+max(l.D[0]+r.D[2],l.D[2]+r.D[0]);
			D[2]=max(l.D[1]+r.D[0],l.D[0]+r.D[1]);
		}
		System.out.println(Arrays.toString(C));
	}
	public String toString(){
		int ret = 0;
		if(l!=null)ret++;
		if(r!=null)ret++;
		return ""+ret+(l==null?"":l)+(r==null?"":r);
	}
}
