package com.example.chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewModel> {

    private List<ChatModel> chatList;
    private final int VIEW_TYPE_FROM = 0;
    private final int VIEW_TYPE_TO = 1;


    ChatAdapter(List<ChatModel> chatList) {
        this.chatList = chatList;
    }

    @NonNull
    @Override
    public ChatAdapter.ChatViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == VIEW_TYPE_FROM)
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_from_chat, parent, false);
        else
            view = LayoutInflater
                    .from(parent.getContext()).inflate(R.layout.adapter_to_chat,parent, false);
        return new ChatViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.ChatViewModel holder, int position) {
        holder.textView.setText(chatList.get(position).message);
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    @Override
    public int getItemViewType(int position) {
        final ChatModel chatModel = chatList.get(position);
        switch (chatModel.messageType) {
            case FROM:
                return VIEW_TYPE_FROM;
            case TO:
                return VIEW_TYPE_TO;
        }
        return super.getItemViewType(position);
    }

    public class ChatViewModel extends RecyclerView.ViewHolder {

        TextView textView;

        public ChatViewModel(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_message);
        }
    }
}
