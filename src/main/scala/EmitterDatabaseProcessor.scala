package csv

/** Emitter Database Processor
 *  This class is created using a sequence of RadarThreat object parsed from the corresponding 
 *  data file. Upon instantiation it is passed the sequence, converts it to a map which will 
 *  be used as the baseline for further data processing. 
 */
class EmitterDatabaseProcessor(val threatSequence: Seq[RadarThreat])
{
    def printContents()
    {
        threatSequence.foreach(println)
    }
}