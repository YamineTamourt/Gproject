"!/bin/bash

for video in $(youtube-dl -j --flat-playlist $1 | jq -r '.id' | sed 's_^_https://youtu.be/_')
do
  youtube-dl -J $video  | jq '{"date": .upload_date,"title": .title,"author": .uploader,"description": .description, "null"}' | grep ":" > file.txt
  
  while IFS=: read name data
  do
    echo ${data:2:${#data}-4}
  done < file.txt
  
  youtude-de --get-filename $video
done
