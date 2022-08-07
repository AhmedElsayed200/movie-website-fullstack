import "./SearchBar.css";

const SearchBar = (props) => {
  const handleSearch = (e) => {
    props.setSearch(e.target.value);
  };

  return (
    <div className="search-bar">
      <form>
        <input
          type="text"
          className="input-text"
          onChange={handleSearch}
          value={props.searchKey}
          placeholder="Search..."
        />
      </form>
    </div>
  );
};

export default SearchBar;
