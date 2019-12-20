let webSocket;
let name;
let message;
let score;
function openSocket() {
    webSocket = new WebSocket("ws://localhost:8080/echo");

    webSocket.onopen = function (e) {
    };
    webSocket.onmessage = function (e) {
        writeResponse(e.data);
    };
    webSocket.onclose = function (e) {
    };
}

function sendFirst() {
    name = document.getElementById('nameinput1').value;
    message = document.getElementById('messageinput1').value;
    score = document.getElementById('scoreinput1').value;
    let text = "1_" + name + "_" + message + "_" + score;
    webSocket.send(text);
}

function sendSecond() {
    name = document.getElementById('nameinput2').value;
    message = document.getElementById('messageinput2').value;
    score = document.getElementById('scoreinput2').value;
    let text = "2_" + name + "_" + message + "_" + score;
    webSocket.send(text);
}

function sendThird() {
    name = document.getElementById('nameinput3').value;
    message = document.getElementById('messageinput3').value;
    score = document.getElementById('scoreinput3').value;
    let text = "3_" + name + "_" + message + "_" + score;
    webSocket.send(text);
}

function sendFourth() {
    name = document.getElementById('nameinput4').value;
    message = document.getElementById('messageinput4').value;
    score = document.getElementById('scoreinput4').value;
    let text = "4_" + name + "_" + message + "_" + score;
    webSocket.send(text);
}

function sendFifth() {
    name = document.getElementById('nameinput5').value;
    message = document.getElementById('messageinput5').value;
    score = document.getElementById('scoreinput5').value;
    let text = "5_" + name + "_" + message + "_" + score;
    webSocket.send(text);
}


function closeSocket() {
    webSocket.close();
}
function writeResponse(text) {
    var tArray = text.split("_");
    var messages = document.getElementById('messages' + tArray[0]);
    var out = tArray[1] + ": " + tArray[2] + " SCORE: " + tArray[3];


    messages.innerHTML += "<p>" + out + "</p>";
}
