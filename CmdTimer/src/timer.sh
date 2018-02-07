clear

# get args
minutes=$1

# set default value
if echo "$minutes" | egrep -q '^\-?[0-9]+$'; then 
    # echo "$minutes is a number"
	:
else 
    minutes=40
fi
seconds=$minutes*60

# start the countdown
for ((i=$seconds;i>0;i--)); do
  seconds_remaining=$((i%60))
  minutes_remaining=$((i/60))
  sleep 1 &
  printf "Time Remaining: $minutes_remaining:$seconds_remaining \r"
  wait
done

start /B alert.bat

clear
