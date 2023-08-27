package main.scala.chapter3

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions.{col, expr}

object Example3_7 {
  def main(args: Array[String]) {

    val spark = SparkSession
      .builder
      .appName("Example-3_7")
      .getOrCreate()

    if (args.length <= 0) {
      println("usage Example3_7 <file path to blogs.json")
      System.exit(1)
    }

    val jsonFile = args(0)

    val schema = StructType(Array(StructField("Id", IntegerType, false),
      StructField("First", StringType, false),
      StructField("Last", StringType, false),
      StructField("Url", StringType, false),
      StructField("Published", StringType, false),
      StructField("Hits", IntegerType, false),
      StructField("Campaigns", ArrayType(StringType), false)))

    val blogsDF = spark.read.schema(schema).json(jsonFile)
    
    blogsDF.show(truncate = false)
    println(blogsDF.printSchema)
    println(blogsDF.schema)

    blogsDF.select(expr("Hits") * 2).show(2)
    blogsDF.select(col("Hits") * 2).show(2)
    blogsDF.select(expr("Hits * 2")).show(2)
    blogsDF.withColumn("Big Hitters", (expr("Hits > 10000"))).show()
  }
}
