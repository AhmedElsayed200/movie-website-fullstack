import React from "react";
import "./MoviePage.css";

const MoviePage = (props) => {
  const imagesURL = "https://image.tmdb.org/t/p";
  const imageSize = "w500";
  const imageSource = `${imagesURL}/${imageSize}`;

  const handleShowMovieDetails = (id) => {
    props.getMovieDetails(id);
  };

  const moviesPerPage = props.moviesPerPage.map((movie) => {
    return (
      <div
        key={movie.id}
        className="movie-card"
        onClick={handleShowMovieDetails}
      >
        <div className="movie-img">
          <img src={`${imageSource}/${movie.poster_path}`} alt={movie.title} />
        </div>
        <div className="movie-name">{movie.title}</div>
      </div>
    );
  });

  return <div className="movie-page">{moviesPerPage}</div>;
};

export default MoviePage;
