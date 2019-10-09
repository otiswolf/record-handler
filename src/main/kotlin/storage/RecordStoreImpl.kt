package storage

class RecordStoreImpl: RecordStore {
    override val records = mutableListOf<Record>()

    override fun addRecord(record: Record) {
        records.add(record)
    }

    override fun sortByGenderAndLastName(): List<Record> {
        records.sortWith(compareBy({it.Gender}, {it.LastName}))
        return records
    }

    override fun sotrByBirthday(): List<Record> {
        records.sortBy {it.DateOfBirth}
        return records
    }

    override fun sortByLastname(): List<Record> {
        records.sortBy {it.LastName}
        return records
    }
}