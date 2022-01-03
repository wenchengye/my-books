#!/bin/sh
#
# Excerpted from the book, "Pragmatic Project Automation"
# ISBN 0-9745140-3-9
# Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
# Visit www.PragmaticProgrammer.com
#


if [ $# -eq 0 ]
then
  echo "usage: checkurl.sh <url>"
  exit 1
fi

url=$1
outputfile="/tmp/test-$$.html"
to="3035551212@mobile.att.net"
subject="Uh oh!"
message=""

trap "rm -f $outputfile" 0

if curl -o $outputfile $url
then 

  if grep -qiE "Error|Exception" $outputfile
  then
    message="Error or Exception"
  else
    exit 0  # success
  fi

else

  message="Unavailable"

fi

(cat << END_OF_MAIL

Sadly, $url isn't feeling well right now.

Diagnosis: $message

Thanks,
Your Humble Monitor
END_OF_MAIL
) | mail -s "$subject" "$to"
