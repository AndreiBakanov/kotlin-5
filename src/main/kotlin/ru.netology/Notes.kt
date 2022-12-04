package ru.netology

data class Notes(
    val noteId: Int = 0,
    val title: String = "title",
    val userId: Int = 1,
    val text: String = "note",
    val privacy: Int = 1,
    val commentPrivacy: Int = 1,
    val privacyView: String = "privacyView",
    val privacyComment: String = "privacyComment"
)
data class NotesComments(
    val commentId: Int = 0,
    val noteId: Int = 0,
    val ownerId: Int = 0,
    val replyTo: Int = 0,
    val massage: String = "massage",
    val guid: String = "original"
)

