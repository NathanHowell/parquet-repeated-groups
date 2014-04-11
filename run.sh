#!/bin/bash
rm -rf /tmp/parquet/
mvn exec:java -Dexec.mainClass=com.godaddy.parquet.Main
diff <(parquet-schema /tmp/parquet/avro/avro.gz.parquet) <(parquet-schema /tmp/parquet/proto/proto.gz.parquet)
hive -hiveconf hive.root.logger=INFO,console -f /dev/stdin << EOF
ADD JAR parquet-hive-bundle-1.4.2-SNAPSHOT.jar;
ADD JAR parquet-hive-binding-bundle-1.4.2-SNAPSHOT.jar;

DROP TABLE avro;
DROP TABLE proto;

CREATE EXTERNAL TABLE avro(id bigint, woot array<struct<x:bigint,y:double>>)
ROW FORMAT SERDE 'parquet.hive.serde.ParquetHiveSerDe'
STORED AS
INPUTFORMAT 'parquet.hive.DeprecatedParquetInputFormat'
OUTPUTFORMAT 'parquet.hive.DeprecatedParquetOutputFormat'
LOCATION '/tmp/parquet/avro/'
TBLPROPERTIES ('parquet.compression'='gzip', 'parquet.enable.dictionary'='true');

CREATE EXTERNAL TABLE proto(id bigint, woot array<struct<x:bigint,y:double>>)
ROW FORMAT SERDE 'parquet.hive.serde.ParquetHiveSerDe'
STORED AS
INPUTFORMAT 'parquet.hive.DeprecatedParquetInputFormat'
OUTPUTFORMAT 'parquet.hive.DeprecatedParquetOutputFormat'
LOCATION '/tmp/parquet/avro/'
TBLPROPERTIES ('parquet.compression'='gzip', 'parquet.enable.dictionary'='true');

SELECT * FROM avro;
SELECT * FROM proto;
EOF
