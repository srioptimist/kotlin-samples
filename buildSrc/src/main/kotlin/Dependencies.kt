/**
 * To define dependencies
 */
object SpringDeps {
    val springBootStarter by lazy { "org.springframework.boot:spring-boot-starter:${Versions.springBoot}" }
    val springBootStarterWeb by lazy { "org.springframework.boot:spring-boot-starter-web:${Versions.springBoot}" }
    val springBootStarterAop by lazy { "org.springframework.boot:spring-boot-starter-aop:${Versions.springBoot}" }
    val springBootStarterSecurity by lazy { "org.springframework.boot:spring-boot-starter-security:${Versions.springBoot}" }
    val springBootStarterActuator by lazy { "org.springframework.boot:spring-boot-starter-actuator:${Versions.springBoot}" }
    val springBootStarterTest by lazy { "org.springframework.boot:spring-boot-starter-test:${Versions.springBoot}" }
}

object KotlinDeps {
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}" }
    val kotlinReflect by lazy { "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}" }
    val kotlinCoroutinesCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinxCorountines}" }
    val kotlinCoroutinesReactor by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-reactor:${Versions.kotlinxCorountines}" }
}

object TestDeps {
    val mockK by lazy { "io.mockk:mockk:${Versions.mockk}" }
    val karateJunit5 by lazy { "com.intuit.karate:karate-junit5:${Versions.karateJunit5}" }
    val wiremock by lazy { "com.github.tomakehurst:wiremock-standalone:${Versions.wiremock}" }
}
