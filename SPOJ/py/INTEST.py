a = str.split(raw_input())
N = int(a[0])
K = int(a[1])
ret = 0;
for i in range(0,N):
	if(int(raw_input())%K==0):
		ret = ret + 1
print ret
