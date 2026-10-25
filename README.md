Film-Watchlist
Eine Web-App, um Filme zu sammeln, die Freunde und Bekannte empfohlen haben.
Zu jedem Film speichert man Titel, Genre, Jahr, ob man ihn gesehen hat,
wer ihn empfohlen hat und was die Person dazu meinte.
Das IMDb-Rating wird automatisch über die OMDb-API geladen.

Team
Yurii
Starten
$env:OMDB_API_KEY=<eigener-key> (optional, sonst kein Rating)
./gradlew bootRun
Browser: http://localhost:8080/movies
