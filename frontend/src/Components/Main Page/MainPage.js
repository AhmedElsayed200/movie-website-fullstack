import React from "react";
import axios from "axios";
import "./MainPage.css";
import { useState, useEffect } from "react";
import { MoviePageAPI, SearchMovieAPI } from "../../Fetch Data/APIs";
import MoviePage from "../Movie Page/MoviePage";
import SearchBar from "../Search Bar/SearchBar";
import PageManipulation from "../Page Manipulation/PageManipulation";

const MainPage = () => {
  const [pageNumber, setPageNumber] = useState(1);
  const [moviesPerPage, setMoviesPerPage] = useState([]);
  const [movieDetails, setMovieDetails] = useState({});
  const [searchKey, setSearchKey] = useState("");

  useEffect(() => {
    let API;
    if (searchKey.length >= 3) {
      API = SearchMovieAPI + searchKey;
    } else {
      API = MoviePageAPI + pageNumber;
    }
    axios
      .get(API)
      .then((res) => {
        console.log(res.data.results);
        setMoviesPerPage(res.data.results);
      })
      .catch((err) => console.log(err));
  }, [pageNumber, searchKey]);

  const getMovieDetails = (id) => {
    setMovieDetails(id);
  };

  const changePage = (page) => {
    let newPage = pageNumber + page;
    if (newPage >= 1 || newPage <= 100) setPageNumber(newPage);
    setSearchKey("");
  };

  const setSearch = (txt) => {
    setSearchKey(txt);
  };

  return (
    <div className="main-page">
      <div className="website-name">Cinemy</div>
      <SearchBar searchKey={searchKey} setSearch={setSearch} />
      <MoviePage
        moviesPerPage={moviesPerPage}
        getMovieDetails={getMovieDetails}
      />
      <PageManipulation changePage={changePage} />
    </div>
  );
};

export default MainPage;
