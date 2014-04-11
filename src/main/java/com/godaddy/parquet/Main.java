package com.godaddy.parquet;

/**
 * Created by nhowell on 4/10/14.
 */
public class Main {
    public static void main(final String[] args) throws Throwable {
        ParquetAvro.main(args);
        ParquetProtobuf.main(args);
    }
}
