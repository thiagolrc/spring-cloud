# Zuul
Zuul reverse proxy: automatically discover services in eureka and registers URL paths that map each application.

Example: http://localhost:8080/api/app-greeting && http://localhost:8080/api/app-person

#### ETag
Refresh the http://localhost:8080/api/app-greeting several times and notice that ever time the response repeat we get an http 304

#### Gateway motivation
* Prevent internal API to be exposed
* Manage security in one single place
* Avoid CORS (Cross-Origin Resource Sharing)
* Avoid multiple trips client->server (gateway works as a facade)
* Custom API according to each client type 
* Deal with protocol translation
* Manage caching
* Do link expansion

 

