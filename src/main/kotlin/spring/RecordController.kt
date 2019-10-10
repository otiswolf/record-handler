package spring

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import storage.Record
import storage.RecordStoreImpl

@RestController
class RecordController {

    val recordStore = RecordStoreImpl()

    @PostMapping("/records")
    fun postRecord(@RequestBody record: Record) {
        recordStore.addRecord(record)
    }

    @GetMapping("/records/gender")
    fun getRecords(): List<Record> {
        return recordStore.sortByGenderAndLastName()
    }

    @GetMapping("/records/birthdate")
    fun getBirthdate(): List<Record> {
        return recordStore.sortByGenderAndLastName()
    }

    @GetMapping("/records/lastname")
    fun getLastname(): List<Record> {
        return recordStore.sortByGenderAndLastName()
    }
}