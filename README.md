# kxtra-slf4j

[![](https://jitpack.io/v/org.kxtra/kxtra-slf4j.svg)](https://jitpack.io/#org.kxtra/kxtra-slf4j)

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



## Getting a Logger

[Source](https://github.com/kxtra/kxtra-slf4j/blob/master/src/main/java/org/kxtra/slf4j/loggerfactory/LoggerFactory.kt)

* Static:

```kotlin
class MyClass {
    companion object {
        val logger = getLogger()
    }
}

fun test() {
    assertEquals(MyClass::class.java.name, MyClass.logger.name)
}
```

* Top level:

```kotlin
@file:JvmName("MyUtils")

package com.example

val logger = getLogger()

fun test() {
    assertEquals("com.example.MyUtils", logger.name)
}
```

* Instance:

```kotlin
class MyClass {
    val declarationLogger = getLogger()
    val classLogger = getLogger(javaClass)
}

class MySubClass : MyClass() 

fun test() {
    val myClass = MyClass()
    assertEquals(MyClass::class.java.name, myClass.declarationLogger.name)
    assertEquals(MyClass::class.java.name, myClass.classLogger.name)
    
    val mySubClass = MySubClass()
    assertEquals(MyClass::class.java.name, mySubClass.declarationLogger.name)
    assertEquals(MySubClass::class.java.name, mySubClass.classLogger.name)
}
```

* Custom name:
```kotlin
val logger = getLogger("custom-name")
```

## Lazy Evaluation

[Source](https://github.com/kxtra/kxtra-slf4j/blob/master/src/main/java/org/kxtra/slf4j/logger/Logger.kt)

```kotlin
logger.debug { "Started $context from $location" }
```

The lambda expression will be inlined and only evaluated if the logger has debug enabled. 

Extensions are provided for every combination of logging level and arguments (Throwable, Marker). 
