import React from "react";
import axios from "axios";
import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import "./MainPage.css";
import { useState, useEffect } from "react";
import { MoviePageAPI, SearchMovieAPI } from "../../Fetch Data/APIs";
import MoviePage from "../Movie Page/MoviePage";
import SearchBar from "../Search Bar/SearchBar";
import PageManipulation from "../Page Manipulation/PageManipulation";
import MovieDetails from "../Movie Details/MovieDetails";

const MainPage = () => {
  const [pageNumber, setPageNumber] = useState(1);
  const [moviesPerPage, setMoviesPerPage] = useState([]);
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

  const changePage = (page) => {
    let newPage = pageNumber + page;
    if (newPage >= 1 || newPage <= 100) setPageNumber(newPage);
    setSearchKey("");
  };

  const setSearch = (txt) => {
    setSearchKey(txt);
  };

  const moviesPage = (
    <div className="main-page">
      <SearchBar searchKey={searchKey} setSearch={setSearch} />
      <MoviePage moviesPerPage={moviesPerPage} />
      <PageManipulation changePage={changePage} />
    </div>
  );

  const websiteName = <div className="website-name">Cinemy</div>;

  return (
    <BrowserRouter>
      {websiteName}
      <Routes>
        <Route path="/movies" element={moviesPage} />
        <Route path="/movies/:movieTitle/:movieID" element={<MovieDetails />} />
        <Route path="*" element={<Navigate to="/movies" replace />} />
      </Routes>
    </BrowserRouter>
  );
};

export default MainPage;
