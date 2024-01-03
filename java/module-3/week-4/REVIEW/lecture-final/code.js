document.addEventListener('DOMContentLoaded', handleDOMContentLoaded);





function handleDOMContentLoaded(event) {



    let div1 = document.getElementById('div1');

    div1.style.backgroundColor = 'green';

   

    let allThs = document.querySelectorAll('th');

    allThs.forEach( (element) => {
        element.style.backgroundColor = 'blue';  
        }
    );

    let firstTh = document.querySelector('th');

    firstTh.style.backgroundColor = 'aqua';


    // let imagines = document.getElementsByClassName('imagine');
    // imagines.forEach( (element) => {
    //     element.style.backgroundColor = 'pink';  
    //     }
    // );


    let div2 = document.getElementById('div2');

    div2.innerText = `<strong>Hello world!!! ${div2.innerText}</strong>`

    let content = div2.innerText;

    let words = content.split(' ');

    let wordCounts = words.reduce( (counts, currentWord) => {

        currentWord = currentWord.toLowerCase();

        counts[currentWord] = (counts[currentWord] + 1) || 1;

        return counts;

        }, {} );


    let table = document.getElementById('table1');

    for ( let key in wordCounts ) {

        let value = wordCounts[key];

        let row = document.createElement('tr');

        let tdWord = document.createElement('td');
        tdWord.innerText = key;
        row.appendChild(tdWord);

        let tdCount = document.createElement('td');
        tdCount.innerText = value;
        row.appendChild(tdCount);

        table.appendChild(row); 

    }


    let form1 = document.getElementById('form1');

    form1.addEventListener('submit', handleSubmit);


    let borderCheck = document.getElementById('border-check');

    borderCheck.addEventListener('change', handleCheckChange)


    let tds = document.querySelectorAll('td');

    tds.forEach( (td) => {


        td.addEventListener('click', (event) => {
    
            event.stopPropagation();
            if (td.classList.contains('yellow')) {
                td.classList.remove('yellow');
            } else {
                td.classList.add('yellow');
            }
        })

    }
    )





    table.addEventListener('click', () => {
    
        if (table.classList.contains('red')) {
            table.classList.remove('red');
        } else {
            table.classList.add('red');
        }
    })

}

function handleCheckChange(event) {
    let div1 = document.getElementById('div1');

    if (div1.style.borderStyle === 'solid') {
        div1.style.borderStyle = 'none'
    } else {
        div1.style.borderStyle = 'solid'
    }
}

function handleSubmit(event) {

    let formName = document.getElementById('form-name');
    let div2 = document.getElementById('div2');

    div2.innerText = `${formName.value} : ${div2.innerText}`

    event.preventDefault();
}