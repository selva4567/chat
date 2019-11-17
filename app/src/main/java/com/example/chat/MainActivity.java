package com.example.chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvChatHistory;
    private ImageButton btnSend;
    private EditText etUserMessage;
    private final List<ChatModel> chatModelList = new ArrayList<>();
    private ChatAdapter chatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserMessage = findViewById(R.id.et_user_message);

        btnSend = findViewById(R.id.btn_send);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String userMessage = etUserMessage.getText().toString();
                if (!userMessage.isEmpty()) {
                    chatModelList.add(new ChatModel(MessageType.FROM, userMessage));
                    chatAdapter.notifyDataSetChanged();
                }
                etUserMessage.setText("");

                //TODO - Uncomment below lines for displaying response from TensorFlow.
//                chatModelList.add(new ChatModel(MessageType.TO, responseMessage));
//                chatAdapter.notifyDataSetChanged();

            }
        });

        rvChatHistory = findViewById(R.id.rv_chat);
//        chatAdapter = new ChatAdapter(chatModelList);
        chatAdapter = new ChatAdapter(getChatList());
        rvChatHistory.setAdapter(chatAdapter);
        rvChatHistory.setLayoutManager(new LinearLayoutManager(this));
    }

    private List<ChatModel> getChatList() {
        chatModelList.add(new ChatModel(MessageType.FROM, "Hello there!"));
        chatModelList.add(new ChatModel(MessageType.TO, "Hi there!"));
        chatModelList.add(new ChatModel(MessageType.FROM, "How is life going?"));
        chatModelList.add(new ChatModel(MessageType.TO, "Going pretty fine."));
        chatModelList.add(new ChatModel(MessageType.TO, "What about you?"));
        chatModelList.add(new ChatModel(MessageType.FROM, "Going good?"));
        return chatModelList;
    }
}
