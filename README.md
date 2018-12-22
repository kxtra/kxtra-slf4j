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
        private val logger = getLogger()
    }
}
```

**Note**: The following naive method (among others) does not properly use the name of the class, it instead uses the name of the companion object

```kotlin
class MyClass {
    companion object {
        private val logger = LoggerFactory.getLogger(javaClass)
    }
}
```

* Top level:

```kotlin
private val logger = getLogger()
```

**Note**: It is not easy to otherwise get the name of the enclosing file from the top level

* Instance:

```kotlin
class MyClass {
    protected val declarationLogger = getLogger()
    
    protected val classLogger = getLogger(javaClass)
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
