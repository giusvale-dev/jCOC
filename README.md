# jCOC
jCOC (Java Clash of Clans API) jCOC is an open-source Java API designed to provide developers with easy access to Clash of Clans game data and statistics. Whether you're building a Clash of Clans companion app, a clan management tool, or simply want to explore the game's data programmatically, jCOC simplifies the process.

# How to use

``` java
JCoc jcoc = new JCoc("API_TOKEN"); //If you have an API_TOKEN

//Use it
jcoc.clanWar();
```
or 
``` java
JCoc jcoc = new JCoc("username", "password"); //If you want generate a new API_TOKEN with the host ip address

//Use it
jcoc.clanWar();
```

# How to test
Before to test is needed to add your credentials in the application.properties file.
By default this file is ignored from GIT (added in the .gitignore) then you can run the tests in your ide or with mvn command.
