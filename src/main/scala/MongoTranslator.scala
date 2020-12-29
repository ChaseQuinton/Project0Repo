package csv
import org.mongodb.scala._
import org.mongodb.scala.model.Aggregates._
import org.mongodb.scala.model.Filters._
import org.mongodb.scala.model.Projections._
import org.mongodb.scala.model.Sorts._
import org.mongodb.scala.model.Updates._
import org.mongodb.scala.model._
import org.mongodb.scala.bson.codecs.Macros._
import org.mongodb.scala.bson.BsonObjectId
import org.mongodb.scala.MongoClient
import org.bson.codecs.configuration.CodecRegistries.{fromProviders, fromRegistries}
import org.mongodb.scala.MongoCollection
import scala.concurrent.Await
import org.mongodb.scala.Observable
import scala.concurrent.duration.{Duration, SECONDS}
import org.mongodb.scala.model.Filters.equal
//import javax.swing.text.Document
import scala.collection.JavaConverters._
import org.mongodb.scala.bson.collection.immutable.Document
import java.util.concurrent.TimeUnit
//import com.mongodb.casbah.Imports._
import tour.Helpers._

/** MongoTranslator
 *  This class is used to communicate with the Emitter Database Processor and translate
 * the contents of the map to mongo db  
 */
class MongoTranslator(val databaseName: String) {
    val mongoClient: MongoClient = MongoClient()
    val database: MongoDatabase = mongoClient.getDatabase(databaseName)
    val collection: MongoCollection[Document] = database.getCollection("RadarThreats")
    //collection.results
    val res = collection.find().toFuture()
    Await.result(res, Duration(10, TimeUnit.SECONDS)).foreach(println)
    val doc: Document = Document("Threat Name" -> "TestThreat", "country" -> "TestCountry")
    //Await.result(res.insertOne(doc), Duration(10, TimeUnit.SECONDS))
    collection.insertOne(doc)
}
