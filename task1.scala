def phoneNumConvert(tel: String): String = {
  val result = "84" + tel.replaceAll(",","").trim
  return result
}
//define UDF
val phoneNumConvertUDF = udf[String, String] (phoneNumConvert)

import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()




val df = spark.read.option("header","true").option("inferSchema","true").csv("dataTest.csv")
df.columns
df.printSchema()
//1. convert phone number
df.select(phoneNumConvertUDF(col("ISDN"))).show(5)
//2. Time Process
