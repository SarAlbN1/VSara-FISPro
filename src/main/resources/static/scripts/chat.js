function sendMessage() {
    const messageInput = document.getElementById("message");
    const message = messageInput.value;
    
    if (message.trim() !== "") {
        const messageElement = document.createElement("li");
        messageElement.textContent = message;
        document.getElementById("messages").appendChild(messageElement);
        
        // Enviar el mensaje al servidor (opcional, con una conexión WebSocket)
        fetch('/api/chat/send', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ userId: 1, content: message }) // Ajusta según el usuario actual
        }).then(response => response.json())
          .then(data => console.log("Mensaje enviado:", data))
          .catch(error => console.error("Error al enviar mensaje:", error));

        messageInput.value = ""; // Limpiar el campo de entrada
    }
}

// Opcional: función para obtener mensajes previos
function loadMessages(userId) {
    fetch(`/api/chat/messages?userId=${userId}`)
        .then(response => response.json())
        .then(messages => {
            const messagesList = document.getElementById("messages");
            messagesList.innerHTML = "";
            messages.forEach(msg => {
                const messageElement = document.createElement("li");
                messageElement.textContent = `${msg.senderId}: ${msg.content}`;
                messagesList.appendChild(messageElement);
            });
        })
        .catch(error => console.error("Error al cargar mensajes:", error));
}

// Llama a loadMessages con el ID del usuario actual
loadMessages(1); // Reemplaza '1' por el ID del usuario actual
