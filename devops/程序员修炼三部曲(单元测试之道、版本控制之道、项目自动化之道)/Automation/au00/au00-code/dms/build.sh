#!/bin/sh
#
# Excerpted from the book, "Pragmatic Project Automation"
# ISBN 0-9745140-3-9
# Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
# Visit www.PragmaticProgrammer.com
#


rm -rf checkout
mkdir -p checkout

cd checkout 
cvs -d /Users/Shared/cvsrepo co dms

cd dms
ant -f build.xml test
