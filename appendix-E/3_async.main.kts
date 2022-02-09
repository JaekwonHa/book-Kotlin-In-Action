// kotlinc -cp /usr/local/Cellar/kotlin/1.6.10/libexec/lib/kotlin-main-kts.jar -script appendix-E/3_async.main.kts

@file:Repository("https://jcenter.bintray.com")
@file:DependsOn("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
@file:DependsOn("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:1.3.8")

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit

fun now() = ZonedDateTime.now().toLocalTime().truncatedTo(ChronoUnit.MILLIS)

fun log(msg: String) = println("${now()}:${Thread.currentThread()}:${msg}")

runBlocking {
    val d1 = async { delay(1000L); 1 }
    log("after async(d1)")
    val d2 = async { delay(2000L); 2 }
    log("after async(d2)")
    val d3 = async { delay(3000L); 3 }
    log("after async(d3)")

    log("1+2+3 = ${d1.await() + d2.await() + d3.await()}")
    log("after await all & add")
}

/*
01:54:20.318:Thread[main,5,main]:after async(d1)
01:54:20.320:Thread[main,5,main]:after async(d2)
01:54:20.321:Thread[main,5,main]:after async(d3)
01:54:23.329:Thread[main,5,main]:1+2+3 = 6
01:54:23.329:Thread[main,5,main]:after await all & add          <- 6초가 아니라 3초만 소요되었다
 */
