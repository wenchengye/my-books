#!/bin/sh
#
# Excerpted from the book, "Pragmatic Project Automation"
# ISBN 0-9745140-3-9
# Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
# Visit www.PragmaticProgrammer.com
#


if [ $# -eq 0 ]
then
  echo "usage: index.sh <file>"
  exit 1
fi

COMMAND=$0
DMS_DIR=`dirname $COMMAND`/..

DMS_CLASSPATH=$DMS_DIR/build/prod:$DMS_DIR/lib/dms.jar:$DMS_DIR/vendor/lib/lucene-1.3.jar:$DMS_DIR/vendor/lib/Tidy.jar

java -classpath $DMS_CLASSPATH com.pragprog.dms.Indexer -indexDir $DMS_DIR/index -file $1
