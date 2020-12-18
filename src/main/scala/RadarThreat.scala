package csv
/** RadarThreat
 *  This class defines and encapsulates all of the parameters associated with a single
 *  individual radar threat. These include the threat/Radar technology's name country of origin, 
 *  the minimum and maximum operational frequencies, a flag indicating whether the threat has 
 *  missile guidance systems (and could therefore be tracking), the operating range of the threat
 *  as a scalar radial distance from the source.
 */
case class RadarThreat(
    val threatName: String,
    val country: String,
    val missileGuidance: Boolean,
    val minFreq: Int,
    val maxFreq: Int,
    val opRange: Int) {
  
}
