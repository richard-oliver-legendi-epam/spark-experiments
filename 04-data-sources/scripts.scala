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
