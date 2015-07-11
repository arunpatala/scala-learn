import java.util.*;

class Main{

	public static void main(String[] args){
		float[] index = new float[300];
		for(int i=1;i<300;i++)
			index[i] = index[i-1]+(1.0f/(1+i));

		Scanner in = new Scanner(System.in);
		while(true){
			float d = in.nextFloat();
			if(d==0) break;
			int di = Arrays.binarySearch(index,d);
			if(di<0) di = -1-di;
			else di = di+1;
			System.out.println(di+" cards(s)");
		}
		in.close();
	}
}
