// Mock API data - Replace with your actual API endpoint
const API_BASE_URL = 'http://localhost:5000/api/v1.0';

// Sample product data (replace with actual API call)
const mockProducts = [
    {
        id: 1,
        name: "Moringa Leaf Powder",
        description: "Pure, organic moringa leaf powder packed with vitamins and minerals. Perfect for smoothies and cooking.",
        price: 24.99,
        stock: 45,
        image: "🌿"
    },
    {
        id: 2,
        name: "Moringa Capsules",
        description: "Convenient moringa leaf capsules for daily supplementation. 60 capsules per bottle.",
        price: 19.99,
        stock: 23,
        image: "💊"
    },
    {
        id: 3,
        name: "Moringa Tea Bags",
        description: "Refreshing moringa tea bags for a healthy and energizing beverage. 20 bags per box.",
        price: 15.99,
        stock: 67,
        image: "🍵"
    },
    {
        id: 4,
        name: "Moringa Oil",
        description: "Premium cold-pressed moringa oil for skincare and cooking. 100ml bottle.",
        price: 32.99,
        stock: 12,
        image: "🫒"
    },
    {
        id: 5,
        name: "Moringa Seeds",
        description: "Raw moringa seeds for planting or consumption. Rich in nutrients and antioxidants.",
        price: 18.99,
        stock: 0,
        image: "🌱"
    },
    {
        id: 6,
        name: "Moringa Protein Powder",
        description: "High-protein moringa powder blend perfect for post-workout nutrition and smoothies.",
        price: 39.99,
        stock: 31,
        image: "💪"
    }
];

// Function to get stock badge class and text
function getStockInfo(stock) {
    if (stock === 0) {
        return { class: 'out', text: 'Out of Stock' };
    } else if (stock < 20) {
        return { class: 'low', text: `${stock} left` };
    } else {
        return { class: '', text: `${stock} in stock` };
    }
}

// Function to render products
function renderProducts(products) {
    const container = document.getElementById('productsContainer');
    const inStockProducts = products.filter(product => product.stock > 0);
    
    // Update stock status in header
    document.getElementById('stockCount').textContent = inStockProducts.length;
    
    if (products.length === 0) {
        container.innerHTML = `
            <div class="loading">
                <p>No products available at the moment.</p>
            </div>
        `;
        return;
    }

    const productsHTML = products.map(product => {
        const stockInfo = getStockInfo(product.stock);
        return `
            <div class="product-card">
                <div class="product-image">
                    ${product.image}
                </div>
                <div class="product-info">
                    <h3 class="product-name">${product.name}</h3>
                    <p class="product-description">${product.desc}</p>
                    <div class="product-details">
                        <span class="product-price">$${product.price}</span>
                        <span class="stock-badge ${stockInfo.class}">${stockInfo.text}</span>
                    </div>
                    <button class="contact-btn" ${product.stock === 0 ? 'disabled' : ''} 
                            onclick="contactForProduct('${product.name}')">
                        ${product.stock === 0 ? 'Out of Stock' : 'Contact for Order'}
                    </button>
                </div>
            </div>
        `;
    }).join('');

    container.innerHTML = `<div class="products-grid">${productsHTML}</div>`;
}

// Function to handle contact for product
function contactForProduct(productName) {
    alert(`Thank you for your interest in ${productName}! Please contact us at info@moringamark.com or call +1 (555) 123-4567 to place your order.`);
}

// Function to fetch products from API
async function fetchProducts() {
    try {
        // Replace this with your actual API call
        const response = await fetch(`${API_BASE_URL}/products`);
        const products = await response.json();
        
        // // Simulate API delay
        // await new Promise(resolve => setTimeout(resolve, 1500));
        
        // Use mock data for now
        renderProducts(products);
    } catch (error) {
        console.error('Error fetching products:', error);
        document.getElementById('productsContainer').innerHTML = `
            <div class="loading">
                <p>Error loading products. Please try again later.</p>
            </div>
        `;
    }
}

// Initialize the page
document.addEventListener('DOMContentLoaded', function() {
    fetchProducts();
});

// Optional: Auto-refresh products every 5 minutes
setInterval(fetchProducts, 300000);