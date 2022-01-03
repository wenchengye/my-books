#!/bin/bash
#
# Excerpted from the book, "Pragmatic Project Automation"
# ISBN 0-9745140-3-9
# Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
# Visit www.PragmaticProgrammer.com
#


VERSION=$1
NAME=dms
RELEASE=$NAME-$VERSION
WORK_DIR=$HOME/work
DATE=`date +%d%m%y-%A`
DATED_DIR=/Users/Shared/releases/daily/$DATE

# 1. Check out the project

cd $WORK_DIR
rm -r $RELEASE-daily
cvs co -d $RELEASE-daily $NAME

# 2. Build and test the project

cd $RELEASE-daily
if ! ant test
then 
  exit 1
fi

# 3. Create a distribution file

ant -buildfile package.xml -Dversion=$VERSION

# 4. Drop the release in the dated directory

mkdir -p $DATED_DIR
cp $WORK_DIR/$RELEASE-daily/dist/$RELEASE.zip $DATED_DIR
