package com.iiordanov.bVNC

import com.iiordanov.bVNC.DH.longToBytes
import org.junit.Assert.*
import org.junit.Test

import org.mockito.Mockito.mock
//import org.mockito.Mockito.`when`
//import org.mockito.Mock
//import org.mockito.Mockito.mock
//import org.mockito.Mockito.times
//import org.mockito.Mockito.verify

class DHTest {

    var dh = DH()

    @Test
    fun createKeysTest() {
        dh.createKeys() //this function wasn't used till this test

        assertTrue(dh.getValue(1) >= 1) //check mod is positive
        assertTrue(dh.getValue(2) >= 1) //check gen is positive

        for (i in 2 until dh.getValue(1)) {
            val a = i + 0.0
            assertTrue(dh.getValue(1) % a != 0.0)
        }

        for (i in 2 until dh.getValue(2)) {
            val a = i + 0.0
            assertTrue(dh.getValue(2) % a != 0.0)
        }
        assertTrue(dh.getValue(1)>dh.getValue(2))

    }

    @Test
    fun bitsTest() {
        assertEquals(18, dh.bits(1000000))
        assertEquals(4, dh.bits(60))
        assertEquals(3, dh.bits(30))
        assertEquals(2, dh.bits(8))
        assertEquals(0, dh.bits(3))
        assertEquals(58, dh.bits(1000000000000000000))
    }

}