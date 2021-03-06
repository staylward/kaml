# kaml

[![Build Status](https://img.shields.io/travis/charleskorn/kaml/master.svg)](https://travis-ci.org/charleskorn/kaml)
[![Coverage](https://img.shields.io/codecov/c/github/charleskorn/kaml.svg)](https://codecov.io/gh/charleskorn/kaml)
[![License](https://img.shields.io/github/license/charleskorn/kaml.svg)](https://opensource.org/licenses/Apache-2.0)
[![Maven Central](https://img.shields.io/maven-central/v/com.charleskorn.kaml/kaml.svg?label=maven%20central)](https://search.maven.org/search?q=g:%22com.charleskorn.kaml%22%20AND%20a:%22kaml%22)

## What is this?

This library adds YAML support to [kotlinx.serialization](https://github.com/Kotlin/kotlinx.serialization/).

YAML version 1.2 is supported.

This is a very rough initial version:

* Currently, only parsing YAML is supported. Emitting YAML will be added in a future version.
* Many operations are not yet optimised for performance.
* Only the JVM is supported, Kotlin/Native support will be added in a future version.

## Usage sample

```kotlin
@Serializable
data class Team(
    val leader: String,
    val members: List<String>
)

val input = """
        leader: Amy
        members:
          - Bob
          - Cindy
          - Dan
    """.trimIndent()

val result = YAML.parse(Team.serializer(), input)

println(result)
```

## Contributing to kaml

Pull requests and bug reports are always welcome!

kaml uses [batect](https://batect.charleskorn.com) to simplify development environment setup:

* To build the library: `./batect build`
* To run the tests and static analysis tools: `./batect check`
* To run the tests and static analysis tools continuously: `./batect continuousCheck`

Other commands are available by running `./batect --list-tasks`

## Reference links

* [YAML 1.2 Specification](http://yaml.org/spec/1.2/spec.html)
* [Dahgan](https://github.com/kareez/dahgan/), the YAML parser this library is based on
