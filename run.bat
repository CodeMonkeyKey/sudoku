@ECHO off

:: ---Initialization ---
setlocal
echo Checking requirements...
SET "SRC_PATH=.\src\main\java\"
SET "OUT_PATH=.\out\production\sudoku"
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
javac -d %OUT_PATH% -sourcepath %SRC_PATH% ^
	%SRC_PATH%/*.java
echo Running the code...
java -cp %OUT_PATH% SudokuApp

:: ---Exit Script ---
echo Cleaning up...
rd /S /Q out
endlocal
exit /b 0