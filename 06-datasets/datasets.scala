case class Bloggers(id:BigInt, first:String, last:String, url:String, published:String, hits: BigInt, campaigns:Array[String])

val bloggers = "data/blogs.json"

val bloggersDS = spark.read.format("json").option("path", bloggers).load().as[Bloggers]

// -----------------------

import scala.util.Random._
// Our case class for the Dataset
case class Usage(uid:Int, uname:String, usage: Int)

val r = new scala.util.Random(42)

// Create X instances of scala Usage class
// This generates data on the fly
val data = for (i <- 0 to 100)
 yield (Usage(i, "user-" + r.alphanumeric.take(5).mkString(""),
 r.nextInt(1000)))

// Create a Dataset of Usage typed data
val dsUsage = spark.createDataset(data)
dsUsage.show(10)
