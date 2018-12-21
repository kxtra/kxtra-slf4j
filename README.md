# kxtra-slf4j

[![](https://jitpack.io/v/org.kxtra/kxtra-slf4j.svg)](https://jitpack.io/#org.kxtra/kxtra-slf4j)

Kotlin extensions for [SLF4J](https://www.slf4j.org/)

Requires Java 7+

Contains only [synthetic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-synthetic/index.html) [inline](https://kotlinlang.org/docs/reference/inline-functions.html) functions and thus only needs to be present at compile-time and not runtime

[**Source**](src/main/java/org/kxtra/slf4j/logger.kt)

## Including

* Maven

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
        <version>2.0.0</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

* Gradle

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}
```

```groovy
dependencies {
    compileOnly 'org.kxtra:kxtra-slf4j:2.0.0'
}
```

## Getting a Logger

* Static:

```kotlin
class MyClass {
    companion object {
        val logger = getLogger()
        // assert(logger.name == MyClass::class.java.name)
    }
}
```

* Top level:

```kotlin
@file:JvmName("MyUtils")

package com.example

val logger = getLogger()
// assert(logger.name == "com.example.MyUtils")
```

* Instance:

```kotlin
class MyClass {
    val declarationLogger = getLogger()
    // assert(declarationLogger.name == MyClass::class.java.name)
    
    val classLogger = getLogger(javaClass)
    // assert(classLogger.name == MyClass::class.java.name)
}

class MySubClass : MyClass() {
    // assert(declarationLogger.name == MyClass::class.java.name)
    // assert(classLogger.name == MySubClass::class.java.name)
}
```

* Custom name:

```kotlin
val logger = getLogger("custom-name")
```

## Lazy Evaluation

```kotlin
logger.debug { "Started $context from $location" }
```

The lambda expression will be inlined and only evaluated if the logger has the logging level enabled. 

Extensions are provided for every combination of logging level and arguments (Throwable, Marker). 
