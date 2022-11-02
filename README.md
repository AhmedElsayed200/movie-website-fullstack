# Movie app fullstack

## Overview

A movie web app created with react.js as a frontend and java - spring boot as a backend.

## About the project

- In the current version, there are three movie stories; the user can:

- **Get all popular movies:** [pagination exists in the created API]. The user would go to localhost:3000/movies to see all the popular movies. Each page contains 20 movies and there are arrow buttons to make the user move around from one page to another.
- **Search for any movie:** there is a search bar at the home page that the user can use to search for a specific movie. The user has to add at least 3 characters to initiate the search.
- **Get the movie details:**. If a user wants to see more information about a movie, all he has to do is to click on the movie card on the home page.

### Next version

- **More movie details**. The user would be able to watch the movie, download it, and rate it.
- **Get all movies of certain category**. The user would be able to search for a genre in the search bar to get all the movies related to the input genre.

## Dependencies

The dependencies used in this application with its version:

- "@apollo/client": "^3.5.10"
- "react": "^17.0.2"
- "react-dom": "^17.0.2"
- "react-scripts": "5.0.0"

## How to run the project

1. Download and install [nodejs](https://nodejs.org/en/download/)
2. Download or clone this repository.
3. In the backend folder: run the server
4. In the frontend folder:
   1. Install the dependencies: `npm install`
   2. Build the project: `npm run build`
   3. Start the project: `npm start`

## Docker images

1. Go to this link to pull the backend image and run it: https://hub.docker.com/r/ahmedelsayed200/movie-backend
   - Pull the image using this command: `docker pull ahmedelsayed200/movie-backend`
   - Run the image using this command: `docker run --publish 3000:3000 ahmedelsayed200/movie-backend`
2. Go to this link to pull the backend image and run it: https://hub.docker.com/r/ahmedelsayed200/movie-frontend
   - Pull the image using this command: `docker pull ahmedelsayed200/movie-frontend`
   - Run the image using this command: `docker run -p 8080:8080 ahmedelsayed200/movie-frontend`

> The website is now working, hope you enjoy it 😃
