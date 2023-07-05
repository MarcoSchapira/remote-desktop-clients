package com.iiordanov.util

import org.junit.Test

import org.junit.Assert.*

class RandomStringUnitTest {

    val rS = RandomString()

    @Test
    fun randomStringTest () {

        var arr = IntArray(5) { it * 1 }
        //println("$arr")

        for ((value) in arr.withIndex()) {

            val setlength = (value*2) + 2

            var teststring = rS.randomString(setlength, 20)

            //println("$teststring")

            assertEquals(setlength, teststring.length)

        }
        for ((value) in arr.withIndex()) {

            val setMaxVal = (value*2) + 10
            var teststring = rS.randomString(5, setMaxVal)

            for ((charPlacement) in arr.withIndex()) {
                var testchar = teststring[charPlacement]
                var test = testchar.code.toInt() - 32
               assertTrue(test < setMaxVal)
            }

        }

    }

    @Test
    fun randomLowerCaseStringTest () {
        var arr = IntArray(5) { it * 1 }
        //println("$arr")

        for ((value) in arr.withIndex()) {

            val setlength = (value*2) + 2

            var teststringlowercase = rS.randomLowerCaseString(setlength)

            //println("$teststring")

            assertEquals(setlength, teststringlowercase.length)

        }
    }
}