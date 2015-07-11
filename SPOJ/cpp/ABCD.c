#include<stdio.h>
char hash(char a, char b, char c){
	char z;
	for(z='A';z<='D';z++){
		if(z!=a && z!=b && z!=c)
			return z;
	}
}
int main(){
	int N,i;
	scanf("%d",&N);
	char S[2*N+1];
	char T[2*N+2];
	scanf("%s",S);
	T[0]='A';
	for(i=0;i<N;i++){
		T[2*i+1]=hash(T[2*i],S[2*i],S[2*i+1]);
		T[2*i+2]=hash(T[2*i+1],S[2*i],S[2*i+1]);
	}
	T[2*N+1]=0;
	printf("%s\n",T+1);
}

