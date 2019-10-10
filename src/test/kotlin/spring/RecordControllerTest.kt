package spring

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import storage.Record
import java.time.LocalDate

internal class RecordControllerTest {
    val commaRecord = Record("Redding", "Otis", "Male", "Blue", LocalDate.parse("1941-09-09"))
    val commaRecordString = "Redding, Otis, Male, Blue, 09-09-1941"
    val pipeRecord = Record("Timberlake", "Justin", "Male", "Gold", LocalDate.parse("1981-01-31"))
    val pipeRecordString = "Timberlake | Justin | Male | Gold | 01-31-1981"
    val spaceRecord = Record("Streep", "Meryl", "Female", "Red", LocalDate.parse("1949-06-22"))
    val spaceRecordString = "Streep Meryl Female Red 06-22-1949"

    @Test
    fun `test postRecord successfully posts a record`() {
        val recordController = RecordController()
        val records = recordController.recordStore.records

        recordController.postRecord(commaRecordString)
        recordController.postRecord(pipeRecordString)
        recordController.postRecord(spaceRecordString)

        assertTrue(records.contains(commaRecord))
        assertTrue(records.contains(pipeRecord))
        assertTrue(records.contains(spaceRecord))

    }

    @Test
    fun `test getByGender returns records ordered by gender`() {
        val recordController = RecordController()
        val records = recordController.recordStore.records

        recordController.postRecord(commaRecordString)
        recordController.postRecord(pipeRecordString)
        recordController.postRecord(spaceRecordString)

        val testResults = recordController.getByGender()
        assertEquals(listOf(spaceRecord, commaRecord, pipeRecord), testResults)
    }

    @Test
    fun `test getByBirthday returns records ordered by gender`() {
        val recordController = RecordController()
        val records = recordController.recordStore.records

        recordController.postRecord(commaRecordString)
        recordController.postRecord(pipeRecordString)
        recordController.postRecord(spaceRecordString)

        val testResults = recordController.getByBirthday()
        assertEquals(listOf(commaRecord, spaceRecord, pipeRecord), testResults)
    }


    @Test
    fun `test getByLastname returns records ordered by gender`() {
        val recordController = RecordController()
        val records = recordController.recordStore.records

        recordController.postRecord(commaRecordString)
        recordController.postRecord(pipeRecordString)
        recordController.postRecord(spaceRecordString)

        val testResults = recordController.getByLastname()
        assertEquals(listOf(pipeRecord, spaceRecord, commaRecord), testResults)
    }


}