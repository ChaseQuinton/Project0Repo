package csv

/** CSVReader
 *  This entry point will allow for user input of a CSV file containing the information
 *  for an emitter/threat database. The data will be parsed and each line converted to
 *  an instance of the Emitter class. Finally the emitters will be aggregated in a map
 *  where the key is the threat name and the value is an instance of the RadarThreat 
 *  class.
 */
object CSVReaderTest extends App {
  // Read in the file using the given input
  val fileName = scala.io.StdIn.readLine("Enter the filename of the emitter database:")
  val sourceReader = new CSVReader(fileName)
  // Grab the sequence of Threats from the file reader
  val threatSequence = sourceReader.importDatabase()
  // Test print of the sequence of Threats
  //threatSequence.foreach(println)
  // Create a new processor object and pass it the sequence of threats in the constructor
  val dbProcessor = new EmitterDatabaseProcessor(threatSequence)
  // Call to a print method, used here for testing/logging purposes
  dbProcessor.printContents()
}

/**
  * Trait for importing the emitter database as a CSV file. Have a sequence
  * of RadarThreat objects returned rather than only strings. 
  */
trait CSVFileReader {
  /**
    * @return Returns a sequence of RadarThreat objects
    */
  def importDatabase(): Seq[RadarThreat]
}

/** CSVReader
  * Implementation of [[CSVFileReader]] responsible for parsing the threat 
  * database from a source file.
  * @param fileName the name of the file containing the threat database information in CSV format
  */
class CSVReader(val fileName: String) extends CSVFileReader{
  
  // Override the function inherited from the CSVFileReader trait
  override def importDatabase(): Seq[RadarThreat] = {
    // Grab the file, returns a Buffered Source
    val file = io.Source.fromFile(fileName)
    // loop through the source file and convert each line to a collection/sequence of RadarThreat objects
    for {
      line <- file.getLines().toVector
      values = line.split(",").map(_.trim)
      // Return the values parsed in as parameters to the RadarThreat class constructor
      // Convert strings as necessary into the proper data type for each parameter
      // as defined in the RadarThreat class
      //values.foreach(println)
    } yield RadarThreat(values(0), values(1), values(2).toBoolean, values(3).toInt, values(4).toInt, values(5).toInt, values(6).toInt)
  }
}
