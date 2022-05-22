#!/bin/bash

rm video.data 2> /dev/null

for video in $(youtube-dl -j --flat-playlist $1 | jq -r '.id' | sed 's_^_https://youtu.be/_')
do
  youtube-dl -J $video  | jq '{"date": .upload_date,"title": .title,"author": .uploader,"description": .description, "null"}' | grep ":" > file.txt
  
  ligne=""
  
  while IFS=: read name data
  do
    if [ "$data" != " null" ]
    then
      ligne=$ligne"\t"${data:2:${#data}-4}
    fi
  done < file.txt
  
  ligne=$ligne"\t"$(youtube-dl --get-filename $video)
  
  ligne=${ligne:0:${#ligne}-5}
  ligne=$ligne".mp4"
  
  echo -e ${ligne:2} >> video.data
done

exit 0
