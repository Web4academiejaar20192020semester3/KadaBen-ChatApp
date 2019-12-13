var button = document.getElementById("statusButton");
button.onclick = getStatus;

var xHRObject = new XMLHttpRequest();

function getStatus () {
    xHRObject.open("GET","ManageStatusServlet",true);
    xHRObject.onreadystatechange = getData;
    xHRObject.send(null);
}

function getData() {
    if(xHRObject.status == 200){
        if(xHRObject.readyState == 4){
            var div = document.getElementById("status");
            var status = document.getElementById("customStatus");
            if(!!status){
                status = "Online";
            }
            var p = document.createElement("p");
            var text = document.createTextNode(status);
            p.appendChild(text);
            div.appendChild(p);
        }
    }
}
