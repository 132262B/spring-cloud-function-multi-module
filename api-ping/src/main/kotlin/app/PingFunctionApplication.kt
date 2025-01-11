package app

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.function.Supplier


@SpringBootApplication
class PingFunctionApplication {

    private val log = KotlinLogging.logger {}

    @Bean
    fun ping(): Supplier<String> {
        log.info { "ㅇㅇ 잘됨" }
        return Supplier { "ping world" }
    }

}

fun main(args: Array<String>) {
    runApplication<PingFunctionApplication>(*args)
}
