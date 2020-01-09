const express = require("express");
const http = require("http");
const socketIo = require("socket.io");


const index = require("./routes/index");
const app = express();
app.use(index);

const server = http.createServer(app);

const io = socketIo(server);
io.on('connection', (socket) => {
  
    socket.on('disconnect', function(){
      io.emit('users-changed', {user: socket.nickname, event: 'left'});   
    });
   
    socket.on('set-nickname', (nickname) => {
      socket.nickname = nickname;
      io.emit('users-changed', {user: nickname, event: 'joined'});    
    });
    
    socket.on('add-message', (message) => {
      io.emit('message', {text: message.text, from: socket.nickname, created: new Date()});    
    });
  });

const port = process.env.PORT || 4001;
server.listen(port, () => console.log(`Listening on port ${port}`));

/* https://www.valentinog.com/blog/socket-io-node-js-react/ 
    Para entender socketWeb y Socket.io
*/
/* https://medium.com/@tkssharma/writing-neat-asynchronous-node-js-code-with-promises-async-await-fa8d8b0bcd7c 
    Para entender que async/await, es lo mismo que Promise, resolve, reject, then, catch
*/

/* https://devdactic.com/ionic-realtime-socket-io/
    Este chat fantástico
*/