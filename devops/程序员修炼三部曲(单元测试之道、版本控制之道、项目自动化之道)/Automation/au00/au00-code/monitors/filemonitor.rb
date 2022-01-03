#!/usr/bin/env ruby
#
# Excerpted from the book, "Pragmatic Project Automation"
# ISBN 0-9745140-3-9
# Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
# Visit www.PragmaticProgrammer.com
#


def watch(file)

  last_touched = File.mtime(file)

  loop do 
    sleep 60
    current_time = File.mtime(file)
    if current_time != last_touched
      notify(file)
    end
    last_touched = current_time
  end

end

def notify(file)
  puts "#{file} was changed."
  # send an email, text message, etc.
end

if ARGV.empty?
  puts "Usage: filemonitor.rb <filename>"
  exit 1
end

watch(ARGV[0])
