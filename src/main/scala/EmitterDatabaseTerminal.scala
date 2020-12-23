package csv
/** Emitter Database Terminal
 *  This entry point is a command line interface providing the user with a menu of options
 *  for creating and modifying Emitter/Radar Threat databases.  
 */
object EmitterDatabaseTerminal extends App {
  // Read in the file using the given input
  val fileName = scala.io.StdIn.readLine("Enter the filename of the initial emitter database:")
  var sourceReader = new CSVReader(fileName)
  // Grab the sequence of Threats from the file reader
  val threatSequence = sourceReader.importDatabase()
  //val testSecondfileReader = new CSVReader("EmitterDatabase2.csv")
  //val testSecondfileSequence = testSecondfileReader.importDatabase()
  // Create a new processor object and pass it the sequence of threats in the constructor
  val dbProcessor = new EmitterDatabaseProcessor(threatSequence)

  val testRadarThreat1 = new RadarThreat("testThreat1", "TestCountry1", false, 100, 200, 10000, 20000)
  // Now that the initial database is created and mapped we show the user a menu of options for 
  // manipulating the data. First create a flag for the while loop...
  var stillRunning = true
  while (stillRunning){
    println("")
    println("")
    println("1: Import additional csv database")
    println("2: Add a single Threat")
    println("3: Remove a single Threat")
    println("4: Run Basic Test Suite")
    println("5: Export Database")
    println("6: Exit")
    println("")
    println("")
    var userSelection = scala.io.StdIn.readLine("Please select an option from the menu above: ")
    userSelection match{
      case "1" => {
        val newFileName = scala.io.StdIn.readLine("Enter the filename of the additional emitter database to import:")
        val testSecondfileReader = new CSVReader(newFileName)
        val testSecondfileSequence = testSecondfileReader.importDatabase()
        dbProcessor.addRadarThreatSequence(testSecondfileSequence)
      }
      case "2" => {
        //val testRadarThreat1 = new RadarThreat("testThreat1", "TestCountry1", false, 100, 200, 10000, 20000)
        dbProcessor.addRadarThreat(testRadarThreat1)
      }
      case "3" => {
        val threatName = scala.io.StdIn.readLine("Enter the name of the radar threat to remove:")
        dbProcessor.removeRadarThreat(testRadarThreat1)
      }
      case "4" => {
        dbProcessor.calculateHighestMinFreq()
        dbProcessor.calculateLowestMinFreq()
        dbProcessor.calculateHighestMaxFreq()
        dbProcessor.calculateLowestMaxFreq()
        dbProcessor.calculateLongestOpRange()
        dbProcessor.calculateHighestOpAltitude()
        val newFileName = scala.io.StdIn.readLine("Press Enter To Return to Main Menu:")
      }
      case "5" => {
        dbProcessor.printContents()
        val newFileName = scala.io.StdIn.readLine("Press Enter To Return to Main Menu:")
      }
      case "6" => stillRunning = false
      case _ => println("other")
  }
}
  dbProcessor.printContents()
  val mongoDAO = new MongoTranslator("EmitterDatabase")

}
