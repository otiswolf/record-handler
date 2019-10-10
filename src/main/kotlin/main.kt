import org.springframework.boot.SpringApplication
import parse.CommaParser
import parse.PipeParser
import parse.SpaceParser
import spring.SpringApp
import storage.RecordStoreImpl
import java.io.File

fun main(args: Array<String>) {
    when (args[0]) {
        "step1" -> step1(args.sliceArray(1..4))
        "step2" -> step2()
        else -> println("Please enter a valid step to run")
    }
}

fun step1(args: Array<String>) {

    //check that display mode is valid
    val displayMode = args[0]
    if (!(displayMode.toLowerCase() == "gender" || displayMode.toLowerCase() == "birthday" || displayMode.toLowerCase() == "lastname")) {
        print("please enter a valid display mode")
        return
    }
    print("System running in $displayMode mode\n\n")

    //read input files, convert lines to Records, and add records to storage
    val recordStore = RecordStoreImpl()
    for(i in 1..3) {
        //read input file
        val data = File(args[i]).readLines()

        //check input format, convert to Records and add to storage
        when {
            PipeParser.canParse(data[0]) -> data.forEach {
                recordStore.addRecord(PipeParser.parseLine(it))
            }
            CommaParser.canParse(data[0]) -> data.forEach {
                recordStore.addRecord(CommaParser.parseLine(it))
            }
            SpaceParser.canParse(data[0]) -> data.forEach {
                recordStore.addRecord(SpaceParser.parseLine(it))
            }
        }
    }

    //display data to screen in requested format
    when (displayMode.toLowerCase()) {
        "gender" -> recordStore.sortByGenderAndLastName().forEach {
            println(it)
        }
        "birthday" -> recordStore.sortByBirthday().forEach {
            println(it)
        }
        "lastname" -> recordStore.sortByLastname().forEach {
            println(it)
        }

    }
}

fun step2() {
    SpringApplication.run(SpringApp::class.java)
}