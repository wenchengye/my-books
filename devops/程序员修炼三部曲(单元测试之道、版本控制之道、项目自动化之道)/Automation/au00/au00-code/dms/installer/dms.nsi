;
; Excerpted from the book, "Pragmatic Project Automation"
; ISBN 0-9745140-3-9
; Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
; Visit www.PragmaticProgrammer.com
;

!define PRODUCT_NAME "DMS-1.0"
!ifndef COMPRESS_DIR
!define COMPRESS_DIR "c:\test\dms-1_0"
!endif

Name "${PRODUCT_NAME}"
OutFile "Setup.exe"
InstallDir "$PROGRAMFILES\${PRODUCT_NAME}"

!include "MUI.nsh"

; Install Pages (1-6)
!insertmacro MUI_PAGE_WELCOME ; <callout id="co.welcomepage"/>
!insertmacro MUI_PAGE_LICENSE "${COMPRESS_DIR}\LICENSE" ; <callout id="co.licensepage"/>
!insertmacro MUI_PAGE_DIRECTORY ; <callout id="co.directorypage"/>
Page custom UserPrefsPage ; <callout id="co.custompage"/>
!insertmacro MUI_PAGE_INSTFILES ; <callout id="co.installpage"/>
!insertmacro MUI_PAGE_FINISH ; <callout id="co.endpage"/>
; Uninstall Pages (1-2)
!insertmacro MUI_UNPAGE_CONFIRM
!insertmacro MUI_UNPAGE_INSTFILES

!insertmacro MUI_LANGUAGE "English"

Section "All Components" AllSection ; <callout id="co.allsection"/>
  SetOutPath "$INSTDIR"
  File /r "${COMPRESS_DIR}\*.*"
  Call WritePropertyFile
SectionEnd

Section -PostInstallSection ; <callout id="co.postinstallsection"/>
  WriteUninstaller "$INSTDIR\Uninstall.exe"
  CreateDirectory "$SMPROGRAMS\${PRODUCT_NAME}"
  CreateShortCut "$SMPROGRAMS\${PRODUCT_NAME}\Search.lnk" \
                 "$INSTDIR\bin\search.bat"
  CreateShortCut "$SMPROGRAMS\${PRODUCT_NAME}\Uninstall.lnk" \
                 "$INSTDIR\Uninstall.exe"
SectionEnd

Section Uninstall ; <callout id="co.uninstallsection"/>
  RMDir /r "$INSTDIR"
  RMDir /r "$SMPROGRAMS\${PRODUCT_NAME}"
SectionEnd
Function .onInit
  !insertmacro MUI_INSTALLOPTIONS_EXTRACT "UserPrefsPage.ini"
FunctionEnd

Function UserPrefsPage ; <callout id="co.userprefspage"/>
  !insertmacro MUI_HEADER_TEXT "Choose User Preferences" \
                               "Your very own DMS settings"
  !insertmacro MUI_INSTALLOPTIONS_DISPLAY "UserPrefsPage.ini"
FunctionEnd

Var DOC_DIR
Var INDEX_DIR

Function WritePropertyFile  ; <callout id="co.writepropertyfile"/>
  !insertmacro MUI_INSTALLOPTIONS_READ $DOC_DIR \
               "UserPrefsPage.ini" "Field 2" "State"
  !insertmacro MUI_INSTALLOPTIONS_READ $INDEX_DIR \
               "UserPrefsPage.ini" "Field 4" "State"
  FileOpen  $0 "$PROFILE\dms.properties" "w"
  FileWrite $0 "document.directory=$DOC_DIR$\r$\n"
  FileWrite $0 "index.directory=$INDEX_DIR$\r$\n"
  FileClose $0
  DetailPrint "Stored user preferences in $PROFILE\dms.properties"
FunctionEnd
