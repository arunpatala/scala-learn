

//object Main{
	def QuickSort(arr:Seq[Double]):Seq[Double] = if(arr.size<=1) arr else{
						val pivot = arr(arr.size/2)
						QuickSort(arr.filter(_<pivot)) ++
							arr.filter(_==pivot) ++
							QuickSort(arr.filter(_>pivot))

				}
	println(QuickSort(Array(8,5,2,3,5,7,9,1,0)))
//}
