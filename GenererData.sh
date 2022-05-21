"!/bin/bash

for video in $(youtube-dl -j --flat-playlist $1 | jq -r '.id' | sed 's_^_https://youtu.be/_')
do
  youtube-dl -J $video  | jq '{"date": .upload_date,"title": .title,"author": .uploader,"description": .description}' | grep ":"
  
  youtude-de --get-filename $video
done
