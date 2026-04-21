@REM Maven Wrapper for Windows (Takari 0.5.6 bootstrap)
@echo off
setlocal
set "DIRNAME=%~dp0"
if "%DIRNAME:~-1%"=="\" set "DIRNAME=%DIRNAME:~0,-1%"
java "-Dmaven.multiModuleProjectDirectory=%DIRNAME%" -cp "%DIRNAME%\.mvn\wrapper\maven-wrapper.jar" org.apache.maven.wrapper.MavenWrapperMain %*
exit /b %ERRORLEVEL%
