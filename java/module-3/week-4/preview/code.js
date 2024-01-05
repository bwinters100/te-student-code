

document.addEventListener('DOMContentLoaded', handleDOMContentLoaded)


function handleDOMContentLoaded() {
    const div1 = document.getElementById('div1');
    div1.style.border = "thick solid blue";

    const main = document.querySelector('main');
    main.style.border = "thick solid orange"

    const divs = document.querySelectorAll('.blue-back');
    divs.forEach( (div) => {
        div.style.backgroundColor = "blue";
    })


    const form1 = document.querySelector('#form1');

    form1.addEventListener('submit', handleSubmit);


    fillInTable();

    const changeIt = document.getElementById('change-it');
    changeIt.addEventListener('click', handleChange);



}

function handleChange(event) {

    const divs = document.querySelectorAll('.blue-back');
    divs.forEach( (div) => {

        if (div.style.backgroundColor === "blue") {
            div.style.backgroundColor = "gray";
        } else {
            div.style.backgroundColor = "blue";
        }

        console.log(`The click is at ${event.clientX}, ${event.clientY}`)
    })

}

function fillInTable() {
    const table1 = document.getElementById('table1');

    const content = 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Rem praesentium consequuntur aperiam quos laudantium, eaque, maxime cum, ex repellat pariatur repudiandae dolorum accusantium quo mollitia tempora adipisci quidem nihil numquam!';
    const words = content.split(' ');

    let row;
    words.forEach( (word, index) => {

        if (index % 5 === 0 ) {
           row = document.createElement('tr');
           table1.appendChild(row); 
        }
        const data = document.createElement('td');
        data.innerText = word;
        row.appendChild(data);


    } )




}

function handleSubmit(event) {
    const formName = document.getElementById('form-name');
    const div2 = document.getElementById('div2');
    div2.innerText = formName.value;
    event.preventDefault();
}
