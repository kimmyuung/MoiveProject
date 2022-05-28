
let submit = document.querySelector("#submit");
let movieGrid = document.querySelector(".movie-grid");

submit.addEventListener("click", getMovies);

function getMovies() {
  clearScreen();
  const searchResult = document.getElementById("movie");
  let query = searchResult.value.replace(/\s/g, "+"); // Replaces the spaces in the string with +
  const proxy = `https://cors-anywhere.herokuapp.com/`;
  const url = `${proxy}http://www.omdbapi.com/?s=${query}&apikey=thewdb`;
  const promise = fetch(url);
  promise
    .then(function getDataJSON(response) {
      return response.json();
    })
    .then(function getDatafromAPI(data) {
      // console.log(data);
      populateResult(data);
      // console.log(data.Search[0].Poster);
    });
}

function populateResult(data) {
  for (let i = 0; i < data.Search.length; i++) {
    let imdbURL = `https://www.imdb.com/title/${data.Search[i].imdbID}/`;
    const div = document.createElement("div");
    if (data.Search[i].Poster != "N/A") {
      div.style.backgroundImage = `url('${data.Search[i].Poster}')`;
    } else {
      div.style.backgroundImage = `url('https://i.ya-webdesign.com/images/image-not-available-png-3.png')`
      // div.innerHTML = `<h2 class="notAvailable">Image Not Available</h2>`;
      // div.classList.add("notAvailable");
    }
    div.classList.add("movie");
    const title = document.createElement("h1");
    title.innerHTML = `<a href="${imdbURL}" target="_blank">${data.Search[i].Title}</a>`; 
    title.classList.add("movieTitle");
    div.appendChild(title);
    movieGrid.appendChild(div);
  }
}

function clearScreen() {
  movieGrid.innerHTML = "";
}
