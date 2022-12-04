package ru.netology

data class Comment(
    val id: Int,
    val fromID: Int,
    val date: Int,
    val text: String,
    val donut: Donut?,
    val replyToUser: Int,
    val replyToComment: Int,
    val attachments: Array<Attachment>?,
    val parantsStack: Array<Comment>?,
    val thread: Thread?,
)

//Репорты к комментам
data class Reports(
    val ownerID: Int,
    val commentID: Int,
    val reason: Int
)

data class Donut(
    val isDon: Boolean,
    val placeHolder: String
)

data class Thread(
    val count: Int,
    val items: Array<Comment>?,
    val canPost: Boolean,
    val showReplyButton: Boolean,
    val groupsCanPost: Boolean
)