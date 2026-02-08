package cn.vove7.andro_accessibility_api.utils

import org.junit.Assert.assertEquals
import org.junit.Test

class ResultBoxTest {
    @Test
    fun setAndNotify_releasesLatchAndReturnsValue() {
        val box = ResultBox<String>()

        box.setAndNotify("done")

        assertEquals(0, box.lock.count)
        assertEquals("done", box.blockedGet())
    }

    @Test
    fun blockedGet_returnsValueWithoutThrowingWhenAlreadySet() {
        val box = ResultBox(42)

        box.setAndNotify(7)

        assertEquals(7, box.blockedGet(safely = false))
    }
}
