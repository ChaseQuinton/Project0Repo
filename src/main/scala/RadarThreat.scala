package csv
/** RadarThreat
 *  This class defines and encapsulates all of the parameters associated with a single
 *  individual radar threat. These include the threat/Radar technology's name country of origin, 
 *  the minimum and maximum operational frequencies, a flag indicating whether the threat has 
 *  missile guidance systems (and could therefore be tracking), the operating range of the threat
 *  as a scalar radial distance from the source.
 *  @param threatName A string representing the threat/Radar Technology's name
 *  @param country A string representing the nation of origin 
 *  @param missileGuidance A boolean flag indicating if the threat has missile guidance capability
 *  @param minFreq An integer representing the minimum frequency of operation (in Hertz)
 *  @param maxFreq An integer representing the maximum frequency of operation (in Hertz)
 *  @param opRange An integer representing the operating range of the threat as a scalar radial distance from the source (in meters)
 *  @param opAlt An integer representing the maximum altitude the threat is capable of operating at (in meters)
 */
case class RadarThreat(
    val threatName: String,
    val country: String,
    val missileGuidance: Boolean,
    val minFreq: Int,
    val maxFreq: Int,
    val opRange: Int,
    val opAlt: Int) {}
