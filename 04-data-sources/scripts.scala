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
