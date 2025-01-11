package app

import app.tt.ExampleResponse
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.math.BigDecimal
import java.util.function.Supplier
import java.util.function.Function

@SpringBootApplication
class ExampleFunctionApplication {

    private val log = KotlinLogging.logger {}

    @Bean
    fun ping(): Supplier<String> {
        return Supplier { "example ping done" }
    }

    @Bean
    fun post1() : Function<ExampleRequest, ExampleResponse> = Function { request ->
        log.info { "받은 요청: name=${request.name}, age=${request.age} account : ${request.account}" }
        ExampleResponse(request.name, request.age, request.account)
    }

    @Bean
    fun post2() : (ExampleRequest) -> ExampleResponse {
        return {
            log.info { "받은 요청: name=${it.name}, age=${it.age} account : ${it.account}" }
            ExampleResponse(it.name, it.age, it.account)
        }
    }

    @Bean
    fun post3() : Function<String, ExampleResponse> = Function { request ->
//        log.info { "받은 요청: name=${request.name}, age=${request.age} account : ${request.account}" }
        println("받은 요청: $request")
//        ExampleResponse(request.name, request.age, request.account)
        ExampleResponse("11", 22, BigDecimal(33.3))
    }

    data class ExampleRequest(
        val name : String,
        val age : Int,
        val account : BigDecimal
    )
}

fun main(args: Array<String>) {
    runApplication<ExampleFunctionApplication>(*args)
}
