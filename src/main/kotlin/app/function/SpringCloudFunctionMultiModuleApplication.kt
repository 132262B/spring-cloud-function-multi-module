package app.function

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringCloudFunctionMultiModuleApplication

fun main(args: Array<String>) {
    runApplication<SpringCloudFunctionMultiModuleApplication>(*args)
}
