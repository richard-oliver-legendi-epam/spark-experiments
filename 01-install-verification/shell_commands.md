spark.version
res0: String = 3.4.1

scala> val strings = spark.read.text("../README.md")
strings: org.apache.spark.sql.DataFrame = [value: string]

scala> strings.show(10)
+--------------------+
|               value|
+--------------------+
|      # Apache Spark|
|                    |
|Spark is a unifie...|
|high-level APIs i...|
|supports general ...|
|rich set of highe...|
|pandas API on Spa...|
|and Structured St...|
|                    |
|<https://spark.ap...|
+--------------------+
only showing top 10 rows


scala> strings.show(10, false)
+--------------------------------------------------------------------------------------------------+
|value                                                                                             |
+--------------------------------------------------------------------------------------------------+
|# Apache Spark                                                                                    |
|                                                                                                  |
|Spark is a unified analytics engine for large-scale data processing. It provides                  |
|high-level APIs in Scala, Java, Python, and R, and an optimized engine that                       |
|supports general computation graphs for data analysis. It also supports a                         |
|rich set of higher-level tools including Spark SQL for SQL and DataFrames,                        |
|pandas API on Spark for pandas workloads, MLlib for machine learning, GraphX for graph processing,|
|and Structured Streaming for stream processing.                                                   |
|                                                                                                  |
|<https://spark.apache.org/>                                                                       |
+--------------------------------------------------------------------------------------------------+
only showing top 10 rows


scala>
