#include <stdio.h>
char s[2001];
int main(void) {
	int T,i,right,left;
	T=1;
	while(1){
		scanf("%s",s);
		if(s[0]=='-')break;
		i=0;right=0;left=0;
		while(s[i]){
			if(s[i]=='}') {
				if(left>0)left--;
				else right++;
			}
			else left++;
			i++;
		}
		printf("%d. %d\n",T++,(right%2)+(right/2)+(left%2)+(left/2));
	}
	return 0;
}


