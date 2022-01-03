#!/bin/sh
#
# Excerpted from the book, "Pragmatic Project Automation"
# ISBN 0-9745140-3-9
# Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
# Visit www.PragmaticProgrammer.com
#


while ! java com.pragprog.Main
do
  mail -s "Help Me!" 3035551212@mobile.att.net < email.txt
  sleep 60
done
