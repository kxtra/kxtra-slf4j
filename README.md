# kxtra-slf4j

[![](https://jitpack.io/v/org.kxtra/kxtra-slf4j.svg)](https://jitpack.io/#org.kxtra/kxtra-slf4j)

Kotlin extensions for [SLF4J](https://www.slf4j.org/)

[How to get](https://jitpack.io/#org.kxtra/kxtra-slf4j)

Requires Java 7+

## Getting a Logger

[Source](https://github.com/kxtra/kxtra-slf4j/blob/master/src/main/java/org/kxtra/slf4j/loggerfactory/LoggerFactory.kt)

* Normal:

```kotlin
class MyClass {
    val logger = getLogger()

    companion object {
        val staticLogger = getLogger()
    }
}

fun test() {
    assertEquals(MyClass::class.java.name, MyClass().logger.name)
    assertEquals(MyClass::class.java.name, MyClass.staticLogger.name)
}
```

* Top level:

```kotlin
@file:JvmName("MyUtils")

val topLevelLogger = getLogger()

fun test() {
    assertEquals("com.example.MyUtils", topLevelLogger.name)
}
```

* Inheritance:

```kotlin
class MyClass {
    val loggerWithDeclaredName = getLogger()
    val loggerWithSubClassName = getLogger(javaClass)
}

class MySubClass : MyClass() 

fun test() {
    val myClass = MyClass()
    assertEquals(MyClass::class.java.name, myClass.loggerWithDeclaredName.name)
    assertEquals(MyClass::class.java.name, myClass.loggerWithSubClassName.name)
    
    val mySubClass = MySubClass()
    assertEquals(MyClass::class.java.name, mySubClass.loggerWithDeclaredName.name)
    assertEquals(MySubClass::class.java.name, mySubClass.loggerWithSubClassName.name)
}
```

* Custom name:
```kotlin
val logger = getLogger("custom-name")
```

## Lazy Evaluation

[Source](https://github.com/kxtra/kxtra-slf4j/blob/master/src/main/java/org/kxtra/slf4j/logger/Logger.kt)

```kotlin
logger.debug { "Started ${context.expensiveToString} from ${location.expensiveToString}" }
```

The lambda expression will only be evaluated if the logger has debug enabled. 

Overloads are provided for every combination of logging level and arguments (Throwable, Marker). 