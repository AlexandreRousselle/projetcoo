# Projet de conception orientée objet

## Lancement

Nous lancions notre projet via eclipse et n'avons pas gérer les dépendences via MAVEN.
Il suffit juste d'éditer le chemin dans le buildpath du projet vers ojdbc6.jar et le lancer.

## Dans le jeu

Se connecter avec "rousselle" "rousselle" ou "cherifi" "cherifi" et ensuite jouer avec les menus
afin de commencer une partie.

## Conception

Réaliser avec l'idée MVC et donc séparer dans 4 couches (avec la couche persistence).
Implémentation des DataMappers et du pattern Proxy pour remonter paresseusement les données.

## Le projet

- SoulSplit est le nom du jeu.
- Le jeu comporte plusieurs menus (Nouvelle Partie, Rejoindre Partie, Voir mes parties).
- Le créateur d'une partie lance la partie avec l'etat "en cours".
- Une fois la partie lancée, une map en ISOMETRIE est affichée avec un controlleur d'actions en bas de l'écran.

## Il manque

- Les tours d'une partie.
- La fin d'une partie.
- L'historique des parties d'un joueur.
- Les actions "déplacer une armée" et "attaquer une ville".
