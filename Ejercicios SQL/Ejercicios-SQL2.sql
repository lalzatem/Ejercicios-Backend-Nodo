/* 1. Utilizando la base de datos de movies, queremos conocer, por un lado, 
los títulos y el nombre del género de todas las series de la base de datos. */
SELECT series.title, genres.name AS genero
FROM series
INNER JOIN genres
ON series.genre_id = genres.id;


/* 2. Por otro lado, necesitamos listar los títulos de los episodios junto 
con el nombre y apellido de los actores que trabajan en cada uno de ellos. */
SELECT episodes.title, actors.first_name, actors.last_name
FROM actor_episode
INNER JOIN actors
ON actors.id = actor_episode.actor_id
INNER JOIN episodes
ON episodes.id = actor_episode.episode_id;


/* 3. Para nuestro próximo desafío, necesitamos obtener a todos los actores 
o actrices (mostrar nombre y apellido) que su película favorita sea 
cualquiera de la saga de La Guerra de las Galaxias. */
SELECT actors.first_name, actors.last_name, movies.title
FROM actors
INNER JOIN movies
ON actors.favorite_movie_id = movies.id
WHERE movies.title LIKE "%Guerra de las Galaxias%";


/* 4. Para nuestro próximo desafío, necesitamos obtener a todos los actores 
o actrices (mostrar nombre y apellido) que han trabajado en cualquier 
película de la saga de La Guerra de las Galaxias. */
SELECT DISTINCT actors.first_name, actors.last_name, movies.title
FROM actor_movie
INNER JOIN actors ON actors.id = actor_movie.actor_id
INNER JOIN movies ON movies.id = actor_movie.movie_id
WHERE movies.title LIKE "%Guerra de las Galaxias%";

/* 5. Crear un listado a partir de la tabla de películas, mostrar un reporte 
de la cantidad de películas por nombre de género. */
SELECT genres.name, COUNT(movies.id)
FROM movies,genres
WHERE movies.genre_id = genres.id
GROUP BY genres.id;

SELECT genres.name, COUNT(movies.id)
FROM movies
INNER JOIN genres ON movies.genre_id = genres.id
GROUP BY genres.id;
