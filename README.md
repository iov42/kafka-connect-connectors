# Instaclustr Kafka Connect Connectors


## How to build

Executing 
 
```
mvn clean package
```

at the top level will build all connectors within the project and output separate jars in their respective target folders.

It will also generate an uber jar at the top level target directory which will contain all connectors and their dependencies.

If you want to just build one connector, run the same command from within the sub module.

## Persisting the data on S3 in Json format:
Data records are now _serialised_ to Json and then encoded into bytes when they are published on S3. Records on S3 are delimited by the new line character, `\n`.
When reading the data from S3, records are _decoded_ as String (using `UTF_8`) and then are parsed as Json in order to publish the `key`, `value`, `timestamp` and `offset` information in Kafka.

Other changes also included:

- File extension of the segment files on S3 now changes to `.txt`
- MaxBufferSize is now defaulted to 3MB. The `topic/partition/startOffset-endOffset.txt` segments are filled up to 3MB. When this threshold is met for a given range of start and end offset then we are ending up with 2 files having the same start offset but different end offset. E.g.
  `0000000000000000000-0000000000000000056.txt` and
  `0000000000000000000-0000000000000000068.txt`
- Given that we are not manipulating the kafka Headers, they are now removed.
- Supports non-consecutive offsets (I added this small change as part of my PR cause the branch with this change was 1 year old)


## Versioning

#### Connector Version

Each individual connector (sub module) version is defined in accordance to it's pom.

#### Distribution Version

This defines the version of the uber jar that consolidates all selected connectors in to one self contained jar.

A tag is used to mark a distribution and it should be in sync with the distribution.xml version.


## Further information and Documentation

For connector documentation please see https://www.instaclustr.com/support/documentation/kafka-connect/pre-built-kafka-connect-plugins/

For Instaclustr support status of this project please see https://www.instaclustr.com/support/documentation/announcements/instaclustr-open-source-project-status/

## License

Apache2 - See the included License file for more details.
