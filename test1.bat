@echo off & setLocalDisableDelayedExpansion
:Start
Mode 50,30 & color 03
echo Enter Username and Password to access Po Rate
Set /p D_USERNAME=Username:

SET "D_PASSWORD="
SET "psCommand=powershell -Command "$pword = read-host 'Password' -AsSecureString ; ^
    $pwdtext=[Runtime.InteropServices.Marshal]::PtrToStringAuto([Runtime.InteropServices.Marshal]::SecureStringToBSTR($pword)); ^
	-join($pwdtext)""
for /f "usebackq delims=" %%p in (`%psCommand%`) do set D_PASSWORD=%%p
:: ECHO %D_PASSWORD%

Echo Enter the Message Note
Set /p D_NOTE=Note: 

REM Do anything with ".\New folder (3)\bat.bat"
PUSHD ".\New folder (3)"
call bat.bat %D_USERNAME% %D_PAASWORD% %D_NOTE%
Exit