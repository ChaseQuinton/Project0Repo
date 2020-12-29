package csv

import org.mongodb.scala.MongoClient
import org.mongodb.scala.MongoCollection
import org.bson.codecs.configuration.CodecRegistries.{fromProviders, fromRegistries}
import org.mongodb.scala.bson.codecs.Macros._
import scala.concurrent.Await
import org.mongodb.scala.Observable
import scala.concurrent.duration.{Duration, SECONDS}
import org.mongodb.scala.model.Filters.equal

class EmitterDao(mongoClient: MongoClient){
    val codecRegistry = fromRegistries(
        fromProviders(classOf[RadarThreat]), 
        MongoClient.DEFAULT_CODEC_REGISTRY
    )
    val db = mongoClient.getDatabase("EmitterDatabase").withCodecRegistry(codecRegistry)
    val collection: MongoCollection[RadarThreat] = db.getCollection("RadarThreats")

    private def getResults[T](obs: Observable[T]): Seq[T] = {
        Await.result(obs.toFuture(), Duration(10, SECONDS))
    }

    def getAll(): Seq[RadarThreat] = getResults(collection.find())

    def getByName(threatName: String): Seq[RadarThreat] = {
        getResults(collection.find(equal("Threat Name", threatName)))
    }
}