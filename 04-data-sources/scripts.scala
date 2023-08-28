// In Scala
import org.apache.spark.sql.SparkSession
val spark = SparkSession
 .builder
 .appName("SparkSQLExampleApp")
 .getOrCreate()

// Path to data set
val csvFile="data/departuredelays.csv"

// Read and create a temporary view
// Infer schema (note that for larger files you may want to specify the schema)
val df = spark.read.format("csv").option("inferSchema", "true").option("header", "true").load(csvFile)

// Create a temporary view
df.createOrReplaceTempView("us_delay_flights_tbl")


// ----------------------

// In Scala
val schema = "date STRING, delay INT, distance INT, origin STRING, destination STRING"

val df = spark.read.format("csv").option("header", "true").schema(schema).load(csvFile)

spark.sql("""SELECT distance, origin, destination FROM us_delay_flights_tbl WHERE distance > 1000 ORDER BY distance DESC""").show(10)

// Rewritten with DataFrame
// NOTE orderBy is descending by default, otherwise we can use sort(desc("distance))

df.select("distance", "origin", "destination").where("distance > 1000").orderBy("distance").show(10)
df.select("distance", "origin", "destination").where("distance > 1000").sort(desc("distance")).show(10)
df.select("distance", "origin", "destination").where("distance > 1000").sort("distance").show(10)

spark.sql("""SELECT date, delay, origin, destination FROM us_delay_flights_tbl WHERE delay > 120 AND ORIGIN = 'SFO' AND DESTINATION = 'ORD' ORDER by delay DESC""").show(10)

spark.sql("""SELECT delay, origin, destination,
 | CASE
 |   WHEN delay > 360 THEN 'Very Long Delays'
 |   WHEN delay > 120 AND delay < 360 THEN 'Long Delays'
 |   WHEN delay > 60 AND delay < 120 THEN 'Short Delays'
 |   WHEN delay > 0 and delay < 60 THEN 'Tolerable Delays'
 |   WHEN delay = 0 THEN 'No Delays'
 |   ELSE 'Early'
 | END AS Flight_Delays
 | FROM us_delay_flights_tbl
 | ORDER BY origin, delay DESC""").show(10)

// As an exercise, try converting the other two SQL queries to use the DataFrame API.

spark.sql("CREATE DATABASE learn_spark_db")
spark.sql("USE learn_spark_db")

spark.sql("CREATE TABLE managed_us_delay_flights_tbl (date STRING, delay INT, distance INT, origin STRING, destination STRING)")

spark.sql("""CREATE TABLE us_delay_flights_tbl(date STRING, delay INT, distance INT, origin STRING, destination STRING) USING csv OPTIONS (PATH '/data/departuredelays.csv')""")

spark.sql("""SELECT distance, origin, destination FROM us_delay_flights_tbl WHERE distance > 1000 ORDER BY distance DESC""").createOrReplaceTempView("long_flights")

spark.sql("""SELECT distance, origin, destination FROM us_delay_flights_tbl WHERE distance > 1000 ORDER BY distance DESC""").createOrReplaceGlobalTempView("long_flights")

spark.sql("""SELECT * FROM long_flights""").show(10)


spark.sql("""SELECT distance, origin, destination FROM us_delay_flights_tbl WHERE distance > 5000 ORDER BY distance DESC""").createOrReplaceGlobalTem
pView("longer_flights")

spark.sql("""SELECT * FROM longer_flights""").show(10)

// Global temp view was not found for whatever reason...

spark.catalog.dropGlobalTempView("longer_flights")
spark.catalog.dropTempView("longer_flights")
spark.catalog.dropTempView("long_flights")
