// Create cubed function
val cubed = (s: Long) => { s * s * s }

// Register UDF
spark.udf.register("cubed", cubed)

// Create temporary view
spark.range(1, 9).createOrReplaceTempView("udf_test")

