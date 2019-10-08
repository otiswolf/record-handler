package storage

class RecordStoreImpl: RecordStore {
    override val records = mutableListOf<Record>()

    override fun addRecord(record: Record) {
        records.add(record)
    }

    override fun sortByGenderAndLastName(): List<Record> {
//        records.sortWith(compareBy({it.Gender}, {it.LastName}))
//        return records
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sotrByBirthday(): List<Record> {
//        records.sortBy {it.DateOfBirth}
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sortByLastname(): List<Record> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}