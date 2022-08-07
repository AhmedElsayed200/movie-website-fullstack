import React from "react";
import "./MoviePage.css";
import { Link } from "react-router-dom";

const MoviePage = (props) => {
  const imagesURL = "https://image.tmdb.org/t/p";
  const imageSize = "w500";
  const imageSource = `${imagesURL}/${imageSize}`;

  const handleShowMovieDetails = (id) => {
    props.getMovieDetails(id);
  };

  const moviesPerPage = props.moviesPerPage.map((movie) => {
    return (
      <Link
        to={`/movies/${movie.id}`}
        key={movie.id}
        className="movie-card"
        onClick={handleShowMovieDetails}
      >
        <div className="movie-image">
          <img
            src={`${imageSource}/${movie.poster_path}`}
            alt={movie.title}
            className="primary-movie-image"
          />
        </div>
        <div className="movie-name">{movie.title}</div>
      </Link>
    );
  });

  return <div className="movie-page">{moviesPerPage}</div>;
};

export default MoviePage;
