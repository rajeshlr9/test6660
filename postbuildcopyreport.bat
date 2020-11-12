@echo off
cd "C:\Jenkins\workspace\CIL\ManhattanWMS-3535876\ManhattanPOC\Manh-Test-Specific-Functionalities-ScrumTeam\resources\LatestReports"
for %%f in (*.*) do (
 dir /b **f > tmp
 set /p %%f=<tmp
 move %%f %BUILD_NUMBER%_%%f
 del tmp
move %BUILD_NUMBER%_%%f C:\Jenkins\workspace\CIL\ManhattanWMS-3535876\ManhattanPOC\Manh-Test-Specific-Functionalities-ScrumTeam\resources\Reports
)
cd "C:\Jenkins\workspace\CIL\ManhattanWMS-3535876\ManhattanPOC\Manh-Test-Specific-Functionalities-ScrumTeam\resources\Reports"
for /f "skip=3 eol=: delims=" %%F in ('dir /b /o-d /a-d *.html') do @del "%%F"