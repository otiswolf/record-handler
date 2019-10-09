package storage

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDate

internal class RecordStoreImplTest {

    val record1 = Record("Wolf", "Otis", "Male", "Green", LocalDate.parse("1996-11-07"))
    val record2 = Record("Scott", "Ellie", "Female", "Yellow", LocalDate.parse("1980-10-13"))
    val record3 = Record("Warren", "Mike", "Male", "Red", LocalDate.parse("1989-05-22"))


    @Test
    fun `test addRecord adds a record`() {
        val recordStoreImpl = RecordStoreImpl()

        recordStoreImpl.addRecord(record1)
        assertEquals(mutableListOf(record1), recordStoreImpl.records)
    }

    @Test
    fun `test sortByGenderAndLastName sorts by gender (M before F) and last name ascending`() {
        val recordStoreImpl= RecordStoreImpl()
        recordStoreImpl.addRecord(record1)
        recordStoreImpl.addRecord(record2)
        recordStoreImpl.addRecord(record3)

        val testResults = recordStoreImpl.sortByGenderAndLastName()
        assertEquals(mutableListOf(record2, record3, record1), testResults)
    }

    @Test
    fun `test sortByBirthday sorts records by birthday in ascending order`() {
        val recordStoreImpl= RecordStoreImpl()
        recordStoreImpl.addRecord(record1)
        recordStoreImpl.addRecord(record2)
        recordStoreImpl.addRecord(record3)

        val testResults = recordStoreImpl.sortByBirthday()
        assertEquals(mutableListOf(record2, record3, record1), testResults)
    }

    @Test
    fun `test sortByLastname sorts records by last name in descending order`() {
        val recordStoreImpl= RecordStoreImpl()
        recordStoreImpl.addRecord(record1)
        recordStoreImpl.addRecord(record2)
        recordStoreImpl.addRecord(record3)

        val testResults = recordStoreImpl.sortByLastname()
        assertEquals(mutableListOf(record1, record3, record2), testResults)

    }
}
