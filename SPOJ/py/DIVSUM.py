import math
def divsum(a):
	if(a==1):
		return 0;
	else:
		sum = 1;
		for i in range(2,int(math.sqrt(a))+1):
			if(a%i==0):
				sum+=i;
				if(a/i != i):
					sum+= a/i;
		return sum;
N = int(raw_input())
for i in range(0,N):
	print divsum(int(raw_input()))
