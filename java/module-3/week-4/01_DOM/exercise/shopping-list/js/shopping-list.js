// add pageTitle
let pageTitle = 'My Shopping List';
// add groceries
let groceries = ['bananas', 'apples', 'oranges', 'cereal', 'broccoli', 'celery', 'potatoes', 'mustard', 'ham', 'eggs'];
/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const heading = document.querySelector('#title');
  heading.innerText = pageTitle;


}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
 const items = document.getElementById('groceries');
  groceries.forEach((grocery) =>{
    const groceryItem = document.createElement('li');
    groceryItem.innerText = grocery;
    items.appendChild(groceryItem);
  });
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
  const allItems = document.querySelector('#groceries');
  const grocery = Array.from(allItems.children);

  grocery.forEach((groc) =>{
    groc.classList.add('completed');
  })

}
setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
