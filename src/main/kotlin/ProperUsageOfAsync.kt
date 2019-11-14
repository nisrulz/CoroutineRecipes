import kotlinx.coroutines.Dispatchers
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
        val task1 = async(Dispatchers.Default) { doSomeWork();" task1: ✅," }
        val task2 = async(Dispatchers.Default) { " task2: ✅," }
        val task3 = async(Dispatchers.Default) { doSomeWork();" task3: ✅," }
        val task4 = async(Dispatchers.Default) { " task4: ✅" }
        val resultOnceAllComplete = task1.await() + task2.await() + task3.await() + task4.await()
        println(resultOnceAllComplete)
    }
}