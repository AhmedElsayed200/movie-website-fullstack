import React from "react";
import "./PageManipulation.css";

const PageManipulation = (props) => {
    const handlePageManipulation = (e, num) => {
        props.changePage(num)
    }

    return (
        <div className="page-manipulation">
            <button className="left-arrow arrow" onClick={(e) => handlePageManipulation(e, -1)}>&#8249;</button>
            <button className="right-arrow arrow" onClick={(e) => handlePageManipulation(e, 1)}>&#8250;</button>
        </div>
    )
}

export default PageManipulation;