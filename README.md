Ce fichier contient :
# Description du lancement du projet:
 ## Etape 1: Version JAVA?
Verifier /migrer vers la version 11 java (ou inférieur)  
Le projet utilise SecurityManageer qui n'est plus pris en charge dans les versions récentes

## Etape 2: Compiler le projet 
```bash
javac */*.java    
```
## Etape 3: Lancer le serveur HTTP
```bash
cd out/production/client  
python -m http.server 8000
```
---
## Etape 4 Lancer le serveur RMI   
****
## Etape 5: Lancer le client  
***
## Etape 6: UN PROJET FONCTIONNEL!  
Le menu du client s'affiche et vous etes connectés automatiquement  
Vous pouvez alors:  
. avoir un apercu sur le cabinet  
. ajouter un animal  
. rechercher  un animal  
. ajouter un aanimal special(aniimal en extinction)  
. quitter le cabinet
*******
****
# Exemples de création d'animaux pour ton projet  
Vous pouvez copier/coller ces instructions pour ajouter de nouveaux animaux dans votre code, ou bien vous en inspirer pour la saisie des informations lors de l’exécution du programme. 

**Animaux classiques**
Animal a2 = new Animal("Mina", "Bensalem Fatma","Chat",15, "Bengal", "Stérilisée, dernière visite : 2025-06-10");  
Animal a3 = new Animal("Coco", "Martin Paul","Oiseau",10,"Canari", "Contrôle annuel prévu pour décembre");
-------------------------------
**Animaux en extinction**
AnimalEnExtinction fennec = new AnimalEnExtinction(  
"Sirocco",  
"Centre de Sauvegarde du Sahara",  
"Fennec du Sahara",  
12,  
"Vulpes zerda",  
"Animal protégé – suivi vétérinaire et réhabilitation en milieu naturel",  
"Sahara (Afrique du Nord)",  
true  
);
