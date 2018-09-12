clear

# get input for minutes
echo -n "Enter countdown minutes and press [ENTER]: "
read minutes

# set default value
if echo "$minutes" | egrep -q '^\-?[0-9]+$'; then 
    echo "Input is: $minutes."
else 
    minutes=40
fi
seconds=$minutes*60

# start countdown
for ((i=$seconds;i>0;i--)); do
  seconds_remaining=$((i%60))
  minutes_remaining=$((i/60))
  sleep 1 &
  printf "Time Remaining: $minutes_remaining:$seconds_remaining \r"
  wait
done

start / alert.bat

clear
