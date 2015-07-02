

def squares(n:Int) = (1 to n).map(i=>(i,i*i)).toMap

println(squares(8))
