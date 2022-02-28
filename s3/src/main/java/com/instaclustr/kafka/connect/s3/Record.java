package com.instaclustr.kafka.connect.s3;

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
