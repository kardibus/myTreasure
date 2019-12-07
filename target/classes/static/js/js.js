const newButton = document.getElementById('newButton');

function f(){
    var now=new Date().toISOString().substr(0,16).split("T").join(" ");

    document.getElementById('dateOpen').value=now;
}

newButton.addEventListener('click', f);
