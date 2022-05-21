"!/bin/bash

for video in $(youtube-dl -j --flat-playlist $1 | jq -r '.id' | sed 's_^_https://youtu.be/_')
