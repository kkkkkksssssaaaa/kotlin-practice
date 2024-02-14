import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.22"
    java
    id("org.springframework.boot") version "2.6.8"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    // 이걸 붙이면 JPA Entity 에 기본 생성자가 없는 오류가 없어진다.
    // TODO: 정확하게 어떤걸 지원해주는지 찾아봐야겠다.
    id("org.jetbrains.kotlin.plugin.jpa") version "1.9.22"
    // 이걸 붙이면 프록시 생성이 필요한 스프링 빈 클래스/메서드에 번거롭게 open 을 붙이지 않아도 된다고 한다.
    id("org.jetbrains.kotlin.plugin.spring") version "1.9.22"
}

group = "com.group"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation ("org.springframework.boot:spring-boot-starter-web")
    // fasterxml 에 kotlin module 추가
    // request 혹은 response 를 json 으로 직렬화하지 못하는 현상이 발생할 수 있어서 추가해야한다고 한다.
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.3")
    runtimeOnly("com.h2database:h2")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
