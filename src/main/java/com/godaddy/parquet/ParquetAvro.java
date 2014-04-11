package com.godaddy.parquet;

import com.godaddy.parquet.avro.Inner;
import com.godaddy.parquet.avro.Person;
import org.apache.hadoop.fs.Path;
import parquet.avro.AvroParquetWriter;
import parquet.hadoop.metadata.CompressionCodecName;

import java.util.Arrays;
import java.util.List;

public class ParquetAvro {
    public static void main(final String[] args) throws Throwable {
        final Path path = new Path("/tmp/parquet/avro/avro.gz.parquet");
        final AvroParquetWriter<Person> writer = new AvroParquetWriter<>(path, Person.getClassSchema(), CompressionCodecName.GZIP, AvroParquetWriter.DEFAULT_BLOCK_SIZE, AvroParquetWriter.DEFAULT_PAGE_SIZE, AvroParquetWriter.DEFAULT_IS_DICTIONARY_ENABLED);

        for (long i = 0L; i < 10L; ++i) {
            final List<Inner> woots = Arrays.asList(Inner.newBuilder().setX(i*808).setY(i*90.9).build());
            final Person foo = Person.newBuilder().setId(i).setWoot(woots).build();
            writer.write(foo);
        }

        writer.close();
    }
}
