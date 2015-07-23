import java.io.*;
import java.util.*;
class Main
{
        public static void main(String[] args) throws IOException
        {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int n=Integer.parseInt(br.readLine());
                StringBuffer sb = new StringBuffer();
                if(n==0)System.out.println(0);
                else{
                while(n!=0){
                    if((n%2)==0){
                        n=-n/2;
                        sb.append("0");
                    }else{
                        n=-(n-1)/2;
                        sb.append("1");
                    }
                }
                System.out.println(sb.reverse());
                }
        }
        
        
        
}

