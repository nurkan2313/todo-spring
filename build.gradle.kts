plugins {
    java
    id("org.springframework.boot") version "3.2.1"
    id("io.spring.dependency-management") version "1.1.4"
}

apply(plugin = "io.spring.dependency-management")

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    // https://mvnrepository.com/artifact/io.springfox/springfox-boot-starter
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    // https://mvnrepository.com/artifact/org.projectlombok/lombok
    // https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")
    // https://mvnrepository.com/artifact/org.springframework.security/spring-security-web
    // https://mvnrepository.com/artifact/org.springframework.security/spring-security-core
    implementation ("org.springframework.security:spring-security-core:6.2.0")
    implementation ("org.springframework.security:spring-security-web:6.2.1")
    // https://mvnrepository.com/artifact/org.springframework.security/spring-security-config
    implementation("org.springframework.security:spring-security-config:6.2.1")
    // https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui
    implementation ("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")
    runtimeOnly ("org.postgresql:postgresql:42.7.1")
    // https://mvnrepository.com/artifact/org.projectlombok/lombok
    compileOnly ("org.projectlombok:lombok:1.18.30")

    annotationProcessor ("org.projectlombok:lombok:1.18.30")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}