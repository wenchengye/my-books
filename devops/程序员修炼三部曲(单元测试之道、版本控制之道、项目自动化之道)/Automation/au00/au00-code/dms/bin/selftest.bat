@echo off
REM
REM Excerpted from the book, "Pragmatic Project Automation"
REM ISBN 0-9745140-3-9
REM Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
REM Visit www.PragmaticProgrammer.com
REM

setlocal

rem %~dp0 is the name of the current script under NT/2K
set COMMAND=%~dp0

rem : operator works similar to make : operator
set DMS_DIR=%COMMAND:\bin\=%

set DMS_CLASSPATH=%DMS_DIR%\lib\dms.jar;%DMS_DIR%\lib\dms-tests.jar;%DMS_DIR%\vendor\lib\junit-3.8.jar;%DMS_DIR%\vendor\lib\lucene-1.3.jar;%DMS_DIR%\vendor\lib\Tidy.jar

java -Ddms.dir="%DMS_DIR%" -Ddoc.dir="%DMS_DIR%\doc" -Dindex.dir="%DMS_DIR%\index" -classpath "%DMS_CLASSPATH%" com.pragprog.dms.selftest.AllTests
