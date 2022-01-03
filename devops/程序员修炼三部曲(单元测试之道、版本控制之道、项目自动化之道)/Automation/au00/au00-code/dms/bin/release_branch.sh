#!/bin/bash
#
# Excerpted from the book, "Pragmatic Project Automation"
# ISBN 0-9745140-3-9
# Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
# Visit www.PragmaticProgrammer.com
#


if [ $# -eq 0 ]
then
  echo "usage: release_branch.sh <version>"
  exit 1
fi

VERSION=$1
NAME=dms
RELEASE=$NAME-$VERSION
WORK_DIR=$HOME/work

# 1. Test the mainline

cd $WORK_DIR
rm -rf $NAME
cvs co $NAME
cd $NAME
if ! ant test
then
  echo "Mainline test failed!"
  exit 1
fi

# 2. Create a release branch

cd $WORK_DIR/$NAME
cvs rtag -b RB_$VERSION $NAME

# 3. Check out the release branch

cd $WORK_DIR
cvs co -r RB_$VERSION -d $RELEASE-rb $NAME

# 4. Build and test the release branch

cd $WORK_DIR/$RELEASE-rb
if ! ant test
then
  echo "Release branch test failed!"
  exit 1
fi
