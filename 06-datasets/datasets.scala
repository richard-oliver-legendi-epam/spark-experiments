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


import org.apache.spark.sql.functions._
dsUsage
 .filter(d => d.usage > 900)
 .orderBy(desc("usage"))
 .show(5, false)


// Use an if-then-else lambda expression and compute a value
dsUsage.map(u => {if (u.usage > 750) u.usage * .15 else u.usage * .50 }).show(5, false)

// Define a function to compute the usage
Working with Datasets | 163
def computeCostUsage(usage: Int): Double = {
 if (usage > 750) usage * 0.15 else usage * 0.50
}

// Use the function as an argument to map()
dsUsage.map(u => {computeCostUsage(u.usage)}).show(5, false)



// Create a new case class with an additional field, cost
case class UsageCost(uid: Int, uname:String, usage: Int, cost: Double)

// Compute the usage cost with Usage as a parameter
// Return a new object, UsageCost
def computeUserCostUsage(u: Usage): UsageCost = {
 val v = if (u.usage > 750) u.usage * 0.15 else u.usage * 0.50
 UsageCost(u.uid, u.uname, u.usage, v)
}

// Use map() on our original Dataset
dsUsage.map(u => {computeUserCostUsage(u)}).show(5)



val bloggersDS = spark.read.format("json").option("path", "data/blogs.json").load().as[Bloggers]

bloggersDS.show(5)


import java.util.Calendar
val earliestYear = Calendar.getInstance.get(Calendar.YEAR) - 40
personDS
 // Everyone above 40: lambda-1
 .filter(x => x.birthDate.split("-")(0).toInt > earliestYear)

 // Everyone earning more than 80K
 .filter($"salary" > 80000)

 // Last name starts with J: lambda-2
 .filter(x => x.lastName.startsWith("J"))

 // First name starts with D
 .filter($"firstName".startsWith("D"))
 .count()


// Quick version with DSL - avoids serializatoin
personDS
 .filter(year($"birthDate") > earliestYear) // Everyone above 40
 .filter($"salary" > 80000) // Everyone earning more than 80K
 .filter($"lastName".startsWith("J")) // Last name starts with J
 .filter($"firstName".startsWith("D")) // First name starts with D
 .count()


