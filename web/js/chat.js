//DEELOPDRACHT 1

let xhr = new XMLHttpRequest();
let xhr2 = new XMLHttpRequest();
let xhr3 = new XMLHttpRequest();
let xhr4 = new XMLHttpRequest();

function ready() {
    document.getElementById("changestatusbutton").onclick = changeStatus;
    document.getElementById("addfriendbutton").onclick = addFriend;
    getStatus();
    getFriends();
    console.log("loaded chat.js");
}

function addFriend() {
    let email = document.getElementById("addfriendemail").value;
    xhr4.open("POST", "Controller?action=ChatAddFriend", true);
    xhr4.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr4.send("email="+encodeURI(email));
}

function getStatus() {
    xhr.open("GET", "Controller?action=ChatStatus", true);
    xhr.onreadystatechange = getData;
    xhr.send(null);
}

function setStatus() {
    let status = document.getElementById("newstatus").value;
    xhr2.open("POST", "Controller?action=ChatChangeStatus", true);
    xhr2.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr2.send("status="+encodeURI(status));
    getStatus();
}

function changeStatus() {
    let newStatus = document.getElementById("newstatus");
    if (newStatus !== null && newStatus.length !== 0) {
        setStatus(newStatus);
    } else {
        alert("Please fill a not invalide status in ok");
    }
}

function getFriends() {
    xhr3.open("GET", "Controller?action=ChatFriendlist", true);
    xhr3.onreadystatechange = getFriendsData;
    xhr3.send();
}

function getFriendsData() {
    if (xhr3.status === 200) {
        if (xhr3.readyState === 4 && xhr3.responseText.toString().trim() !== "") {
            let response = xhr3.responseText;
            let json = JSON.parse(response);
            let friendlist = document.getElementById("friends");
            if (friendlist.childNodes.length > 0) {
                while (friendlist.firstChild) {
                    friendlist.removeChild(friendlist.firstChild);
                }
            }
            for (let i = 0; i < json.friends.length; i++) {
                let name = json.friends[i].user;
                let nametext = document.createTextNode(name);
                let tablerow = document.createElement('tr');
                tablerow.id = json.friends[i].email;
                tablerow.setAttribute("class", "vrient");
                // nodig voor deelopdracht 3 jquery
                tablerow.addEventListener('click', showWindow, false);
                let tdname = document.createElement('td');
                tdname.appendChild(nametext);
                let statustext = document.createTextNode(json.friends[i].status);
                let tdstatus = document.createElement('td');
                tdstatus.appendChild(statustext);
                tablerow.appendChild(tdname);
                tablerow.appendChild(tdstatus);
                friendlist.appendChild(tablerow);
            }
            setTimeout(getFriends, 5000);
        }
    }
}

function getData() {
    if (xhr.status === 200) {
        if (xhr.readyState === 4) {
            let response = xhr.responseText;
            let json = JSON.parse(response);
            let status = json.status;
            let currentStatus = document.getElementById("currentstatus");
            if (currentStatus.childNodes[0] !== null) {
                currentStatus.removeChild(currentStatus.childNodes[0]);
            }
            let statusText = document.createElement('em');
            statusText.id = "statustext";
            statusText.appendChild(document.createTextNode("Status: "+status));
            currentStatus.appendChild(statusText);
        }
    }
}