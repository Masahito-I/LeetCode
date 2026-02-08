plugins {
    java
    jacoco
}

group = "app.idea"
version = "1.0-SNAPSHOT"

jacoco {
    toolVersion = "0.8.14"
}

repositories {
    mavenCentral()
}

dependencies {
    val lombokVersion = "1.18.42"
    compileOnly("org.projectlombok:lombok:$lombokVersion")
    annotationProcessor("org.projectlombok:lombok:$lombokVersion")

    testCompileOnly("org.projectlombok:lombok:$lombokVersion")
    testAnnotationProcessor("org.projectlombok:lombok:$lombokVersion")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required = false
        csv.required = false
    }
    .configureEach {
        classDirectories.setFrom(sourceSets.main.map { sourceSet ->
            sourceSet.output.asFileTree.matching {
                exclude("**/**Order.class")
                exclude("**/Main.class")
            }
        })
    }
}