#!/bin/sh
#
# Excerpted from the book, "Pragmatic Project Automation"
# ISBN 0-9745140-3-9
# Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
# Visit www.PragmaticProgrammer.com
#


COMMAND=$0
DMS_DIR=`dirname $COMMAND`/..

DOC_DIR=$DMS_DIR/doc
if [ -n "$1" ]
then
  DOC_DIR=$1
fi

for file in $DOC_DIR/*.html
do
  $DMS_DIR/bin/index.sh $file
done
