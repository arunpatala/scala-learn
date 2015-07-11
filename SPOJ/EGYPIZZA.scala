import scala.io.Source
import scala.annotation.tailrec
import scala.math.max
import scala.annotation.tailrec



object Main extends App{
        def read = Source.fromInputStream(System.in).getLines().takeWhile(_!=null)
	val N = read.next.toInt
	var N14 =0;
	var N12 =0;
	var N34 =0;
	read.take(N).foreach{ s =>
		if(s=="1/4") N14 = N14 +1;
		else if(s=="1/2") N12 = N12 +1;
		else if(s=="3/4") N34 = N34 +1;
	}
	var total = 0;
	if(N14<=N34){
		total = total + N14;
		N14 = 0;
		N34 = N34-N14;
	}
	else{
	//if(N14>N34){
		total = total + N34;
		N14 = N14-N34;
		N34 = 0;
	}
	if(2*N12<=N14){
		total = total + N12;
		N14 = N14-2*N12;
		N12 = 0;
	}
	else{
	//if(2*N12>N14){
		total = total + N14/2;
		N14 = N14%2;
		N12 = N12-N14/2;
	}
	if(N12>=2){
		total = total + N12/2;
		N12 = N12%2;
	}
	if(N14>=4){
		total = total + N14/4;
		N12 = N12%4;
	}

	total = total + N34 + N12 + N14 + 1;
	println(total)
}
Main.main(Array())
