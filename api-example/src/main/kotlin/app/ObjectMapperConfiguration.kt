package app

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import java.time.format.DateTimeFormatter

//@Configuration
//class ObjectMapperConfiguration {
//
//    @Bean
//    fun jsonCustomizer(): Jackson2ObjectMapperBuilderCustomizer =
//        Jackson2ObjectMapperBuilderCustomizer { builder: Jackson2ObjectMapperBuilder ->
//            builder.serializers(LocalDateSerializer(DateTimeFormatter.ofPattern(DATE_FORMAT)))
//            builder.serializers(LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)))
//            builder.simpleDateFormat(DATE_TIME_FORMAT)
//        }
//
//    companion object {
//    private const val DATE_FORMAT = "yyyy-MM-dd"
//    private const val DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS"
//
//    }
//}
