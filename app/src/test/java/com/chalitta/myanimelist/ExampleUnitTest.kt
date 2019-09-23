package com.chalitta.myanimelist

import com.chalitta.myanimelist.activity.MainActivity
import com.chalitta.myanimelist.viewmodel.AnimeViewModel
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun checkString_null(){
        val result = MainActivity().checkString(null)
        assertEquals(false, result)

    }

    @Test
    fun checkString_text_less_5(){
        val result = MainActivity().checkString("text")
        assertEquals(false, result)

    }

    @Test
    fun checkString_text_equal_5(){
        val result = MainActivity().checkString("minto")
        assertEquals(false, result)

    }

    @Test
    fun checkString_text_more_5(){
        val result = MainActivity().checkString("chalitta")
        assertEquals(true, result)

    }
}
