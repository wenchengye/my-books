@echo off
REM
REM Excerpted from the book, "Pragmatic Project Automation"
REM ISBN 0-9745140-3-9
REM Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
REM Visit www.PragmaticProgrammer.com
REM

setlocal

set COMMAND=%~dp0
set DMS_DIR=%COMMAND:\bin\=%

for %%f in ("%DMS_DIR%\doc\*.html") do call "%DMS_DIR%\bin\index.bat" %%f
