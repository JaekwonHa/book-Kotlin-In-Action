// kotlinc -cp /usr/local/Cellar/kotlin/1.6.10/libexec/lib/kotlin-main-kts.jar -script appendix-E/1_launch.main.kts

@file:Repository("https://jcenter.bintray.com")
@file:DependsOn("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
@file:DependsOn("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:1.3.8")

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit

fun now() = ZonedDateTime.now().toLocalTime().truncatedTo(ChronoUnit.MILLIS)

fun log(msg: String) = println("${now()}:${Thread.currentThread()}:${msg}")

fun launchInGlobalScope() {
    GlobalScope.launch {
        log("coroutine started.")
    }
}

log("main() started.")
launchInGlobalScope()
log("launchInGlobalScope() executed")
Thread.sleep(5000L)
log("main() terminated.")

/*
01:35:13.462:Thread[main,5,main]:main() started.
01:35:13.509:Thread[main,5,main]:launchInGlobalScope() executed
01:35:13.512:Thread[DefaultDispatcher-worker-1,5,main]:coroutine started.
01:35:18.512:Thread[main,5,main]:main() terminated.
 */

fun runBlockingExample() {
    runBlocking {
        launch {
            log("GlobalScope.launch started.")
        }
    }
}

log("main() started.")
runBlockingExample()
log("GlobalScope.launch executed")
Thread.sleep(5000L)
log("main() terminated.")

/*
01:38:04.575:Thread[main,5,main]:main() started.
01:38:04.580:Thread[main,5,main]:GlobalScope.launch started.
01:38:04.581:Thread[main,5,main]:GlobalScope.launch executed
01:38:09.583:Thread[main,5,main]:main() terminated.
 */
