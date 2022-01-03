#!/bin/bash
#
# Excerpted from the book, "Pragmatic Project Automation"
# ISBN 0-9745140-3-9
# Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
# Visit www.PragmaticProgrammer.com
#


if [ $# -eq 0 ]
then
  echo "usage: release_generate.sh <version>"
  exit 1
fi

VERSION=$1
NAME=dms
RELEASE=$NAME-$VERSION
WORK_DIR=$HOME/work
TEST_DIR=$HOME/testinstall

# 5. Create a distribution file

cd $WORK_DIR/$RELEASE-rb
ant -buildfile package.xml -Dversion=$VERSION

# 6. Test the distribution contents

cd $TEST_DIR
unzip $WORK_DIR/$RELEASE-rb/dist/$RELEASE.zip
cd $TEST_DIR/$RELEASE/lib
jar xvf $NAME.jar

cd $WORK_DIR/$RELEASE-rb
if ! ant test \
     -Dbuild.prod.dir=$TEST_DIR/$RELEASE/lib \
     -Dvendor.lib.dir=$TEST_DIR/$RELEASE/vendor/lib
then
  echo "Distribution test failed!"
  exit 1
fi

# 7. Tag the release

cd $WORK_DIR/$RELEASE-rb
cvs tag REL_$VERSION

# 8. Hand off the distribution file

cp $WORK_DIR/$RELEASE-rb/dist/$RELEASE.zip /Users/Shared/releases
