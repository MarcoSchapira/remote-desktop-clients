package com.iiordanov.bVNC


import org.junit.Test
import org.junit.Assert.*

internal class CapabilityInfoTest {

    //Testing string constructor
    var testerCode: Int = 12345
    var testerStringa: String = "aaaa"
    var testerStringb: String = "bbbb"
    var testerStringc: String = "cccc"

    val CIstrings = CapabilityInfo(testerCode, testerStringa, testerStringb, testerStringc)

    //Testing byte constructor
    var testerCodebyte: Int = testerCode
    var testerByte1 = byteArrayOf(97, 97, 97, 97)
    var testerByte2 = byteArrayOf(98, 98, 98, 98)

    val CIbyte = CapabilityInfo(testerCodebyte, testerByte1, testerByte2)

    @Test
    fun TestingStringConstructor() {

        assertEquals(CIstrings.getCode(), testerCode)
        assertEquals(CIstrings.getDescription(), testerStringc)

        //isEnabled default
        assertFalse(CIstrings.isEnabled())

        //isEnabled false method
        CIstrings.enable()
        assertTrue(CIstrings.isEnabled())


        //equals method
        val CIstrings2 = CapabilityInfo(testerCode, testerStringa, testerStringb, testerStringc)
        assertTrue(CIstrings.equals(CIstrings2))

        //equals method, code int is not equal
        val CIstrings3 = CapabilityInfo(2, testerStringa, testerStringb, testerStringc)
        assertFalse(CIstrings.equals(CIstrings3))

        /*** more instances would be needed to check if the equals method works on every variable ***/

        //enable if equals
        //CIstrings 2 and 3 need to be used here because the enable variable in those objects is still on the default false
            //CIstrings at the top was set to true in a previous test
        assertTrue(CIstrings2.enableIfEquals(CIstrings))
        assertFalse(CIstrings3.enableIfEquals(CIstrings))

    }

    @Test
    fun TestingByteConstructor() {

        assertEquals(CIstrings.getCode(), testerCode)
        assertEquals(CIstrings.getDescription(), testerStringc)

        //isEnabled default
        assertFalse(CIstrings.isEnabled())

        //isEnabled false method
        CIstrings.enable()
        assertTrue(CIstrings.isEnabled())


        //equals method
        val CIstrings2 = CapabilityInfo(testerCode, testerStringa, testerStringb, testerStringc)
        assertTrue(CIstrings.equals(CIstrings2))

        //equals method, code int is not equal
        val CIstrings3 = CapabilityInfo(2, testerStringa, testerStringb, testerStringc)
        assertFalse(CIstrings.equals(CIstrings3))

        /*** more instances would be needed to check if the equals method works on every variable ***/

        //enable if equals
        assertTrue(CIstrings2.enableIfEquals(CIstrings))
        assertFalse(CIstrings3.enableIfEquals(CIstrings))

    }


}