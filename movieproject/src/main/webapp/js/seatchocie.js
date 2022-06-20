


const allSeatCont = document.querySelectorAll("#seatCont .seat");

const selectedSeatsHolderEl = document.getElementById("selectedSeatsHolder");

const moviePriceEl = document.getElementById("moviePrice");

const cancelBtnEL = document.getElementById("cancelBtn");

const proceedBtnEl = document.getElementById("proceedBtn");



let initialSeatValue = 0;
allSeatCont.forEach((seat) => {
  const attr = document.createAttribute("data-seatid");
  attr.value = ++initialSeatValue;
  seat.setAttributeNode(attr);
});

const seatContEl = document.querySelectorAll("#seatCont .seat:not(.occupied)");

let takenSeats = [];

seatContEl.forEach((seat) => {
  seat.addEventListener("click", (e) => {
    let isSelected = seat.classList.contains("selected");

    let seatId = JSON.parse(seat.dataset.seatid);

    if (!isSelected) {
      seat.classList.add("selected");
      takenSeats.push(seatId);
      takenSeats = [...new Set(takenSeats)];
    } else if (isSelected) {
      seat.classList.remove("selected");

      takenSeats = takenSeats.filter((seat) => {
        if (seat !== seatId) {
          return seat;
        }
      });
    }
    updateSeats();
    updatePrice(moviePrice, takenSeats.length);
  });
});

function updateSeats() {
  selectedSeatsHolderEl.innerHTML = ``;

  takenSeats.forEach((seat) => {
    const seatHolder = document.createElement("div");
    seatHolder.classList.add("selectedSeat");
    selectedSeatsHolderEl.appendChild(seatHolder);

    seatHolder.innerHTML = seat;
  });

  if (!takenSeats.length) {
    const spanEl = document.createElement("span");
    spanEl.classList.add("noSelected");
    spanEl.innerHTML = `NO SEAT SELECTED`;
    selectedSeatsHolderEl.appendChild(spanEl);
  }

  seatCount();
}

function seatCount() {
  const numberOfSeatEl = document.getElementById("numberOfSeat");
  numberOfSeatEl.innerHTML = takenSeats.length;
}

function updatMovieName(movieName, price) {
  const movieNameEl = document.getElementById("movieName");
  const moviePriceEl = document.getElementById("moviePrice");
  movieNameEl.innerHTML = movieName;
  
}

function updatePrice(price, seats) {
	let mprice = $("#moviePrice").val();
  const totalPriceEl = document.getElementById("totalPrice");
  let total = seats * mprice;
  totalPriceEl.innerHTML = ` ${total} 원`;
}

cancelBtn.addEventListener("click", (e) => {
  cancelSeats();
});

function cancelSeats() {
  takenSeats = [];
  seatContEl.forEach((seat) => {
    seat.classList.remove("selected");
  });
  updatePrice(0, 0);
  updateSeats();
}

function successModal(movieNameIn, totalPrice, successTrue) {
  const bodyEl = document.querySelector("body");

  const sectionEl = document.getElementById("section");

  const overlay = document.createElement("div");

  overlay.classList.add("overlay");

  sectionEl.appendChild(overlay);

  const successModal = document.createElement("div");
  successModal.classList.add("successModal");
  const modalTop = document.createElement("div");
  modalTop.classList.add("modalTop");
  const popImg = document.createElement("img");
  popImg.src =
    "https://github.com/Dinesh1042/Vanilla-JavaScript-Projects/blob/main/Movie%20Booking/asset/pop.png?raw=true";
  modalTop.appendChild(popImg);

  successModal.appendChild(modalTop);

  // Modal Center

  const modalCenter = document.createElement("div");
  const modalHeading = document.createElement("h1");
  modalCenter.classList.add("modalCenter");
  modalHeading.innerHTML = `좌석 예약이 성공하였습니다.`;
  modalCenter.appendChild(modalHeading);
  const modalPara = document.createElement("p");
  modalCenter.appendChild(modalPara);
  modalPara.innerHTML = `${movieNameIn} 좌석 선택이 완료되었습니다. 결제창으로 이동합니다.`;
  successModal.appendChild(modalCenter);

  // modal Bottom

  const modalBottom = document.createElement("div");
  modalBottom.classList.add("modalBottom");
  const successBtn = document.createElement("button");

  successBtn.innerHTML = `결제하러 가기`;
  modalBottom.appendChild(successBtn);
  successModal.appendChild(modalBottom);

  successBtn.addEventListener("click", (e) => {
    removeModal();
  });

  window.addEventListener("click", (e) => {
    if (e.target.classList.contains("overlay")) {
      removeModal();
    }
  });

  function removeModal() {
    overlay.remove();
    successModal.remove();
    bodyEl.classList.remove("modal-active");
    cancelSeats();
  }

  sectionEl.appendChild(successModal);
}

proceedBtnEl.addEventListener("click", (e) => {
  if (takenSeats.length) {
    const bodyEl = document.querySelector("body");
    bodyEl.classList.add("modal-active");
    successModal(currentMovieName, moviePrice * takenSeats.length);
  } else {
    alert("좌석 선택을 해주세요");
  }
});