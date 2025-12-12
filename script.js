
const modal = document.getElementById("imageModal");
const closeBtn = document.querySelector(".close");
const modalImage = document.getElementById("modalImage");
const captionText = document.getElementById("caption");


const galleryItems = document.querySelectorAll(".gallery-item");

galleryItems.forEach(item => {
    const img = item.querySelector("img");
    img.addEventListener("click", function() {
        modal.style.display = "block";
        modalImage.src = this.src;
        captionText.textContent = this.alt;
    });
});

closeBtn.addEventListener("click", function() {
    modal.style.display = "none";
});

modal.addEventListener("click", function(event) {
    if (event.target === modal) {
        modal.style.display = "none";
    }
});


document.addEventListener("keydown", function(event) {
    if (event.key === "Escape") {
        modal.style.display = "none";
    }
});

// Auto-scroll gallery to the right on load (so images appear shifted to the right)
(function() {
    const imageGallery = document.querySelector('.image-gallery');
    if (!imageGallery) return;

    function scrollGalleryToRight() {
        // Move scroll to the maximum (right-most)
        imageGallery.scrollLeft = imageGallery.scrollWidth;
    }

    // On load and shortly after resize, ensure gallery is scrolled to right
    window.addEventListener('load', scrollGalleryToRight);
    window.addEventListener('resize', () => setTimeout(scrollGalleryToRight, 120));
    // If images are added later, observer will scroll to right
    const ro = new MutationObserver(() => setTimeout(scrollGalleryToRight, 100));
    ro.observe(imageGallery, { childList: true, subtree: true });
})();
