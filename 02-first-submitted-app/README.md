sbt clean package

SPARK_HOME/bin/spark-submit --class main.scala.chapter2.MnMcount jars/main-scala-chapter2_2.12-1.0.jar data/mnm_dataset.csv
