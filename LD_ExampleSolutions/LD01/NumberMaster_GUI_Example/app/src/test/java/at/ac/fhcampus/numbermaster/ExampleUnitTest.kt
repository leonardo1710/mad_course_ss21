package at.ac.fhcampus.numbermaster

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun numberMasterTest(){
        val m = MainActivity()
        var actual = m.addGuessToListForTesting("2203", "2230")
        var expected = "AABB"
        assertEquals(expected,actual)
    }
}
