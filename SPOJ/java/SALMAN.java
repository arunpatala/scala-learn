import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;
import java.lang.Math;

class Main{

	public static void main(String[] args) throws IOException{	

		PrintWriter out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		while(T--!=0){
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = parseInt(st.nextToken());
			int M = parseInt(st.nextToken());
			Node[] A = new Node[N+1];
			for(int i=1;i<=N;i++)
				A[i] = new Node(i);
			for(int i=1;i<=N;i++)
			{
				st = new StringTokenizer(br.readLine());
				int p = parseInt(st.nextToken());
				int s = parseInt(st.nextToken());
				A[i].setSalary(s);
				if(p!=0){
					A[i].setParent(A[p]);
					A[p].addChild(A[i]);
				}
			}
			A[1].calcSum();
			while(M--!=0)
			{
				System.out.println(A[1]);
				st = new StringTokenizer(br.readLine());
				int c = parseInt(st.nextToken());
				int v = parseInt(st.nextToken());
				if(c==1)
					System.out.println(A[v].query());
				else {
					A[v].update();
				}
			}
		}
		out.flush();
		out.close();
		br.close();
	}

}

class Node{

	List<Node> children;
	int sum,id;
	Node parent;
	int salary;
	int minSalary;
	int size;
	int add;
	int addSum;

	public Node(int cid){
		id = cid;
		children = new LinkedList<Node>();
		size = 1;
		add = 0;
	}
	public void setSalary(int s){
		salary = s;
		minSalary = s;
	}
	public void setParent(Node p){
		parent = p;
	}
	public void addChild(Node c){
		children.add(c);
	}

	public void calcSum(){
		sum = salary;
		for(Node c:children)
		{
			c.calcSum();
			sum += c.sum;
			minSalary = Math.min(minSalary,c.minSalary);
			size += c.size;
		}
	}

	public int query(){
		int ret = sum+addSum;
		ret += add*size;
		Node p = parent;
		while(p!=null){
			ret += size*p.add;
			p=p.parent;
		}
		return ret;
	}

	public void update(){
		add += Math.min(minSalary,1000);
		Node p = parent;
		while(p!=null){
			addSum += (add*size);
			p=p.parent;
		}
	}

	public String toString(){
		//return "("+(left==null?"":left.toString())+"["+id+","+salary+","+sum+"]"+(right==null?"":right.toString())+")";
		String ret = "["+id+","+children.size()+","+salary+","+sum+","+(parent!=null?parent.id:"")+"]\n";
		for (Node c:children)
			ret += "\t"+c;
		return ret;
	}

}

