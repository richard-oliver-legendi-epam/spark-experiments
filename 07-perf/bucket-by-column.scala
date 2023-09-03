import org.apache.spark.sql.functions._
import org.apache.spark.sql.SaveMode

// Save as managed tables by bucketing them in Parquet format
usersDF.orderBy(asc("uid")).write.format("parquet").bucketBy(8, "uid").saveAsTable("UsersTbl")

ordersDF.orderBy(asc("users_id")).write.format("parquet").bucketBy(8, "users_id").saveAsTable("OrdersTbl")

// Cache the tables
//spark.sql("CACHE TABLE UsersTbl")
//spark.sql("CACHE TABLE OrdersTbl")

// Read them back in
val usersBucketDF = spark.table("UsersTbl")
val ordersBucketDF = spark.table("OrdersTbl")

// Do the join and show the results
val joinUsersOrdersBucketDF = ordersBucketDF.join(usersBucketDF, $"users_id" === $"uid")

joinUsersOrdersBucketDF.show(false)
