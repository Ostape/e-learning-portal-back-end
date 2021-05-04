#!/bin/bash
# set the STRING variable
STRING="Hello World!"
# print the contents of the variable on screen
echo "$STRING"
cd ../
cd orestorest/
echo $PWD
echo "Path|"
git clone https://github.com/Ostape/Back-end-test-repository
sudo chmod o+x Back-end-test-repository/
cd Back-end-test-repository/
echo $PWD
chmod +x ./gradlew
sudo ./gradlew clean test --info

echo "Starting ${report_name}" >> "${log}"
sleep 10

