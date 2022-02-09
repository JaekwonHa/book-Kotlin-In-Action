// kotlinc -cp /usr/local/Cellar/kotlin/1.6.10/libexec/lib/kotlin-main-kts.jar -script appendix-E/2_yield_example.main.kts

@file:Repository("https://jcenter.bintray.com")
@file:DependsOn("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
@file:DependsOn("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:1.3.8")

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit

fun now() = ZonedDateTime.now().toLocalTime().truncatedTo(ChronoUnit.MILLIS)

fun log(msg: String) = println("${now()}:${Thread.currentThread()}:${msg}")

fun yieldExample() {
    runBlocking {
        launch {
            log("1")
            yield()
            log("3")
            yield()
            log("5")
        }
        log("after first launch")
        launch {
            log("2")
            delay(1000L)
            log("4")
            delay(1000L)
            log("6")
        }
        log("after second launch")
    }
}

yieldExample()

/*
01:43:36.591:Thread[main,5,main]:after first launch
01:43:36.593:Thread[main,5,main]:after second launch
01:43:36.594:Thread[main,5,main]:1
01:43:36.594:Thread[main,5,main]:2                      <- 2는 1 다음에 바로 출력되지만
01:43:36.597:Thread[main,5,main]:3
01:43:36.597:Thread[main,5,main]:5
01:43:37.598:Thread[main,5,main]:4                      <- 4는 delay 때문에 3,5 다음에 출력된다
01:43:38.599:Thread[main,5,main]:6
 */
