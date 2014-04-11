package com.godaddy.parquet;

import org.apache.hadoop.fs.Path;
//import parquet.hadoop.thrift.ThriftToParquetFileWriter;

public class ParquetThrift {
    public static void main(final String[] args) throws Throwable {
        final Path path = new Path("/tmp/parquet/thrift/thrift.gz.parquet");
        /*
        final ThriftToParquetFileWriter
        final ProtoParquetWriter<ParquetProtobufSchema.Person> writer = new ProtoParquetWriter<>(path, ParquetProtobufSchema.Person.class, CompressionCodecName.GZIP, ProtoParquetWriter.DEFAULT_BLOCK_SIZE, ProtoParquetWriter.DEFAULT_PAGE_SIZE, ProtoParquetWriter.DEFAULT_IS_DICTIONARY_ENABLED, ProtoParquetWriter.DEFAULT_IS_VALIDATING_ENABLED);

        for (int i = 0; i < 10; ++i) {
            final List<ParquetProtobufSchema.Person.Inner> woots = Arrays.asList(ParquetProtobufSchema.Person.Inner.newBuilder().setX(i * 808).setY(i * 90.9).build());
            final ParquetProtobufSchema.Person foo = ParquetProtobufSchema.Person.newBuilder().setId(i).addAllWoot(woots).build();
            writer.write(foo);
        }

        writer.close();
        */
    }
}
