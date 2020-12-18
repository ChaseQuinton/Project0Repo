package csv

/** Emitter Database Processor
 *  This class is created using a sequence of RadarThreat object parsed from the corresponding 
 *  data file. Upon instantiation it is passed the sequence, converts it to a map which will 
 *  be used as the baseline for further data processing. 
 */
class EmitterDatabaseProcessor(val threatSequence: Seq[RadarThreat])
{
    // Create a map object to transfer and store the sequence of threats into a more robust structure
    // The Keys will be Strings which correspond to the threat's name
    // The Values will be references to the RadarThreat Objects themselves
    var radarThreatMap: Map[String, RadarThreat] = threatSequence.map(RadarThreat => (RadarThreat.threatName, RadarThreat)).toMap
    // A function to loop through the sequence of RadarThreat objects and print them to the console for testing purposes
    def printContents()
    {
        //threatSequence.foreach(println)
        radarThreatMap.foreach(println)
    }
}