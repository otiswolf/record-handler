package storage

import storage.Record

interface RecordStore {
    val records: List<Record>

    fun addRecord(record: Record): Unit

    fun sortByGenderAndLastName(): List<Record>

    fun sortByBirthday(): List<Record>

    fun sortByLastname(): List<Record>
}