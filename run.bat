@ECHO off

:: ---Initialization ---
setlocal
echo Checking requirements...
SET "SRC_PATH=.\src\main\java"
SET "OUT_PATH=.\out\production\sudoku"
SET "LIB_PATH=.\libs"
if not exist %SRC_PATH% (
	ECHO Batch file has been moved or the source folder does not exits!!
	endlocal
	exit /b 1
)
if not exist %OUT_PATH% (
	mkdir %OUT_PATH%
)

:: ---Main Execution ---
echo Compiling the code...
dir /s /b %SRC_PATH%\*.java > temp
javac -cp %LIB_PATH%\* -d %OUT_PATH% @temp
echo Running the code...
java -cp %OUT_PATH%;%LIB_PATH%\* SudokuApp

:: ---Exit Script ---
echo Cleaning up...
del temp
rd /S /Q out
endlocal
exit /b 0