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
	
	mkdir /var/www/html/video
	
	cd /var/www/html/video

	youtube-dl $lien
	
	echo "generation de la page ..."
	
	cd /var/www/html
	
	chmod +rx GenererData.sh
	javac GenerateurHtml.java
	
	./GenererData.sh $lien
	java GenerateurHtml
fi

# /usr/sbin/apache2ctl -DFOREGROUND

exit 0
