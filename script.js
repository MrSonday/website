document.addEventListener('DOMContentLoaded', () => {
    const modal = document.getElementById('imageModal');
    const modalImage = document.getElementById('modalImage');
    const captionText = document.getElementById('caption');
    const closeBtn = document.querySelector('.close');
    const galleryImages = document.querySelectorAll('.gallery-item img');

    let currentIndex = 0;

    // Fungsi membuka modal
    const openModal = (index) => {
        currentIndex = (index + galleryImages.length) % galleryImages.length;
        modalImage.src = galleryImages[currentIndex].src;
        captionText.textContent = galleryImages[currentIndex].alt;
        modal.style.display = 'block';
    };

    // Event listener untuk setiap gambar di gallery
    galleryImages.forEach((img, idx) => {
        img.addEventListener('click', () => openModal(idx));
    });

    // Event klik untuk tutup modal (tombol X atau klik area luar)
    [closeBtn, modal].forEach(element => {
        element?.addEventListener('click', (e) => {
            if (e.target === modal || e.target === closeBtn) modal.style.display = 'none';
        });
    });

    // Kontrol Keyboard
    document.addEventListener('keydown', (e) => {
        if (modal.style.display !== 'block') return;
        if (e.key === 'Escape') modal.style.display = 'none';
        if (e.key === 'ArrowRight') openModal(currentIndex + 1);
        if (e.key === 'ArrowLeft') openModal(currentIndex - 1);
    });
});