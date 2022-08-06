import React, { useState } from "react";
import "./SearchBar.css";

const SearchBar = (props) => {
  const [searchKey, setSearchKey] = useState("");
  const handleSearch = (e) => {
    e.preventDefault();
    props.setSearch(searchKey);
  };

  return (
    <div className="search-bar">
      <form onSubmit={handleSearch}>
        <input
          type="text"
          className="input-text"
          onChange={(e) => setSearchKey(e.target.value)}
          value={searchKey}
          placeholder="search for a movie"
        />
      </form>
    </div>
  );
};

export default SearchBar;
