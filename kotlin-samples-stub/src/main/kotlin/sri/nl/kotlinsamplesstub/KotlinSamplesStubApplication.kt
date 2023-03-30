package sri.nl.kotlinsamplesstub

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.common.Slf4jNotifier
import com.github.tomakehurst.wiremock.core.WireMockConfiguration.options
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSamplesStubApplication(@Value("\${http.port:8081}") val httpPort: Int) : CommandLineRunner {

    override fun run(vararg args: String?) =
        WireMockServer(
            options().port(httpPort)
                .usingFilesUnderClasspath("testdata")
                .disableRequestJournal()
                .containerThreads(10)
                .jettyAcceptors(4)
                .jettyAcceptQueueSize(100)
                .jettyHeaderBufferSize(16834)
                .asynchronousResponseEnabled(true)
                .asynchronousResponseThreads(10)
                .notifier(Slf4jNotifier(false)) // Set to true for detailed request logging
                .extensions(ResponseTemplateTransformer(false))
        ).start()
}

fun main(args: Array<String>) {
    runApplication<KotlinSamplesStubApplication>(*args)
}
