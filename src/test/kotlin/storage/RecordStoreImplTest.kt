package storage

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.util.*

internal class RecordStoreImplTest {

    val record1 = Record("Wolf", "Otis", "Male", "Green", LocalDate.parse("1996-11-07"))

    @Test
    fun `test addRecord adds a record`() {
        val recordStoreImpl = RecordStoreImpl()

        recordStoreImpl.addRecord(record1)
        assertEquals(mutableListOf(record1), recordStoreImpl.records)
    }
}
