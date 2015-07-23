import java.io.*;import java.util.*;
import java.lang.*;import java.math.*;
class Main{
public static void main(String[] args) throws IOException{	
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int N = Integer.parseInt(br.readLine());
for(int i=0;i<N;i++)
{
StringTokenizer st = new StringTokenizer(br.readLine());
BigInteger aa = new BigInteger(st.nextToken());
int a = aa.mod(new BigInteger("10")).intValue();
int b = Integer.parseInt(st.nextToken());
int ret = 1;
while(b>0){
if(b%2==1) ret = (ret*a)%10;
b = b/2;
a = (a*a)%10;
}
System.out.println(ret);
}br.close();}}

