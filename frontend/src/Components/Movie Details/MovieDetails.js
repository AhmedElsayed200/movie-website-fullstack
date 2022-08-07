import React, { useState, useEffect } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";
import { getMovieDetailsAPI } from "../../Fetch Data/APIs";
import "./MovieDetails.css";

const MovieDetails = () => {
  const [movieDetails, setMovieDetails] = useState({});

  let params = useParams();

  const imagesURL = "https://image.tmdb.org/t/p";
  const imageSize = "w500";
  const imageSource = `${imagesURL}/${imageSize}`;

  useEffect(() => {
    let API = getMovieDetailsAPI + params.movieID;
    axios
      .get(API)
      .then((res) => {
        console.log(res.data);
        setMovieDetails(res.data);
      })
      .catch((err) => console.log(err));
  }, []);

  return (
    <div className="movie-details">
      <div className="movie-image">
        <img
          src={`${imageSource}/${movieDetails.poster_path}`}
          alt={movieDetails.title}
        />
      </div>
      <div className="movie-info">
        <div className="info-txt movie-details-name">{movieDetails.title}</div>
        <div className="info-txt movie-date">
          Release Date: {movieDetails.release_date}
        </div>
        {/* <div className="movie-genres">
          {movieDetails.genres.map((genre) => (
            <p className="movie-genre" key={genre.id}>
              {genre.name}
            </p>
          ))}
        </div> */}
        <div className="info-txt vote-average">
          Rate: {movieDetails.vote_average}
        </div>
        <div className="info-txt vote-count">
          Voters number: {movieDetails.vote_count}
        </div>
      </div>
    </div>
  );
};

export default MovieDetails;
