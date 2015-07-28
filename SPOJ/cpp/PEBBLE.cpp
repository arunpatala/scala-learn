#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>
#include <string>
using namespace std;
int gcd(int a, int b){
	return (b==0)?a:gcd(b,a%b);
}

int main(){
	string s;
	int t=1;
	while(cin>>s){
		//count number of segments
		int c=1;
		for(int i=1;i<s.length();i++)
		{
			if(s[i-1]!=s[i])c++;
		}
		if(s[0]=='0')c--;
		cout << "Game#" << t++ << ": " << c << endl;
		
	}
}

