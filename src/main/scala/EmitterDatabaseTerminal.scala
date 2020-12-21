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
  val testSecondfileReader = new CSVReader("EmitterDatabase2.csv")
  val testSecondfileSequence = testSecondfileReader.importDatabase()
  // Create a new processor object and pass it the sequence of threats in the constructor
  val dbProcessor = new EmitterDatabaseProcessor(threatSequence)
  dbProcessor.addRadarThreatSequence(testSecondfileSequence)
  // Call to a print method, used here for testing/logging purposes
  //dbProcessor.printContents()
  val testRadarThreat1 = new RadarThreat("testThreat1", "TestCountry1", false, 100, 200, 10000, 20000)
  dbProcessor.addRadarThreat(testRadarThreat1)
  dbProcessor.removeRadarThreat(testRadarThreat1)
  val testRadarThreat2 = new RadarThreat("testThreat2", "TestCountry2", false, 100, 200, 10000, 20000)
  val testThreatSequence: Seq[RadarThreat] = Seq(testRadarThreat1, testRadarThreat2)
  dbProcessor.addRadarThreatSequence(testThreatSequence)
  dbProcessor.removeRadarThreatSequence(testThreatSequence)
  dbProcessor.calculateHighestMinFreq()
  dbProcessor.calculateLowestMinFreq()
  dbProcessor.calculateHighestMaxFreq()
  dbProcessor.calculateLowestMaxFreq()
  dbProcessor.calculateLongestOpRange()
  dbProcessor.calculateHighestOpAltitude()
  dbProcessor.printContents()
}
