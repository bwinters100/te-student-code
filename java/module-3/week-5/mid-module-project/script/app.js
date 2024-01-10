document.addEventListener("DOMContentLoaded", handleDOMContentLoaded);

function handleDOMContentLoaded(){
    let cards = document.getElementById("product-cards");
    let children = document.querySelectorAll(".product-card");
    children.forEach((item) => {
        cards.removeChild(item);
    })
    let products = productService.getProducts();
    products.forEach(product =>{
        let article = document.createElement("article");
        cards.appendChild(article);
        article.classList.add("product-card");
        let divSku = document.createElement("div");
        article.appendChild(divSku);
        divSku.classList.add("sku");
        divSku.innerText = product.productSku

        let divPrice = document.createElement("div");
        article.appendChild(divPrice);
        divPrice.classList.add("price");
        divPrice.innerText = product.price;

        let divName = document.createElement("div");
        article.appendChild(divName);
        divName.classList.add("product-name");
        divName.classList.add("action");
        divName.innerText = product.name;
        divName.setAttribute("data-id", product.productId);
        divName.addEventListener("click", handleNameClick);

        let divImage = document.createElement("div");
        article.appendChild(divImage);
        let img = document.createElement("img");
        divImage.appendChild(img);
        divImage.classList.add("product-image");
        img.setAttribute("src", product.imageName);

        let divCart = document.createElement("div");
        article.appendChild(divCart);
        let cart = document.createElement("i");
        divCart.appendChild(cart);
        divCart.classList.add("cart");
        cart.classList.add("fa-solid");
        cart.classList.add("fa-cart-plus");
        cart.classList.add("icon");
        cart.classList.add("action");
        cart.setAttribute("title", "Add item to cart")
    })
}

    function handleNameClick(event){
         let divClick = event.target;
         let id = divClick.getAttribute("data-id");
         let products = productService.getProducts();
         let product = products.find((item) => {
             if(item.productId == id){
                 return true;
             }
             else{
                 return false;
             }
         })
         if(product){
             alert(product.description);
         }
     }
