package csv

/** CSVReader
 *  This entry point will allow for user input of a CSV file containing the information
 *  for an emitter/threat database. The data will be parsed and each line converted to
 *  an instance of the Emitter class. Finally the emitters will be aggregated in a map
 *  where the key is the country of origin and the value is an instance of the Emitter 
 *  class.
 */
object CSVReader extends App {
  println("Enter the filename of the emitter database:")
  val file = io.Source.fromFile("people.csv")
  for (line <- file.getLines) {
    println(line)
  }
}