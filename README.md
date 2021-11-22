# M223 Punchclock

Folgende Schritte sind notwendig um die Applikation zu erstellen und zu starten: 
1. Stellen Sie sicher, dass OpenJDK 11 oder höher installiert und JAVA_HOME korrekt gesetzt ist.  
2. Installieren Sie (falls noch nicht vorhanden) Apache Maven 3.8.1 oder höher
3. Wechseln Sie auf der Kommandozeile in den Ordner dieser Applikation. 
`cd m223-punchclock-quarkus/`
4. Starten Sie die Applikation mit 
```shell script
./mvnw compile quarkus:dev
```

Link zur Git-Repository: https://github.com/anderson-robert/m223-punchclock-quarkus

Datenimport unter `/src/main/resources/import.sql`

Default Benutzer
Benutzername: zli
Passwort: secret

Folgende Dienste stehen während der Ausführung im Profil dev zur Verfügung:

Swagger API: http://localhost:8080/q/swagger-ui/

H2 Console: http://localhost:8080/h2/ 
Datenquelle: jdbc:h2:mem:punchclock
Benutzername: zli
Passwort: zli

Abweichungen zur Planung:
Die EntryType Tabelle wurde durch die schon existierende Category Tabelle ersetzt, denn die Tabelle die gleichen Funktion hatten.
Der Erstellung von Entries funktioniert momentan nicht von der Frontend aus, sondern nur direkt über die Schnittstelle.

