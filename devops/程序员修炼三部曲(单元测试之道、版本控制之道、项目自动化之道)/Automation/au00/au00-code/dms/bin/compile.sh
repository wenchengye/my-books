#!/bin/sh
#
# Excerpted from the book, "Pragmatic Project Automation"
# ISBN 0-9745140-3-9
# Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
# Visit www.PragmaticProgrammer.com
#


COMMAND=$0
DMS_DIR=`dirname $COMMAND`/..
cd $DMS_DIR

rm -rf build/prod
mkdir -p build/prod

javac -classpath vendor/lib/lucene-1.3.jar:vendor/lib/Tidy.jar -d build/prod src/com/pragprog/dms/*.java
