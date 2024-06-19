const prevButton = document.getElementById("prevBtn");
const nextButton = document.getElementById("nextBtn");
const slides = document.querySelector(".slides");

let counter = 0;
const slideCount = document.querySelectorAll(".slide").length;

prevButton.addEventListener("click", () => {
    counter--;
    if (counter < 0) {
        counter = slideCount - 1;
    }
    updateSlidePosition();
});

nextButton.addEventListener("click", () => {
    counter++;
    if (counter >= slideCount) {
        counter = 0;
    }
    updateSlidePosition();
});

function updateSlidePosition() {
    slides.style.transform = `translateX(${-counter * 100}%)`;
}
