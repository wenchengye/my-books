#!/bin/sh
#
# Excerpted from the book, "Pragmatic Project Automation"
# ISBN 0-9745140-3-9
# Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
# Visit www.PragmaticProgrammer.com
#

#
# search - Searches for indexed HTML files
#

if [ $# -eq 0 ]
then
  echo "usage: search.sh <word> [word ...]"
  exit 1
fi

PRG=$0
DMS_DIR=`dirname "$PRG"`/..

DMS_CLASSPATH=$DMS_DIR/build/prod:$DMS_DIR/lib/dms.jar:$DMS_DIR/vendor/lib/lucene-1.3.jar

java -classpath $DMS_CLASSPATH com.pragprog.dms.Search $DMS_DIR/index "$@"
