# Instructions d'installation

- Cloner le référentiel :
```shell
git clone git@github.com:juanluck/lampDocker.git
```

- Aller au répositoire :
```shell
cd lampDocker
```

- Construction du conteneur :
```
docker build -t debian-lamp .
```
- Lancer le service :
```
docker run -p 8000:80 debian-lamp
```

- Vérifier que l'application est en cours d'exécution. Pour ce faire, ouvrez un navigateur et tapez ```localhost:8000/index.php```
