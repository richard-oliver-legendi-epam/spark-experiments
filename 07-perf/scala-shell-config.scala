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



// Create a DataFrame with 10M records
val df = spark.range(1 * 10000000).toDF("id").withColumn("square", $"id" * $"id")
df.cache() // Cache the data
df.count() // Materialize the cache

df.count() // Now get it from the cache


// --------------------------

import org.apache.spark.storage.StorageLevel

// Create a DataFrame with 10M records
val df = spark.range(1 * 10000000).toDF("id").withColumn("square", $"id" * $"id")
df.persist(StorageLevel.DISK_ONLY) // Serialize the data and cache it on disk
df.count() // Materialize the cache

df.count() // Now get it from the cache


