/*

   Copyright 2018 Charles Korn.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

*/

import com.charleskorn.kaml.build.configureAssemble
import com.charleskorn.kaml.build.configureJacoco
import com.charleskorn.kaml.build.configurePublishing
import com.charleskorn.kaml.build.configureSpotless
import com.charleskorn.kaml.build.configureTesting
import com.charleskorn.kaml.build.configureVersioning
import com.charleskorn.kaml.build.configureWrapper
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        jcenter()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.3.11")
    }
}

plugins {
    kotlin("jvm") version "1.3.11"

    apply { id("com.github.ben-manes.versions") version "0.20.0" }
}

apply(plugin = "kotlinx-serialization")

group = "com.charleskorn.kaml"

repositories {
    jcenter()
    mavenCentral()
    maven(url = "https://kotlin.bintray.com/kotlinx")
}

dependencies {
    compile(kotlin("stdlib-jdk8", "1.3.11"))
    compile(group = "com.github.mhshams", name = "core", version = "0.5.0")
    compile(group = "org.jetbrains.kotlinx", name = "kotlinx-serialization-runtime", version = "0.9.1")

    val spekVersion = "1.2.1"

    // Override the version of kotlin-reflect used by Spek.
    testImplementation(kotlin("reflect", "1.3.11"))
    testImplementation(group = "org.jetbrains.spek", name = "spek-api", version = spekVersion)
    testImplementation(group = "ch.tutteli.atrium", name = "atrium-cc-en_GB-robstoll", version = "0.7.0")

    testRuntimeOnly(group = "org.jetbrains.spek", name = "spek-junit-platform-engine", version = spekVersion)
    testRuntimeOnly(group = "org.junit.platform", name = "junit-platform-engine", version = "1.3.2")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

configureAssemble()
configureJacoco()
configurePublishing()
configureSpotless()
configureTesting()
configureVersioning()
configureWrapper()
