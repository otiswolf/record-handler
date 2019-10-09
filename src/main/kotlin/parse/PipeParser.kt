package parse

import storage.Record
import exceptions.RecordParseException
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class PipeParser {

    companion object: Parser {

        override fun canParse(line: String): Boolean {
            return line.contains("|")
        }

        override fun parseLine(line: String): Record {
            try {
                //capture values in between delimiters
                var recordValues = line.split("|")

                //trim whitespace from values
                recordValues = recordValues.map {it.trim()}

                //set format for parsing date
                var formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy")

                return Record(
                    recordValues[0],
                    recordValues[1],
                    recordValues[2],
                    recordValues[3],
                    LocalDate.parse(recordValues[4], formatter)
                )
            } catch(e: Exception) {
                throw RecordParseException()
            }
        }
    }
}