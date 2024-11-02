package app

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication
class PingFunctionApplication {

    private val log = KotlinLogging.logger {}
    @Bean
    fun ping(): (String) -> String {
        println("aaa")
        log.info { "ㅇㅇ 잘됨" }
        return { "ok!" }
    }
}


fun main(args: Array<String>) {
    runApplication<PingFunctionApplication>(*args)
}
