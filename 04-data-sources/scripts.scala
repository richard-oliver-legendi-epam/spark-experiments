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
