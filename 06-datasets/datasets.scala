case class Bloggers(id:BigInt, first:String, last:String, url:String, published:String, hits: BigInt, campaigns:Array[String])

val bloggers = "data/blogs.json"

val bloggersDS = spark.read.format("json").option("path", bloggers).load().as[Bloggers]
