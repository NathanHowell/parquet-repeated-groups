package com.godaddy.parquet;

import com.godaddy.parquet.proto.ParquetProtobufSchema;
import org.apache.hadoop.fs.Path;
import parquet.hadoop.metadata.CompressionCodecName;
import parquet.proto.ProtoParquetWriter;

import java.util.Arrays;
import java.util.List;

public class ParquetProtobuf {
    public static void main(final String[] args) throws Throwable {
        final Path path = new Path("/tmp/parquet/proto/proto.gz.parquet");
        final ProtoParquetWriter<ParquetProtobufSchema.Person> writer = new ProtoParquetWriter<>(path, ParquetProtobufSchema.Person.class, CompressionCodecName.GZIP, ProtoParquetWriter.DEFAULT_BLOCK_SIZE, ProtoParquetWriter.DEFAULT_PAGE_SIZE, ProtoParquetWriter.DEFAULT_IS_DICTIONARY_ENABLED, ProtoParquetWriter.DEFAULT_IS_VALIDATING_ENABLED);

        for (int i = 0; i < 10; ++i) {
            final List<ParquetProtobufSchema.Person.Inner> woots = Arrays.asList(ParquetProtobufSchema.Person.Inner.newBuilder().setX(i * 808).setY(i * 90.9).build());
            final ParquetProtobufSchema.Person foo = ParquetProtobufSchema.Person.newBuilder().setId(i).addAllWoot(woots).build();
            writer.write(foo);
        }

        writer.close();
    }
}
