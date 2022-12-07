package ru.netology

data class Messages(
    val userId: Int = 1,
    val id: Int = 1,
    val chatId: Int = 1,
    var isRead: Boolean = false,
    val text: String = "text"
)
data class Chats(
    val userId: Int = 1,
    val user2Id: Int = 1,
    val id: Int = 1,
    val messages: MutableList<Messages>
)