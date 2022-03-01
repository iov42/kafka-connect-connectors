package com.instaclustr.kafka.connect.s3;

/**
 * This class represents the records being persisted on S3
 * k: record's key
 * v: record's value
 * t: record's timestamp
 * o: record's offset
 */
public class Record {
  final String k;
  final String v;
  final Long t;
  final long o;

  Record(String k, String v, Long t, long o) {
    this.k = k;
    this.v = v;
    this.t = t;
    this.o = o;
  }
}
