val mconf = spark.conf.getAll

for (k <- mconf.keySet) { println(s"${k} -> ${mconf(k)}\n") }

spark.sql("SET -v").select("key", "value").show(5, false)




scala> spark.conf.get("spark.sql.shuffle.partitions")
res33: String = 200

scala> spark.conf.set("spark.sql.shuffle.partitions", 100)

scala> spark.conf.get("spark.sql.shuffle.partitions")
res35: String = 100

scala>


val numDF = spark.range(1000)
numDF: org.apache.spark.sql.Dataset[Long] = [id: bigint]

scala> numDF.rdd.getNumPartitions
res1: Int = 8

val numDF = spark.range(1000).repartition(16)
numDF.rdd.getNumPartitions


