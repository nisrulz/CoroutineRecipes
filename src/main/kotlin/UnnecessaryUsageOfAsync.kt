import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

// Main Fn
fun main() {
    // Do some work
    fun doSomeWork() {
        var count = 0
        while (count++ < 100000);
    }

    runBlocking {
        val task1 = async { doSomeWork();" task1: ✅," }.await()
        val task2 = async { " task2: ✅," }.await()
        val task3 = async { doSomeWork();" task3: ✅," }.await()
        val task4 = async { " task4: ✅" }.await()

        val resultOnceAllComplete = task1 + task2 + task3 + task4
        println(resultOnceAllComplete)
    }
}