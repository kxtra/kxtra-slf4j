# kxtra-slf4j [![](https://jitpack.io/v/org.kxtra/kxtra-slf4j.svg)](https://jitpack.io/#org.kxtra/kxtra-slf4j) [![Build Status](https://img.shields.io/circleci/project/github/kxtra/kxtra-slf4j.svg)](https://circleci.com/gh/kxtra/kxtra-slf4j)

Kotlin extensions for [SLF4J](https://www.slf4j.org/)

#### Easy Logger creation

```kotlin
private val logger = getLogger()
```

#### Free lazy evaluation

```kotlin
logger.debug { "$message only evaluated if debug is enabled" }
```

Requires Java 7+

Contains only [synthetic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-synthetic/index.html) [inline](https://kotlinlang.org/docs/reference/inline-functions.html) functions and thus only needs to be present at compile-time and not runtime

## Getting a Logger

**Static**

```kotlin
class MyClass {
    companion object {
        private val logger = getLogger()
    }
}
```

*Note*: The following naive method (among others) does not properly use the name of the class, it instead uses the name of the companion object

```kotlin
class MyClass {
    companion object {
        private val logger = LoggerFactory.getLogger(javaClass)
    }
}
```

**Top level**

```kotlin
private val logger = getLogger()
```

*Note*: It is not easy to otherwise get the name of the enclosing file from the top level

**Custom name**

```kotlin
private val logger = getLogger("custom-name")
```

**Instance**

```kotlin
abstract class MyClass {
    protected val declarationLogger = getLogger()
    
    protected val classLogger = getLogger(javaClass)
}

class MySubClass : MyClass() {
    // assert(declarationLogger.name == MyClass::class.java.name)
    // assert(classLogger.name == MySubClass::class.java.name)
}
```

## Lazy Evaluation

```kotlin
logger.debug { "$expensive $message" }
```

The lambda expression will be inlined and only evaluated if the logging level is enabled

Extensions are provided for every combination of logging level and arguments

```kotlin
logger.info(marker) { "$msg" }
logger.warn(exception) { "$msg" }
logger.error(marker, exception) { "$msg" }
```

## Including

*Note*: [SLF4J requires a binding!](https://www.slf4j.org/manual.html#swapping)

[**Source**](src/main/java/org/kxtra/slf4j/logger.kt) - A single file which can be manually added to any project

**Maven**

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

```xml
<dependencies>
    <dependency>
        <groupId>org.kxtra</groupId>
        <artifactId>kxtra-slf4j</artifactId>
        <version>2.1.0</version>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>1.7.28</version>
    </dependency>
</dependencies>
```

**Gradle**

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}
```

```groovy
dependencies {
    compileOnly 'org.kxtra:kxtra-slf4j:2.1.0'
    api 'org.slf4j:slf4j-api:1.7.28'
}
```
