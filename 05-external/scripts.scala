// Create cubed function
val cubed = (s: Long) => { s * s * s }

val cubedWithNull : Long => String = (s: Long) => { if (s == 3) null else "Pompli_" + s }

// Register UDF
spark.udf.register("cubed", cubed)

// Create temporary view
spark.range(1, 9).createOrReplaceTempView("udf_test")

// In Scala/Python
// Query the cubed UDF
spark.sql("SELECT id, cubed(id) AS id_cubed FROM udf_test").show()


List(1l,2l,3l,4l).foreach(x => println(cubedWithNull(x)))

spark.udf.register("cubedWithNull", cubedWithNull)

spark.sql("SELECT id, cubedWithNull(id) AS id_cubed FROM udf_test").show()

spark.sql("SELECT id, cubedWithNull(id) AS id_cubed FROM udf_test").createOrReplaceTempView("udf_test2")

spark.sql("SELECT id, cubedWithNull(id) AS id_cubed FROM udf_test2").show()

spark.sql("SELECT id, cubedWithNull(id) FROM udf_test2 WHERE cubedWithNull(id) IS NOT NULL AND length(cubedWithNull(id)) > 1")
 