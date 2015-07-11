#include<stdio.h>
#define islower(c) ('a'<=(c)&&(c)<='z')
#define isupper(c) ('A'<=(c)&&(c)<='Z')
#define toupper(c) ('A'+((c)-'a'))
#define tolower(c) ('a'+((c)-'A'))

#define N  100
char IN[N+1];
char OUT[2*N+1];
int main(){
	int i,j,error,java,cpp;
	while(scanf("%s",IN)!=EOF)
	{
		j=0;error=0;java=0;cpp=0;
		for(i=0;IN[i];i++)
		{
			if(islower(IN[i])) OUT[j++]=IN[i];
			else if(IN[i]=='_' && islower(IN[i+1])){cpp=1;OUT[j++]=toupper(IN[++i]);}
			else if(IN[i]=='_' && isupper(IN[i+1])) {error=1;break;}
			else if(isupper(IN[i])){java=1;OUT[j++]='_';OUT[j++]=tolower(IN[i]); }
		}
		OUT[j]=0;
		if(error) 
			printf("Error!\n");
		else if(java & cpp)
			printf("Error!\n");
		else
			printf("%s\n",OUT);	
	}
}

