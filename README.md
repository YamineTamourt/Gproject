# Instructions d'installation

- Cloner le référentiel :
```shell
git clone git@github.com:YamineTamourt/legende
```

- Aller au répertoire :
```shell
cd Gproject
```

- Construction du conteneur :
```
docker build -t legende .
```
- Lancer le service :
```
docker run -it -p 8000:8096 legende
```

- Copier le lien de la video ou playlist youtube à télécharger et qui sera dans la médaithèque, ou ne rien mettre pour obtenir la médiathèque d'exemple

```
Entrer le lien de la playlist/video (vide pour generer la playlist d'exemple)

https://www.youtube.com/watch?v=ZA3Tym3SQTs

telechargement de la playlist/video ...
```
- Après le téléchargement, vérifier que l'application est en cours d'exécution. Pour ce faire, ouvrez un navigateur et tapez ```localhost:8000/```
