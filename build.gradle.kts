import org.gradle.jvm.tasks.Jar

/*
 *  Copyright 2024 CNM Ingenuity, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
plugins {
    id("application")
    alias(libs.plugins.modularity)
    alias(libs.plugins.openjfx)
    alias(libs.plugins.badass.jlink)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(libs.versions.java.get())
    }
    withJavadocJar()
}

application {
    mainModule = project.property("mainModule") as String
    mainClass = project.property("mainClass") as String
}

javafx {
    version = libs.versions.openjfx.library.get()
    modules("javafx.controls", "javafx.fxml")
}

jlink {
    val launcher = project.property("launcher") as String
    imageZip = project.file("${layout.buildDirectory}/distributions/$launcher-${javafx.platform.classifier}.zip")
    options.addAll("--strip-debug", "--compress", "2", "--no-header-files", "--no-man-pages")
    launcher {
        name = launcher
    }
}

dependencies {
    testImplementation(libs.junit.aggregator)
    testRuntimeOnly(libs.junit.engine)
}

tasks.javadoc {
    setDestinationDir(file("$projectDir/docs/api"))
    with(options as StandardJavadocDocletOptions) {
        links("https://docs.oracle.com/en/java/javase/${libs.versions.java.get()}/docs/api/")
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.jlinkZip {
    group = "distribution"
}

tasks.withType(Jar::class.java).configureEach {
    exclude("**/.keep")
}
