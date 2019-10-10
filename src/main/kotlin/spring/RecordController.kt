package spring

import exceptions.RecordParseException
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import parse.CommaParser
import parse.PipeParser
import parse.SpaceParser
import storage.Record
import storage.RecordStoreImpl

@RestController
class RecordController {

    val recordStore = RecordStoreImpl()

    @PostMapping("/records")
    fun postRecord(@RequestBody recordString: String) {
        println("attempting to parse: $recordString")

        when {
            PipeParser.canParse(recordString) -> recordStore.addRecord(PipeParser.parseLine(recordString))
            CommaParser.canParse(recordString) -> recordStore.addRecord(CommaParser.parseLine(recordString))
            SpaceParser.canParse(recordString) -> recordStore.addRecord(SpaceParser.parseLine(recordString))
            else -> throw RecordParseException()
        }
    }

    @GetMapping("/records/gender")
    fun getByGender(): List<Record> {
        return recordStore.sortByGenderAndLastName()
    }

    @GetMapping("/records/birthdate")
    fun getByBirthday(): List<Record> {
        return recordStore.sortByBirthday()
    }

    @GetMapping("/records/name")
    fun getByLastname(): List<Record> {
        return recordStore.sortByLastname()
    }
}