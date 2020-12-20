package csv

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
