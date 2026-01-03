// Cart functionality
let cartCount = 0;

document.querySelectorAll('.add-to-cart').forEach(button => {
    button.addEventListener('click', function() {
        cartCount++;
        updateCartCount();
        
        // Show feedback
        const originalText = this.textContent;
        this.textContent = 'Added! ✓';
        this.style.backgroundColor = '#27ae60';
        
        setTimeout(() => {
            this.textContent = originalText;
            this.style.backgroundColor = '';
        }, 1500);
    });
});

function updateCartCount() {
    document.querySelector('.cart-count').textContent = cartCount;
}

// Category Filter functionality
const categoryBtns = document.querySelectorAll('.category-btn');
const productCards = document.querySelectorAll('.product-card');

// Show all products on page load
window.addEventListener('DOMContentLoaded', function() {
    productCards.forEach(card => card.classList.add('show'));
});

categoryBtns.forEach(btn => {
    btn.addEventListener('click', function() {
        const selectedCategory = this.getAttribute('data-category');
        
        // Update active button
        categoryBtns.forEach(b => b.classList.remove('active'));
        this.classList.add('active');
        
        // Filter products
        productCards.forEach(card => {
            if (selectedCategory === 'all') {
                card.classList.add('show');
            } else {
                const cardCategory = card.getAttribute('data-category');
                if (cardCategory === selectedCategory) {
                    card.classList.add('show');
                } else {
                    card.classList.remove('show');
                }
            }
        });
    });
});

// Shop Now button
document.querySelector('.cta-btn').addEventListener('click', function() {
    document.querySelector('#products').scrollIntoView({ behavior: 'smooth' });
});

// Contact form
document.querySelector('.contact-form').addEventListener('submit', function(e) {
    e.preventDefault();
    alert('Thank you for your message! We will get back to you soon.');
    this.reset();
});

// Smooth scrolling for navigation links
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function(e) {
        e.preventDefault();
        const target = document.querySelector(this.getAttribute('href'));
        if (target) {
            target.scrollIntoView({ behavior: 'smooth' });
        }
    });
});
