import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

// Main Fn
fun main() {
    // Do some work
    fun doSomeWork() {
        var count = 0
        while (count++ < 100000);
    }

    runBlocking {
        val task1 = withContext(Dispatchers.Default) { doSomeWork();" task1: ✅," }
        val task2 = withContext(Dispatchers.Default) { " task2: ✅," }
        val task3 = withContext(Dispatchers.Default) { doSomeWork();" task3: ✅," }
        val task4 = withContext(Dispatchers.Default) { " task4: ✅" }

        val resultOnceAllComplete = task1 + task2 + task3 + task4
        println(resultOnceAllComplete)
    }
}