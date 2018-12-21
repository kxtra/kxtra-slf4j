# kxtra-slf4j

[![](https://jitpack.io/v/org.kxtra/kxtra-slf4j.svg?style=flat-square)](https://jitpack.io/#org.kxtra/kxtra-slf4j)

Kotlin extensions for [SLF4J](https://www.slf4j.org/)

Requires Java 7+

```
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

```
<dependency>
    <groupId>org.kxtra</groupId>
    <artifactId>kxtra-slf4j</artifactId>
    <version>1.0.1</version>
</dependency>
```

[**Source**](src/main/java/org/kxtra/slf4j/Logger.kt)

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
