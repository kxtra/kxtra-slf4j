package org.kxtra.slf4j

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GetLoggerTest {

    object MyObject {
        val myObjectLogger = getLogger()
        @JvmField
        val myObjectLogger2 = getLogger()
        @JvmStatic
        val myObjectLogger3 = getLogger()
    }

    open class MyClass {

        open val myClassLogger = getLogger()

        val subClassLogger = getLogger(javaClass)

        class Sub : MyClass() {
            // myClassLogger
        }

        class SubOverride : MyClass() {
            // subOverrideLogger
            override val myClassLogger = getLogger()
        }

        companion object {
            val myClassLogger2 = getLogger()
            @JvmField
            val myClassLogger3 = getLogger()
            @JvmStatic
            val myClassLogger4 = getLogger()
        }
    }

    @Test
    fun `normal class`() {
        val expectedName = MyClass::class.java.name
        assertEquals(expectedName, MyClass().myClassLogger.name)
        assertEquals(expectedName, MyClass.myClassLogger2.name)
        assertEquals(expectedName, MyClass.myClassLogger3.name)
        assertEquals(expectedName, MyClass.myClassLogger4.name)
        assertEquals(expectedName, MyClass.Sub().myClassLogger.name)
    }

    @Test
    fun `named object`() {
        val expectedName = MyObject::class.java.name
        assertEquals(expectedName, MyObject.myObjectLogger.name)
        assertEquals(expectedName, MyObject.myObjectLogger2.name)
        assertEquals(expectedName, MyObject.myObjectLogger3.name)
    }

    @Test
    fun `subclass override`() {
        assertEquals(MyClass.SubOverride::class.java.name, MyClass.SubOverride().myClassLogger.name)
    }

    @Test
    fun `sub class logger`() {
        assertEquals(MyClass::class.java.name, MyClass().subClassLogger.name)
        assertEquals(MyClass.Sub::class.java.name, MyClass.Sub().subClassLogger.name)
        assertEquals(MyClass.SubOverride::class.java.name, MyClass.SubOverride().subClassLogger.name)
    }

    @Test
    fun `top level`() {
        assertEquals(topLevelLoggerExpectedName, topLevelLogger.name)
    }
}