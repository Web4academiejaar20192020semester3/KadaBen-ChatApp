let friends = [];

$(
    function() {
        $.ajax(
            {
                type: "GET",
                url: "Controller?action=ChatFriendlist",
                dataType: "json",
                complete: function(data) {
                    console.log(data.responseText);
                    let json = JSON.parse(data.responseText);
                    for (let i = 0; i < json.friends.length; i++) {
                        friends.push(json.friends[i].email);
                    }
                }
            }
        );
        getMessages();
    }
);

function showWindow() {
    let id = $.escapeSelector(this.id);
    let escId = this.id;
    let messagesContainer = $('#messagesContainer');

    if ($('#message'+id).length) {
        if ($("#messageBox"+id).is(':hidden')) {
            $("#messageBox"+id).toggle("fold", 400, function() {
                $("#messageText"+id).get(0).focus();
            });
        }
        else {
            $("#messageText"+id).get(0).focus();
        }
    }
    else if (!(messagesContainer.children().length >= 3)) {
            $('#messagesContainer').append(
                $('<div/>')
                    .attr('class', 'messageBox')
                    .attr('id', 'messageBox' + escId)
                    .attr('style', 'display: none')
                    .append(
                        $('<div/>')
                            .attr('class', 'messageName')
                            .attr('id', 'message' + escId)
                            .append(
                                $('<p/>').text(escId)
                            )
                    )
                    .append(
                        $('<div/>')
                            .attr('class', 'messageContainer')
                            .attr('id', 'messageContainer' + escId)
                            .append(
                                $('<div/>')
                                    .attr('class', 'messages')
                                    .attr('id', 'messages'+escId)
                            )
                            .append(
                                $('<textarea/>')
                                    .attr('type', 'text')
                                    .attr('class', 'messageText')
                                    .attr('id', 'messageText' + escId)
                                    .attr('placeholder', '...')
                            )
                            .append(
                                $('<input/>')
                                    .attr('type', 'button')
                                    .attr('class', 'messageSend')
                                    .attr('id', 'messageSend' + escId)
                                    .attr('value', 'send')
                            )
                    )
            );

            $("#messageBox"+id).toggle("fold", 400, function() {
                $("#messageText"+id).get(0).focus();
            });

            // .call omdat er parameters moeten worden meegegeven
            $("#messageSend"+id).bind('click', function(){ formatAndSendMessage.call(this, id); });
            // jQuery UI fancy toggle chat
            $("#message"+id).bind('click', function() {
                $("#messageBox"+id).toggle("fold", 400);
            });

            // maakt het mogelijk berichten met enter te vesrturen
            $("#messageText"+id).keypress(function(event) {
                let keycode = (event.keyCode ? event.keyCode : event.which);
                if(keycode == '13'){
                    formatAndSendMessage(escId);
                }
            });
    }
}
function formatAndSendMessage(id) {
    let escId = $.escapeSelector(id);
    let msg = $("#messageText"+escId).val().replace(/(\r\n|\n|\r)/gm,"");;
    $("#messageText"+escId).val("");
    sendMessage(msg, id);
}




function sendMessage(msg, to) {
    let data = {
        msg: msg,
        to: to
    };

    let success = function() {
        console.log("message sent to "+to);
    };

    $.post("Controller?action=MessageSend", data, success);
}



function getMessages() {
    console.log("getting messages");

    $('#friends').children('tr').each(function(i) {
        if (!friends.includes($(this)[0].email)) {
            friends.push($(this)[0].email);
        }
    });

    console.log(friends);

    // for each friend start polling for new messages
    for (let i = 0; i < friends.length; i++) {
        $.get("Controller?action=MessageGet&to="+friends[i], function(data){
            parseMessages(data, friends[i]);
            }, "json");
    }

    setTimeout(getMessages, 1000);

}





let msgs = {};


function parseMessages(json, friend) {

    let escFriend = $.escapeSelector(friend);

    let messageBox = $("#messages"+escFriend);


    console.log("logging msgsfriend");
    console.log(msgs[friend]);

    if (msgs[friend] !== undefined) {
        if (JSON.stringify(json) === JSON.stringify(msgs[friend])) {
            if (!$('#messageBox'+escFriend).is(':visible')) {
                return;
            }
        } else {
            messageBox.animate({ scrollTop: 20000000 }, "slow");
        }
    }
    msgs[friend] = json;

    messageBox.empty();

    console.log(json.messages);
    if (json.messages === undefined) return;

    for (let i = 0; i < json.messages.length; i++) {

        if (friend === json.messages[i].from) {
            messageBox.append(
                $('<div/>')
                    .attr('class', 'left')
                    .append(
                        $('<p/>').text(json.messages[i].msg)
                    )
            )
        }

        else {
            messageBox.append(
                $('<div/>')
                    .attr('class', 'right')
                    .append(
                        $('<p/>').text(json.messages[i].msg)
                    )
            )
        }
    }
}
