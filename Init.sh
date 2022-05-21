#!/bin/bash

echo "Entrer le lien de la playlist pour generer la page (vide pour generer la page d'exemple)"

read lien

if [[ -z $lien ]]
then
	echo "generation de la page d'exemple ..."
	
	/usr/sbin/apache2ctl -DFOREGROUND

	exit 0
fi

youtube-dl -s $lien > /dev/null 2> /dev/null

if [ $? -ne 0 ]
then
	echo "lien invalide"
	echo "generation de la page d'exemple ..."
else
	echo "telechargement de la playlist ..."

	youtube-dl -o '/var/www/html/video/%(uploader)s/%(upload_date)s/%(title)s' $lien
	
	echo "generation de la page ..."
	
	javac /root/GenerateurData.java
	javac /root/Video.java
	javac /root/GenerateurHtml.java

	
	java GenerateurData
	java GenerateurHtml
fi

/usr/sbin/apache2ctl -DFOREGROUND

exit 0
