import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

// Main Fn
fun main() {
    // Do some work
    fun doSomeWork() {
        var count = 0
        while (count++ < 1000000000);
    }

    runBlocking {
        launch {
            print(" task1: ✅")
        }

        withContext(Dispatchers.IO) {
            doSomeWork();
            print(" task2: ✅")
        }

        withContext(Dispatchers.Main) {
            doSomeWork();
            print(" task2: ✅")
        }
        print(" task3: ✅")
    }
}