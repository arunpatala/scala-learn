a = str.split(raw_input())
n = int(a[0])
k = int(a[1])
s = int(a[2])
b = str.split(raw_input())
A = sorted([int(x) for x in b])
A.reverse()
sum = 0
i = 0;
while sum<k*s:
	sum += A[i];
	i = i+1;
print i

