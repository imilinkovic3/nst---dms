/**
 * Created by milinkoi on 15.02.2017.
 */
    // When the user clicks on <div>, open the popup
    // Get the modal
var modal = document.getElementById('myModal');



// Get the button that opens the modal
var btn = document.getElementById("moredetails_button");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on the button, open the modal
function insert_email_or_username(){

    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

