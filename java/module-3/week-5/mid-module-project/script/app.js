document.addEventListener("DOMContentLoader", handleDOMContentLoaded);

function handleDOMContentLoaded(){
    let cards = document.getElementById("product-cards");
    let children = document.querySelectorAll(".product-card");
    children.forEach((item) => {
        cards.removeChild(item);
    })
    let products = productService.getProducts();
    products.forEach((product) =>{
        document.createElement("article");
        cards.appendChild(article);
        let divSku = document.createElement("div");
        article.appendChild(divSku);
        divSku.classList.add("sku");
        divSku.innerText = product.productSku

        let divPrice = document.createElement("price");
        article.appendChild(divPrice);
        divPrice.classList.add("price");
        divPrice.innerText = product.price;

        let divName = document.createElement("name");
        article.appendChild(divName);
        divName.classList.add("name");
        divName.innerText = product.name;

        let divImage = document.createElement("image");
        article.appendChild(divImage);
        divImage.classList.add("image");
        divImage.appendChild(img);
    })
}