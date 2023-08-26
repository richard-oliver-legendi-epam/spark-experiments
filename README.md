# spark-experiments

Personal repo for experimenting with learning materials for the book Learning Spark, 2nd ed.

Unmodified code in the original repo: https://github.com/databricks/LearningSparkV2

## To discuss

How to run on Win?
	- mingw / does'nt work, ps does not have an o param haha
	- wsl / seems hacky, JDK should be installed within WSL and using that instead of the Win one would be confusing

UI - extra stats?
	onheap / offheap? http://localhost:4040/executors/
	exec loss reason?

Error output?
	bin\run-example JavaWordCount README.md

23/08/26 14:45:56 ERROR ShutdownHookManager: Exception while deleting Spark temp dir: C:\Users\Richard_Oliver_Legen\AppData\Local\Temp\spark-d72310e0-2816-4495-93de-0d783eb094f3
java.io.IOException: Failed to delete: C:\Users\Richard_Oliver_Legen\AppData\Local\Temp\spark-d72310e0-2816-4495-93de-0d783eb094f3\userFiles-3eb46aa9-e709-4079-aaca-e06290126b76\spark-examples_2.12-3.4.1.jar
        at org.apache.spark.network.util.JavaUtils.deleteRecursivelyUsingJavaIO(JavaUtils.java:150)
        at org.apache.spark.network.util.JavaUtils.deleteRecursively(JavaUtils.java:121)
        at org.apache.spark.network.util.JavaUtils.deleteRecursivelyUsingJavaIO(JavaUtils.java:133)
        at org.apache.spark.network.util.JavaUtils.deleteRecursively(JavaUtils.java:121)
        at org.apache.spark.network.util.JavaUtils.deleteRecursivelyUsingJavaIO(JavaUtils.java:133)
        at org.apache.spark.network.util.JavaUtils.deleteRecursively(JavaUtils.java:121)
        at org.apache.spark.network.util.JavaUtils.deleteRecursively(JavaUtils.java:94)
        at org.apache.spark.util.Utils$.deleteRecursively(Utils.scala:1231)
        at org.apache.spark.util.ShutdownHookManager$.$anonfun$new$4(ShutdownHookManager.scala:65)
        at org.apache.spark.util.ShutdownHookManager$.$anonfun$new$4$adapted(ShutdownHookManager.scala:62)
        at scala.collection.IndexedSeqOptimized.foreach(IndexedSeqOptimized.scala:36)
        at scala.collection.IndexedSeqOptimized.foreach$(IndexedSeqOptimized.scala:33)
        at scala.collection.mutable.ArrayOps$ofRef.foreach(ArrayOps.scala:198)
        at org.apache.spark.util.ShutdownHookManager$.$anonfun$new$2(ShutdownHookManager.scala:62)
        at org.apache.spark.util.SparkShutdownHook.run(ShutdownHookManager.scala:214)
        at org.apache.spark.util.SparkShutdownHookManager.$anonfun$runAll$2(ShutdownHookManager.scala:188)
        at scala.runtime.java8.JFunction0$mcV$sp.apply(JFunction0$mcV$sp.java:23)
        at org.apache.spark.util.Utils$.logUncaughtExceptions(Utils.scala:2088)
        at org.apache.spark.util.SparkShutdownHookManager.$anonfun$runAll$1(ShutdownHookManager.scala:188)
        at scala.runtime.java8.JFunction0$mcV$sp.apply(JFunction0$mcV$sp.java:23)
        at scala.util.Try$.apply(Try.scala:213)
        at org.apache.spark.util.SparkShutdownHookManager.runAll(ShutdownHookManager.scala:188)
        at org.apache.spark.util.SparkShutdownHookManager$$anon$2.run(ShutdownHookManager.scala:178)
        at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:577)
        at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:317)
        at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
        at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
        at java.base/java.lang.Thread.run(Thread.java:1623)




## Stuff got done

Docker install
Spark install
Spark verified
Hadoop install
Winutils install
Ran WordCount example - error output?

## Refs

https://pages.databricks.com/rs/094-YMS-629/images/LearningSpark2.0.pdf

http://localhost:4040/environment/

https://stackoverflow.com/questions/51895267/how-to-setup-spark-on-windows-10-step-by-step

!!! https://github.com/steveloughran/winutils/blob/master/hadoop-3.0.0/bin/winutils.exe
https://cwiki.apache.org/confluence/display/HADOOP2/WindowsProblems


