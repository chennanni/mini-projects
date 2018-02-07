:: hide all output messages
@echo off
echo off

:: play sound
set "file=C:\Temp\test-workspace\cmd-timer\ding.mp3"
( echo Set Sound = CreateObject("WMPlayer.OCX.7"^)
  echo Sound.URL = "%file%"
  echo Sound.Controls.play
  echo do while Sound.currentmedia.duration = 0
  echo wscript.sleep 100
  echo loop
  echo wscript.sleep (int(Sound.currentmedia.duration^)+1^)*1000
) > sound.vbs
start /min sound.vbs

:: show message box
cscript C:\Temp\test-workspace\cmd-timer\MessageBox.vbs > nul

:: delete the sound scipt
del sound.vbs

exit
