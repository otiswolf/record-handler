package parse

import storage.Record
import exceptions.RecordParseException

class SpaceParser {

    companion object: Parser {

        override fun canParse(line: String): Boolean {
            return line.contains(" ")
        }

        override fun parseLine(line: String): Record {
            try {
                //capture values in between delimiters
                val recordValues = line.split(" ")

                return Record(
                    recordValues[0],
                    recordValues[1],
                    recordValues[2],
                    recordValues[3],
                    recordValues[4]
                )
            } catch(e: Exception) {
                throw RecordParseException()
            }
        }
    }
}