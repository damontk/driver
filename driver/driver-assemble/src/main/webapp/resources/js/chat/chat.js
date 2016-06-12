/**
 * Created by zc on 2016/2/2.
 */
//var app = {
// 链接远程服务器
var socket = new SockJS('/chat');
var stompClient = Stomp.over(socket);
//}
/**
 * 链接
 */
function connect() {
    stompClient.connect({}, function () {
        /**
         *
         */
        stompClient.subscribe("", function (data) {
            showChat(JSON.parse(chat.body));
        }, header);
    })
}
function disConnect() {
    stompClient.disconnect();
}
function sendMessage() {
    var msg = $('.chatInput').find('.input').val();
    stompClient.send("", "", msg);
}
//显示聊天信息
function showChat(message) {
    var response = document.getElementById('chat_content');
    response.value += decodeURIComponent(message.name) + ':' + decodeURIComponent(message.chatContent) + '\n';
}