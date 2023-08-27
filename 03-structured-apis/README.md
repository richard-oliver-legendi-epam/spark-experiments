# How to build the package
 1. sbt clean package
 2. mkdir jars
 3. cp target/scala-2.12/main-scala-chapter3_2.12-1.0.jar jars/

# How to run the Example
To run the Scala code for this chapter use:

 * `spark-submit --class main.scala.chapter3.Example3_7 jars/main-scala-chapter3_2.12-1.0.jar data/blogs.json`

# How to run a single file w/o the need of sbt/compiling a Jar?

https://stackoverflow.com/questions/27717379/spark-how-to-run-spark-file-from-spark-shell

    spark-shell -i file.scala       (could not work anymore)

Or in the spark-shell itself?
    scala>> :load PATH_TO_FILE


## For the scripts

        ...
        Spark context Web UI available at http://host.docker.internal:4040
        Spark context available as 'sc' (master = local[*], app id = local-...).
        Spark session available as 'spark'.
