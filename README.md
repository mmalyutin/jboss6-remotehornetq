# JBoss AS 6.1.0.Final connecting to remote HornetQ

This projects sets up two JBoss AS 6.1.0.Final server where a message driven bean on server2 consumes messages from a queue on server1.

## Quick instructions

These instructions has been tested on Linux (not sure it will work the same on other OSes).

   * ./gradlew clean assemble
      This will download JBoss AS 6.1.0.Final and setup the two servers
   * In one terminal start server 1
     build/unpacked/jboss-6.1.0.Final/bin/run.sh -b 127.0.1.1 -c server1
   * In another terminal start server 2
     build/unpacked/jboss-6.1.0.Final/bin/run.sh -b 127.0.1.2 -c server2
   * Wait for the servers to start completely
   * In a third terminal send some messages to server 1
     ./gradlew postMessages
