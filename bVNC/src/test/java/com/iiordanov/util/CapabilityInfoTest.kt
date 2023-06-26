package com.iiordanov.util

import com.iiordanov.bVNC.CapabilityInfo

import org.junit.Test
import org.junit.Assert.*


class CapabilityInfoTest {

    //Testing string constructor

    var testerCode = 12345
    var testerStringa = "aaaa"
    var testerStringb = "bbbb"
    var testerStringc = "cccc"

    //val a = testerString.first().code

    val CIstrings = CapabilityInfo(testerCode,testerStringa,testerStringb, testerStringc)

    @Test
    fun TestingStringConstructor() {

        assertEquals(CIstrings.getCode(), testerCode)
        assertEquals(CIstrings.getDescription(), testerStringc)

        //isEnabled default
        assertFalse(CIstrings.isEnabled())

        //isEnabled false method
        CIstrings.enable()
        assertTrue(CIstrings.isEnabled())


        /*
        **Not sure about this part below
         */
        assertTrue(CIstrings.equals(CIstrings))
        assertTrue(CIstrings.enableIfEquals(CIstrings))





    }

}