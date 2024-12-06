import java.util.*

class Matrix(private val matrixAsString: String) {
    var rowSize : Int
    var matrix : Array<Array<Int>>
    lateinit var rowInt : Array<Int>

    init {
        var rowsArray = matrixAsString.split("\n")
        var row = 0
        rowSize = rowsArray.size
//        println(rowsArray)
        matrix = Array(rowSize) {Array(rowSize) {0} }
        for (rowStr in rowsArray){
            val rowArray = rowStr.split(" ")
             rowInt = rowArray.stream().mapToInt( { s: String -> Integer.valueOf(s)}).toArray().toTypedArray()
            matrix[row++] = rowInt
        }
    }

    fun column(colNr: Int): List<Int> {
        val nums = IntArray(matrix.size)

        for (i in nums.indices){
            nums[i] = matrix[i][colNr-1]
        }
        return nums.toList()
    }

    fun row(rowNr: Int): List<Int> {
        return matrix[rowNr-1].toList()
    }

}
//https://stackoverflow.com/questions/45090808/intarray-vs-arrayint-in-kotlin/45094889#45094889
//https://discuss.kotlinlang.org/t/get-column-values-in-a-2d-matrix/22642