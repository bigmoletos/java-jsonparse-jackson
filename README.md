
Parser un JSON avec Jackson
Dans tous les langages, on dispose de structures telles que les tableaux et les objets. Quand on les manipule, il faut garder à l'esprit que celles-ci sont stockées dans la mémoire de travail de l'ordinateur.
Chaque langage a sa propre façon de stocker ces données. Pour communiquer ces donnés par réseau, il est nécessaire de disposer d'un moyen permettant de transformer ces données dans un format "universel". Il existe plusieurs formats de communication "universels" ou "interopérables" : notamment XML et JSON.
Dans cette quête, tu vas d'abord voir comment un fichier JSON est structuré et ensuite tu apprendras à l'analyser grâce à la bibliothèque Jackson.
Objectifs
•
Comprendre le format de données JSON
•
Savoir analyser les données d'un JSON
•
Savoir parser un JSON
•
Savoir mapper les données d'un JSON vers des classes Java
Challenge ️️
Pour valider cette quête tu devras résoudre le challenge: Parser un fichier JSON de données météos. Le principe du challenge est détaillé dans l’onglet Challenge.
voir le challenge
 
JSON ?
Le JSON (JavaScript Object Notation) est un format permettant de transcrire des données de façon textuelle. Ces données sont classées dans des objets sous forme d'arborescence :
•
une racine aura une clé (le nom de la donnée)
•
ses branches auront des clés et des valeurs (les propriétés de la donnée)
On parle d'ensemble de paires clé/valeur.
Regarde cette vidéo qui explique le JSON en 1:30 !
Pour voir à quoi ressemblent des données JSON réelles, ouvre cette page sur l'API de GitHub : https://api.github.com/users/defunkt. Ce sont les données publiques du compte d'un des cofondateurs de GitHub. Tu peux aussi remplacer le pseudo defunkt par le tien !
Un exemple de JSON provenant de l'API GitHub
JSON explained in less than 10 minutes
What Is JSON | JSON Explained In 1 Minute
 
Objets, tableaux, valeurs
Un fichier JSON est composé de deux types d'éléments : les JSON Objects et les JSON Array.
Voici à quoi ressemble un fichier JSON :
{
    "name": "Eric Cartman",
    "age": 10,
    "size": 122.4,
    "psychopath": true,
    "contact": {
        "name": "Liane Cartman",
        "phone": "555-6754"
    },
    "hobbies": [
        "World of Warcraft",
        "Tacos",
        "Drink tears"
    ],
    "friends": null
}

JSON
1. JSON Object
Un JSON Object a la forme suivante :
{
    "clé1": valeur1,
    "clé2": valeur2
}

JSON
Un objet est représenté par des accolades : à une clé est associée une valeur.
2. JSON Array
Un JSON Array a la forme suivante :
"clé1": [
    valeur1,
    valeur2
]

JSON
Un tableau est représenté par des crochets : à une clé est associé un ensemble de valeurs.
3. JSON Data Types
Chaque valeur d'un JSON Object ou d'un JSON Array peut faire partie de la liste suivante :
•
chaîne de caractères
•
nombre
•
booléen
•
JSON Object
•
JSON Array
•
null
 
Parsing
Il existe plusieurs méthodes pour analyser des données contenues dans un fichier JSON en Java. Voici quelques bibliothèques permettant de le faire : 
•
JSON.simple
•
GSON
•
Jackson
La bibliothèque Jackson est puissante, relativement simple à utiliser et de nombreux projets Spring l'utilisent : c'est celle-ci que tu vas voir dans cette quête.
1. Récupérer la racine
La première étape pour analyser un fichier JSON va consister à transformer un texte contenu dans un fichier en objet Java : pour définir cette action, tu verras souvent le terme anglais "parsing".
ObjectMapper objectMapper = new ObjectMapper();
try {
    JsonNode root = objectMapper.readTree(new File("path/of/json/file.json"));
} catch (IOException e) {
    e.printStackTrace();
}

Java
Les blocs try et catch servent à intercepter des erreurs. Ici, par exemple, le fichier peut ne pas être trouvé. Dans ce cas-là, un message d'erreur sera affiché dans la console.
Dans le code ci-dessus, c'est ObjectMapper qui va servir à analyser un contenu JSON et à le transformer en objet Java.
La méthode readTree permet, à partir d'un fichier, d'obtenir un objet JsonNode qui contient les clés et les valeurs de la racine du JSON.
Prend le cas du JSON suivant : 
{
    "name": "Eric Cartman",
    "age": 10,
    "size": 122.4,
    "psychopath": true
}

JSON
En convertissant le JSON en JsonNode, tu obtiendras un objet dont les couples clé-valeurs seront :
•
clé: "name", valeur: "Eric Cartman"
•
clé: "age", valeur: 10
•
clé: "size", valeur: 122.4
•
clé: "psychopath", valeur: true
2. Récupérer des valeurs
Comme tu as pu le voir dans la section précédente, un JSON peut contenir différents types de valeurs : en fonction de ces types, tu devras appeler des méthodes différentes.
Dans le cas du JSON précédent, si l'on considère que tu possède la racine JsonNode root, tu récupéreras les valeurs de la façon suivante :
String nameValue = root.get("name").asText();
int ageValue = root.get("age").asInt();
double sizeValue = root.get("size").asDouble();
boolean isPsychopath = root.get("size").asBoolean();

Java
3. Le cas d'un JSON Object
Un JSON peut aussi contenir des JSON Object.
Tu as précédemment utilisé la méthode readTree, qui permet de récupérer la racine du JSON dans une variable de type JsonNode.
En fait, un JsonNode est un JSON Object !
Par défaut, à chaque fois que tu utilises la méthode get sur un JsonNode, tu vas récupérer un nouvel objet de type JsonNode. C'est pour cela que tu as besoin des méthodes asText, astInt, asDouble ou encore asBoolean pour lui préciser le type réel de la valeur récupérée.
Prend le cas du JSON suivant : 
{
    "contact": {
        "name": "Liane Cartman",
        "phone": "555-6754"
    }
}

JSON
Imaginons que tu possèdes déjà la racine root du JSON. Afin de récupérer l'objet "contact", il te suffira d'appeler la méthode get :
JsonNode contactObject = root.get("contact");

Java
Ainsi, comme tu l'as vu dans la section suivante, tu pourras récupérer les valeurs de l'objet avec la méthode get et la méthode asText :
String contactName = contactObject.get("name").asText();
String contactPhone = contactObject.get("phone").asText();

Java
4. Parcourir un JSON Array
Un autre élément possible d'un JSON est le JSON Array. Tu devras récupérer le tableau sous la forme d'un JsonNode et le parcourir avec une boucle for each.
Prend le cas du JSON suivant : 
{
    "hobbies": [
        "World of Warcraft",
        "Tacos",
        "Drink tears"
    ]
}

JSON
Voici le code de la récupération de chaque hobby, avec l'affichage dans le terminal :
for (JsonNode hobby : root.get("hobbies")) {
    System.out.println(hobby.asText());
}

Java
Jackson – Tree Model examples
Regarde les exemples des sections *Traversing JSON* et *Traversing JSON Array*
 
Mapping
Dans la section précédente, tu as vu comment parser manuellement un JSON en récupérant les valeurs au cas par cas. Ce n'est pas très efficace !
Tu ne seras donc rassuré d'apprendre qu'il est possible de rendre ce processus automatique ! On appelle cette étape le mapping : convertir les données d'un JSON vers une classe Java.
La première étape consiste à créer la classe qui va contenir les données à récupérer du JSON.
Prend l'exemple de ce nouveau JSON :
{
    "actor": {
        "id": 128840443,
        "name": "Tom Cruise",
        "rank": 132
    }
}

JSON
Tu vas devoir créer une classe Actor qui va avoir comme attributs les valeurs à enregistrer :
public class Actor {

    private Long id;
    private String name;
    private Integer rank;

    // TODO : add an empty constructor

    // TODO : add getters and setters
}

Java
Pour que ce soit plus lisible, le constructeur vide et les getters/setters n'apparaissent pas dans le code en exemple. Cependant il faut qu'ils soient présent pour que le processus de mapping fonctionne.
Tu vas pour effectuer un mapping automatique en utilisant la méthode convertValue et en lui spécifiant la classe vers laquelle tu veux convertir les données :
ObjectMapper objectMapper = new ObjectMapper();
try {
    JsonNode root = objectMapper.readTree(new File(ACTOR_JSON));
    Actor actor = objectMapper.convertValue(root.get("actor"), Actor.class);
} catch (IOException e) {
    e.printStackTrace();
}

Java
La méthode convertValue va créer une instance de Actor (d'où l'intérêt d'avoir un constructeur vide) et utiliser ses getters et setters afin d'initialiser les valeurs de ses attributs (d'où l'intérêt d'avoir des getters/setters).
Imaginons maintenant que tu ais le JSON suivant :
{
    "movies": [
        {
            "id": 1228776,
            "title": "Top Gun",
            "year": 1986,
            "rate": 3.4,
            "image_path": "auhfez87G8.jpg"
        },
        {
            "id": 9888765,
            "title": "Jack Reacher",
            "year": 2012,
            "rate": 4.4,
            "image_path": "87TGdzdh7.jpg"
        }
    ]
}

JSON
Tu as donc un JSON Array d'éléments movies. 
public class Movie {

    private Long id;
    private String title;
    private Integer year;
    private Double rate;
    @JsonProperty("image_path")
    private String imagePath;

    // TODO : add an empty constructor

    // TODO : add getters and setters
}

Java
Si tu as l'oeil, tu as remarqué que dans le JSON il y a une propriété image_path, alors que dans la classe l'attribut est nommé imagePath (pour respecter les conventions de nommage).
Pour permettre au mapping de se faire automatiquement, il faut donc préciser quel est le nom de la propriété, grâce à une annotation : @JsonProperty("image_path").
Maintenant voici comment tu vas récupérer le tableau de films, toujours avec la méthode convertValue :
ObjectMapper objectMapper = new ObjectMapper();
try {
    JsonNode root = objectMapper.readTree(new File(MOVIES_JSON));
    Movie[] movies = objectMapper.convertValue(root.get("movies"), Movie[].class);
} catch (IOException e) {
    e.printStackTrace();
}

Java
Jackson – How to parse JSON
Un super ressource pour aller plus loin : ajouter *Jackson* aux dépendances *Maven*, convertir un objet vers du *JSON*, ignorer un attribut lors de la conversion avec `@JsonIgnore`...
Jackson @JsonProperty and @JsonAlias Example
Quelques examples d'utilisation de `@JsonProperty`
https://www.concretepage.com/jackson-api/jackson-jsonproperty-and-jsonalias-example
Challenge ️️
Pour valider cette quête tu devras résoudre le challenge: Parser un fichier JSON de données météos. Le principe du challenge est détaillé dans l’onglet Challenge.
voir le challenge



MeasureMeasure
CHALLENGE 
Parser un fichier JSON de données météos
 
Énoncé :
Fait un fork du dépôt suivant : https://github.com/WildCodeSchool/java-jsonparse-jackson.
Ouvre le fichier weather.json afin d'en comprendre sa structure, puis complète la classe Parse.
1.
Récupérer la racine du document
2.
Récupérer la valeur la propriété "name"
3.
Récupérer les valeurs des propriétés "lat" et "lon" du noeud "coord"
4.
Convertir le noeud "wind" en objet Wind (la classe existe déjà)
5.
Convertir le noeud "weather" en tableau de Weather (la classe existe déjà)
6.
Compiler et exécuter le code afin d'obtenir l'affichage du résultat attendu
7.
Envoie les modifications vers ton dépôt distant et partage le lien du fork en solution
Résultat attendu :
City name: London
City latitude: 51.51
City longitude: -0.13
Wind infos: src.main.Wind{speed=4.1, deg=80.0}
Weather infos: src.main.Weather{id=300, main='Drizzle', description='light intensity drizzle', icon='09d'}
Weather infos: src.main.Weather{id=800, main='Clear', description='clear sky', icon='01n'}

Shell
Tu pourras compiler et exécuter ton code avec la commande suivante :
./tester.sh

Critères de validation :
•
En compilant et exécutant le fichier, le résultat attendu est affiché
•
La classe Parse fait bien un parsing du fichier weather.json pour analyser son contenu
Franck Desmedt s’est engagé(e) dans l’aventure il y a 16 heures
FD
*Poste le lien vers ta solution
Nous te sollicitons pour évaluer cette quête
*Combien de temps t'as pris cette quête ?
1 heure maxi
Entre 1h et 4h
Entre 4h et 8h
Plus de 8h
*Comment as tu trouvé cette quête ?
Excellente, j'ai tout compris
Bien, j'ai compris
Assez compliquée
Je n'ai rien compris...
Si tu n'as pas apprécié cette quête, peux-tu nous expliquer pourquoi ?
N'oublis pas d'évaluer la quête


MeasureMeasure
CODE

{
  "coord": {
    "lon": -0.13,
    "lat": 51.51
  },
  "weather": [
    {
      "id": 300,
      "main": "Drizzle",
      "description": "light intensity drizzle",
      "icon": "09d"
    },
    {
      "id": 800,
      "main": "Clear",
      "description": "clear sky",
      "icon": "01n"
    }
  ],
  "base": "stations",
  "main": {
    "temp": 280.32,
    "pressure": 1012,
    "humidity": 81,
    "temp_min": 279.15,
    "temp_max": 281.15
  },
  "visibility": 10000,
  "wind": {
    "speed": 4.1,
    "deg": 80
  },
  "clouds": {
    "all": 90
  },
  "dt": 1485789600,
  "sys": {
    "type": 1,
    "id": 5091,
    "message": 0.0103,
    "country": "GB",
    "sunrise": 1485762037,
    "sunset": 1485794875
  },
  "id": 2643743,
  "name": "London",
  "cod": 200
}










