import React from "react";
import "./PageManipulation.css";

const PageManipulation = (props) => {
    const handlePageManipulation = (e, num) => {
        props.changePage(num)
    }

    return (
        <div className="page-manipulation">
            <button className="left-arrow" onClick={(e) => handlePageManipulation(e, -1)}>&laquo;{" Previous"}</button>
            <button className="right-arrow" onClick={(e) => handlePageManipulation(e, 1)}>{"Next "} &raquo;</button>
        </div>
    )
}

export default PageManipulation;