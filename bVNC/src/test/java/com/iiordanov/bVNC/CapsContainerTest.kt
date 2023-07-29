package com.iiordanov.bVNC


import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import java.util.Hashtable

//import org.mockito.junit.jupiter.MockitoExtension


internal class CapsContainerTest {

    private val cc = CapsContainer()

    //add CapabilityInfo input
    @Test
    fun testconstructor() {

        assertEquals(1, 1)
        //check that infoMap capacity is set to 64
        //assertEquals(64, cc.infoMap.)

        //check that infoMap loadFactor is 0.25
            //loadfactor is private so I'm not sure if it can be checked

        //check enumeration of infoMap


    }
    @Test
    fun testadd() {

        //add CI object
        val ci = CapabilityInfo(123, "aaa", "bbb", "ccc")
        cc.add(ci)

        assertEquals(ci, cc.getInfo(ci.getCode()))

        //add to list without CI object
        //cc.add(321, "aaa", "bbb", "ccc")

        //not sure how to get object that add creates to check that it fetches the right one
        //assertEquals(ci, cc.getInfo(321))

    }

    //isknown was not used till this function was created
    @Test
    fun testisknown() {

        //check code that is in list
        val ci = CapabilityInfo(123, "aaa", "bbb", "ccc")
        cc.add(ci)
        assertTrue(cc.isKnown(123))

        //check code that is not in list
        assertFalse(cc.isKnown(100))
    }

    //getDescription was not used till this function was created
    @Test
    fun testgetDescription() {
        val ci = CapabilityInfo(123, "aaa", "bbb", "ccc")
        cc.add(ci)

        assertEquals("ccc", cc.getDescription(123))
    }

    @Test
    fun testEnable() {
        val ci = CapabilityInfo(123, "aaa", "bbb", "ccc")
        cc.add(ci)

        assertFalse(ci.isEnabled())
        cc.enable(ci)
        assertTrue(ci.isEnabled())
    }

    // isEnabled was not used till this function was created
    @Test
    fun testisEnabled() {
        val ci = CapabilityInfo(123, "aaa", "bbb", "ccc")
        cc.add(ci)

        assertFalse(cc.isEnabled(123))
        ci.enable()
        assertTrue(cc.isEnabled(123))
    }

    @Test
    fun testnumEnabled() {
        val ci1 = CapabilityInfo(123, "aaa", "bbb", "ccc")
        cc.add(ci1)
        val ci2 = CapabilityInfo(123, "aaa", "bbb", "ccc")
        cc.add(ci2)

        assertEquals(0, cc.numEnabled())
        cc.enable(ci1)
        assertEquals(1, cc.numEnabled())
        cc.enable(ci2)
        assertEquals(2, cc.numEnabled())
    }

    @Test
    fun testgetByOrder() {
        val ci1 = CapabilityInfo(11, "aaa", "bbb", "ccc")
        cc.add(ci1)
        cc.enable(ci1)
        val ci2 = CapabilityInfo(22, "aaa", "bbb", "ccc")
        cc.add(ci2)
        cc.enable(ci2)

        assertEquals(11, cc.getByOrder(0))
        assertEquals(22, cc.getByOrder(1))
    }

}