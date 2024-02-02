let productService = {
  allProducts: [
    {
      "productId": 1,
      "productSku": "HAI-023",
      "name": "George's Hair",
      "description": "I don't like this thing!!!",
      "price": 5.99,
      "imageName": "George's Hair.jpg"
    },
    {
      "productId": 2,
      "productSku": "PAS-001",
      "name": "Fuscili Jerry",
      "description": "You know the corkscrew pasta. It was Fuscili Jerry. It got stuck in me.",
      "price": 99.99,
      "imageName": "jerry.jpg"
    },
    {
      "productId": 3,
      "productSku": "CAR-256",
      "name": "Elaine's Christmas Card",
      "description": "Free Show",
      "price": 0.00,
      "imageName": "card.jpg"
    },
    {
      "productId": 4,
      "productSku": "PEN-978",
      "name": "Astronaut Pen",
      "description": "Astronauts use it to write in space!",
      "price": 9999.99,
      "imageName": "Pen.webp"
    },
    {
      "productId": 5,
      "productSku": "PEZ-235",
      "name": "Tweety PEZ Dispenser",
      "description": "Great for an eveming at the symphony!",
      "price": 1.79,
      "imageName": "pez.jpg"
    },
    {
      "productId": 6,
      "productSku": "RYE-928",
      "name": "Rye Bread",
      "description": "I know this sounds crazy but, I have to have that rye.",
      "price": 2.89,
      "imageName": "bread.jpg"
    },
    {
      "productId": 7,
      "productSku": "CIG-612",
      "name": "Cigar Indian",
      "description": "Not a very good gift",
      "price": 499.99,
      "imageName": "Cigar.jpg"
    }
  ],

  getProducts() {
    return this.allProducts;
  },

};
