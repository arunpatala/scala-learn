#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#include "algorithm"
using namespace std;

const int MAX = 90009;
char txt[MAX]; //input
int iSA[MAX], SA[MAX]; //output
int cnt[MAX], next[MAX]; //internal
bool bh[MAX], b2h[MAX];
 
// Compares two suffixes according to their first characters
bool smaller_first_char(int a, int b){
  return txt[a] < txt[b];
}
void printArr(int n)
{
        int i;
        for(i=0;i<n;i++)
                printf("%s\n",&txt[SA[i]]);
}

 
void suffixSort(int n){
  //sort suffixes according to their first characters
  for (int i=0; i<n; ++i){
    SA[i] = i;
  }
  sort(SA, SA + n, smaller_first_char);
  //{SA contains the list of suffixes sorted by their first character}
 
  for (int i=0; i<n; ++i){
    bh[i] = i == 0 || txt[SA[i]] != txt[SA[i-1]];
    b2h[i] = false;
  }
 
  for (int h = 1; h < n; h <<= 1){
    //{bh[i] == false if the first h characters of SA[i-1] == the first h characters of SA[i]}
    int buckets = 0;
    for (int i=0, j; i < n; i = j){
      j = i + 1;
      while (j < n && !bh[j]) j++;
      next[i] = j;
      buckets++;
    }
    if (buckets == n) break; // We are done! Lucky bastards!
    //{suffixes are separted in buckets containing txtings starting with the same h characters}
 
    for (int i = 0; i < n; i = next[i]){
      cnt[i] = 0;
      for (int j = i; j < next[i]; ++j){
        iSA[SA[j]] = i;
      }
    }
 
    cnt[iSA[n - h]]++;
    b2h[iSA[n - h]] = true;
    for (int i = 0; i < n; i = next[i]){
      for (int j = i; j < next[i]; ++j){
        int s = SA[j] - h;
        if (s >= 0){
          int head = iSA[s];
          iSA[s] = head + cnt[head]++;
          b2h[iSA[s]] = true;
        }
      }
      for (int j = i; j < next[i]; ++j){
        int s = SA[j] - h;
        if (s >= 0 && b2h[iSA[s]]){
          for (int k = iSA[s]+1; !bh[k] && b2h[k]; k++) b2h[k] = false;
        }
      }
    }
    for (int i=0; i<n; ++i){
      SA[iSA[i]] = i;
      bh[i] |= b2h[i];
    }
  }
  for (int i=0; i<n; ++i){
    iSA[SA[i]] = i;
  }
}
// End of suffix array algorithm
 
 
int lcp[MAX];
int SS[MAX];
void getlcp(int n)
{
  for (int i=0; i<n; ++i) 
    iSA[SA[i]] = i;

  lcp[0] = 0;

  for (int i=0, h=0; i<n; ++i)
  {
    if (iSA[i] > 0)
    {
      int j = SA[iSA[i]-1];
      while (i + h < n && j + h < n && txt[i+h] == txt[j+h]) 
          h++;
      lcp[iSA[i]] = h;

      if (h > 0) 
        h--;
    }
  }
}
// End of longest common prefixes algorithm
int main()
{
	int len,cnt,K,k;
	scanf("%s",txt);
	len = strlen(txt);
	suffixSort(len);
	getlcp(len);
	SS[0] = len-SA[0];
	cnt = SS[0];
	//printf("%d,",SS[0]);
	for (int i = 1; i < len; ++i)
	{
		cnt += (len-SA[i]-lcp[i]);
		SS[i]=cnt;
		//printf("%d,",SS[i]);
	}
	//printf("\n");
	//printf("%d\n",cnt);
	scanf("%d",&K);
	while(K--)
	{
		scanf("%d",&k);
		int* SSi = lower_bound(SS,SS+len,k);
		//printf("%d\n",*SSi);
		int si = SSi-SS;
		int ki=k;
		if(SSi!=SS)
			ki = k-*(SSi-1);
		int l = lcp[si]+ki;
		//printf("%d %d %d %s\n",si,ki,l,txt+SA[si]);
		for(int i=0;i<l;i++)
			printf("%c",txt[SA[si]+i]);
		printf("\n");

	}
	return 0;
}
