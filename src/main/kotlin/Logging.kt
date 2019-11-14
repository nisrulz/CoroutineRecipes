import Constants.DEBUG_COROUTINES_PROPERTY
import kotlinx.coroutines.*

// Log Coroutines
fun logCoroutineInfo(msg: String) {
    println("Running on: [${Thread.currentThread().name}] | $msg")
}

// Main Fn
fun main() {
    // Enable debugging
    System.setProperty(DEBUG_COROUTINES_PROPERTY, Constants.ON)

    runBlocking {
        launch {
            logCoroutineInfo("Started from launch")
            val task1 = async {
                logCoroutineInfo("Started from async:task1")
                "Done"
            }
            val task2 = withContext(Dispatchers.IO) {
                logCoroutineInfo("Started from withContext(IO):task2")
            }
            val resultFromAsync = task1.await()
            println("Result from async:task1 = $resultFromAsync")
        }
    }
}