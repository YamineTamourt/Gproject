#!/bin/bash

echo "Entrer le lien de la playlist/video pour generer la page (vide pour generer la page d'exemple)"
echo ""

read lien

if [[ -z $lien ]]
then
	echo ""
	echo "generation de la page d'exemple ..."
	echo ""
	
	/usr/sbin/apache2ctl -DFOREGROUND

	exit 0
fi

youtube-dl -s $lien > /dev/null 2> /dev/null

if [ $? -ne 0 ]
then
	echo ""
	echo "lien invalide"
	echo "generation de la page d'exemple ..."
	echo ""
else
	echo ""
	echo "telechargement de la playlist/video ..."
	echo ""
	
	mkdir /var/www/html/video
	
	cd /var/www/html/video

	youtube-dl $lien
	
	echo "generation de la page ..."
	echo ""
	
	cd /var/www/html
	
	chmod +rx GenererData.sh
	javac GenerateurHtml.java
	
	./GenererData.sh $lien
	java GenerateurHtml
fi

/usr/sbin/apache2ctl -DFOREGROUND

exit 0
