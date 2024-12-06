import java.util.LinkedList
import java.util.Queue
import kotlin.math.pow

object ArmstrongNumber {

    fun check(input: Int): Boolean {
        var inputNum = input
        var digit : Int
        var sum = 0
        var queue: Queue<Int> = LinkedList()
        var count = 0

        while ( inputNum  > 0 ){
            digit = inputNum % 10
            inputNum = inputNum / 10
            queue.add(digit)
//            println("remainder $digit num $inputNum")
        }

        count = queue.size
        while ( !queue.isEmpty() ){
            sum += queue.poll().toDouble().pow(count).toInt()
        }

//        println("sum $sum")
        return sum == input
    }

}
