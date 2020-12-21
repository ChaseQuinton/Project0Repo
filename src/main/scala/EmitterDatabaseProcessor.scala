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
    /**
     * A function to loop through the map of RadarThreat objects and print them to the console for testing purposes
     */
    def printContents()
    {
        radarThreatMap.foreach(println)
    }
    /**
     * A function to add a single new Radar Threat Object to the database (The class instance of the map)
     */
    def addRadarThreat(newRadarThreat: RadarThreat): Unit = {
        radarThreatMap += (newRadarThreat.threatName -> newRadarThreat)
    }
    /**
     * A function to remove a single Radar Threat Object from the database (The class instance of the map)
     */
    def removeRadarThreat(targetRadarThreat: RadarThreat): Unit = {
        radarThreatMap -= targetRadarThreat.threatName
    }
    /**
     * A function to add a sequence of new Radar Threat Objects to the database (The class instance of the map)
     */
    def addRadarThreatSequence(targetThreatSeq: Seq[RadarThreat]): Unit = {
       radarThreatMap ++= targetThreatSeq.map(RadarThreat => (RadarThreat.threatName, RadarThreat)).toMap
    }
    /**
     * A function to remove a sequence of Radar Threat Object from the database (The class instance of the map)
     */
    def removeRadarThreatSequence(targetThreatSeq: Seq[RadarThreat]): Unit = {
        //radarThreatMap -= targetThreatSeq.map(RadarThreat => (RadarThreat.threatName, RadarThreat)).toMap
    }
    /**
      * A method to search the threat database comparing the minimum frequencies range 
      * values to find the lowest
      * @return the lowest manimum frequency as an Integer
      */
    def calculateLowestMinFreq(): Integer = {
        // Start a running record of the lowest min frequency by starting with a high value
        var lowestMinFreq = Integer.MAX_VALUE
        // Loop through the values (RadarThreats) in the map and determine the Lowest Min Frequency 
        radarThreatMap.values.foreach{x => if(x.minFreq < lowestMinFreq) lowestMinFreq = x.minFreq}
        // Print to console the calculated frequency
        println("The lowest calculated minimum operating frequency of any threat is: ")
        println(lowestMinFreq)
        return lowestMinFreq
    }
    /**
      * A method to search the threat database comparing the minimum frequencies to find the Highest
      * @return the highest minimum frequency as an Integer
      */
    def calculateHighestMinFreq(): Integer = {
        // Start a running record of the lowest min frequency by starting with a high value
        var highestMinFreq = 0
        // Loop through the values (RadarThreats) in the map and determine the Highest Min Frequency 
        radarThreatMap.values.foreach{x => if(x.minFreq > highestMinFreq) highestMinFreq = x.minFreq}
        // Print to console the calculated frequency
        println("The highest calculated minimum operating frequency of any threat is: ")
        println(highestMinFreq)
        return highestMinFreq
    }
    /**
      * A method to search the threat database comparing the maximum frequencies to find the highest
      *
      * @return the highest maximum frequency as an Integer
      */
    def calculateHighestMaxFreq(): Integer = {
        // Start a running record of the highest max frequency by starting with zero
        var highestMaxFreq = 0
        // Loop through the values (RadarThreats) in the map and determine the Highest Max Frequency 
        radarThreatMap.values.foreach{x => if(x.maxFreq > highestMaxFreq) highestMaxFreq = x.maxFreq}
        // Print to console the calculated frequency
        println("The highest calculated maximum operating frequency of any threat is: ")
        println(highestMaxFreq)
        return highestMaxFreq
    }
    /**
      * A method to search the threat database comparing the maximum frequencies to find the lowest
      * @return the lowest maximum frequency range value as an Integer
      */
     def calculateLowestMaxFreq(): Integer = {
        // Start a running record of the lowest max frequency by starting with a huge value
        var lowestMaxFreq = Integer.MAX_VALUE
        // Loop through the values (RadarThreats) in the map and determine the Highest Max Frequency 
        radarThreatMap.values.foreach{x => if(x.maxFreq < lowestMaxFreq) lowestMaxFreq = x.maxFreq}
        // Print to console the calculated frequency
        println("The lowest calculated maximum operating frequency of any threat is: ")
        println(lowestMaxFreq)
        return lowestMaxFreq
    }
    /**
      * A method to search the threat database comparing the operating range 
      * values to find the longest (radial distance from emitter source in meters)
      * @return the farthest operating range (radial distance from emitter source in meters) as an integer
      */
    def calculateLongestOpRange(): Integer = {
        // Start a running record of the longest operating range by starting with zero
        var longestOpRange = 0
        // Loop through the values (RadarThreats) in the map and determine the lowest op Range
        radarThreatMap.values.foreach{x => if(x.opRange > longestOpRange) longestOpRange = x.opRange}
        // Print to console 
        println("The longest calculated operating range of any threat is: ")
        println(longestOpRange)
        return longestOpRange
    }
    /**
      * A method to search the threat database comparing the operating altitude 
      * values to find the highest 
      * @return an integer, the highest operating altitude in meters
      */
    def calculateHighestOpAltitude(): Integer = {
        // Start a running record of the longest operating range by starting with zero
        var highestOpAlt = 0
        // Loop through the values (RadarThreats) in the map and determine the lowest op Range
        radarThreatMap.values.foreach{x => if(x.opAlt > highestOpAlt) highestOpAlt = x.opRange}
        // Print to console 
        println("The highest calculated operating altitude of any threat is: ")
        println(highestOpAlt)
        return highestOpAlt
    }
}