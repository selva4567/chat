package com.example.chat;

import java.util.List;

enum MessageType {
    FROM, TO
}

public class ChatModel {
    MessageType messageType;
    String message;

    ChatModel(MessageType messageType, String message) {
        this.messageType = messageType;
        this.message = message;
    }
}

