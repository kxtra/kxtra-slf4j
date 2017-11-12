# kxtra-slf4j

[![](https://jitpack.io/v/org.kxtra/kxtra-slf4j.svg)](https://jitpack.io/#org.kxtra/kxtra-slf4j)

Kotlin extensions for [SLF4J](https://www.slf4j.org/)

[How to get](https://jitpack.io/#org.kxtra/kxtra-slf4j)

Requires Java 7+

## Getting a logger

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
    val myClassName = MyClass::class.java.name
    assertEquals(myClassName, MyClass().logger.name)
    assertEquals(myClassName, MyClass.staticLogger.name)
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
    val mySubClass = MySubClass()
    assertEquals(MyClass::class.java.name, mySubClass.loggerWithDeclaredName.name)
    assertEquals(MySubClass::class.java.name, mySubClass.loggerWithSubClassName.name)
}
```

* Custom name:
```kotlin
val logger = getLogger("custom-name")
```