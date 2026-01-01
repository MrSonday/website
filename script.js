
document.addEventListener('DOMContentLoaded', function() {
  const modal = document.getElementById('imageModal');
  const closeBtn = modal ? modal.querySelector('.close') : null;
  const modalImage = document.getElementById('modalImage');
  const captionText = document.getElementById('caption');

  const galleryItems = Array.from(document.querySelectorAll('.gallery-item'));
  const images = galleryItems.map(item => {
    const img = item.querySelector('img');
    return img ? { src: img.src, alt: img.alt || '' } : null;
  }).filter(Boolean);

  let currentIndex = 0;

  function openModal(index) {
    if (!modal || !modalImage) return;
    currentIndex = (index + images.length) % images.length;
    modalImage.src = images[currentIndex].src;
    captionText.textContent = images[currentIndex].alt;
    modal.style.display = 'block';
  }

  function closeModal() {
    if (!modal) return;
    modal.style.display = 'none';
  }

  galleryItems.forEach((item, idx) => {
    const img = item.querySelector('img');
    if (!img) return;
    img.addEventListener('click', function(e) {
      openModal(idx);
    });
  });

  if (closeBtn) {
    closeBtn.addEventListener('click', closeModal);
  }

  if (modal) {
    modal.addEventListener('click', function(event) {
      if (event.target === modal) closeModal();
    });
  }

  document.addEventListener('keydown', function(event) {
    if (!modal || modal.style.display !== 'block') return;
    if (event.key === 'Escape') closeModal();
    if (event.key === 'ArrowRight') openModal(currentIndex + 1);
    if (event.key === 'ArrowLeft') openModal(currentIndex - 1);
  });
});
