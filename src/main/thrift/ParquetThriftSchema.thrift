namespace java com.godaddy.parquet.thrift

struct Inner {
    1: optional i64 x;
    2: optional double y;
}

struct Person {
    1: optional i64 id;
    2: list<Inner> woot;
}
