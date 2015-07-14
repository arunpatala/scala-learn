def merge(L,R):
	LR = []
	li=0
	ri=0
	while(li<len(L) and ri<len(R)):
		if(L[li]<R[ri]):
			LR.append(L[li])
			li = li + 1
		else:
			LR.append(R[ri])
			ri = ri + 1
	while(li<len(L)):
		LR.append(L[li])
		li = li + 1
	while(ri<len(R)):
		LR.append(R[ri])
		ri = ri + 1
	return LR
	
def mergesort(A):
	if (len(A)<=1): 
		return A
	else:
		n = len(A)
		mid = n/2
		left = A[:mid]
		right = A[mid:]
		l = mergesort(left) 
		r = mergesort(right)
		return merge(l,r)
		
A = [int(x) for x in str.split(raw_input())]
B = [str(x) for x in mergesort(A)]
print ' '.join(B)

	
