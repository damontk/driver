/**
 * Created by zc on 2016/2/2.
 */
//var app = {
// 链接远程服务器
var CHAT = {
    connect: function (stompClient) {
        stompClient.connect({}, function (frame) {
            $('#connect').html("disconnect");
            stompClient.subscribe('/topic/note', function (data) {
                $('#chatMsgs').html(data);
            })
        })
    },
    disconnect: function (stompClient) {
        stompClient.disconnect(function (data) {
            alert(data);
            $('#connect').html("connect");
        });
    },
    sendMsg: function (stompClient, obj) {
        var message = $(obj).val();
        stompClient.send("/app/msg", {}, message);
    }
}