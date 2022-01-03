#!/bin/sh
#
# Excerpted from the book, "Pragmatic Project Automation"
# ISBN 0-9745140-3-9
# Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
# Visit www.PragmaticProgrammer.com
#


COMMAND=$0
DMS_DIR=`dirname $COMMAND`/..

DMS_CLASSPATH=$DMS_DIR/lib/dms.jar:$DMS_DIR/lib/dms-tests.jar

for library in $DMS_DIR/vendor/lib/*.jar
do
  if [ -f "$library" ]
  then
    DMS_CLASSPATH=$DMS_CLASSPATH:$library
  fi
done

$JAVA_HOME/bin/java -Ddms.dir=$DMS_DIR -Ddoc.dir=$DMS_DIR/doc -Dindex.dir=$DMS_DIR/index -classpath $DMS_CLASSPATH com.pragprog.dms.selftest.AllTests
