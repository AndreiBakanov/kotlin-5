package ru.netology

import java.lang.RuntimeException

fun main() {
//    val postArray = emptyArray<Reposts>()
//    val postAttachment = emptyArray<Attachment>()
//    val postRepost = Reposts(0, false)
//    val postComment = Comments(0, true, true, true, false)
//    val postGeo = Geo("city", "53.2001°, 50.15°, 53,2001°N, 50,15°E", "Samara")
//    val postLike = Likes(0)
//    val post = Post(
//        1,
//        1,
//        1,
//        1,
//        1,
//        "Hello",
//        1,
//        false,
//        postLike,
//        null,
//        "wiki",
//        postRepost,
//        0,
//        "post",
//        "info",
//        postGeo,
//        1,
//        postArray,
//        true,
//        true,
//        true,
//        false,
//        false,
//        false,
//        1,
//        postAttachment
//    )
//    val postCorrect = Post(
//        1,
//        1,
//        1,
//        1,
//        1,
//        "Hi",
//        1,
//        false,
//        postLike,
//        postComment,
//        "wiki",
//        postRepost,
//        0,
//        "post",
//        "info",
//        postGeo,
//        1,
//        postArray,
//        true,
//        true,
//        true,
//        false,
//        false,
//        false,
//        1,
//        postAttachment
//    )
//    WallService.add(post)
//    WallService.update(postCorrect)
//    val newComment = Comment(1, 1, 1, "Hello", null, 1, 1, null, null, null)
//    WallService.createComment(1, newComment)
//    val commentReport = Reports(1, 1, 1)
//    WallService.createReport(commentReport)
//    val note = Notes(1,"original", 33)
//    val note3 = Notes(3,"original2", 33)
//    val note2 = Notes(2, userId = 33)
//    val copiedNote = Notes(1, "edit", 33)
//    NoteService.createNote(note)
//    NoteService.createNote(note2)
//    NoteService.createNote(note3)
//    NoteService.editNote(copiedNote)
//
//    val notesComment = NotesComments(1, 1, 1)
//    val copiedNotesComment = NotesComments(1, 1, 2)
//    val notesComment2 = NotesComments(2, 1)
//    NoteService.createNotesComment(notesComment)
//    NoteService.createNotesComment(notesComment2)
//    NoteService.editNotesComment(copiedNotesComment)
//    println(NoteService.getNotesComments(1))
//    NoteService.deleteNotesComment(copiedNotesComment)
//    println(NoteService.getNotesComments(1))
//    NoteService.restoreNotesComment(copiedNotesComment)
//    println(NoteService.getNotesComments(1))
//    println(NoteService.getUsersNotesComments(2))
    val messages = mutableListOf<Messages>()
    val chat = Chats(messages = messages)
    val message = Messages (isRead = true, text = "Hello")
    val returnMessage = Messages (id = 4, userId = 2, text = "Hi")
    val returnMessage2 = Messages (id = 5, userId = 2, text = "How are you")
    val returnMessage3 = Messages (id = 6, userId = 2, text = "Nice to hear from you")

    val messages2 = mutableListOf<Messages>()
    val chat2 = Chats(id = 2, messages = messages2)
    val message2 = Messages (id = 2, chatId = 2, isRead = false)

    val messages3 = mutableListOf<Messages>()
    val chat3 = Chats(id = 3, messages = messages3)
    val message3 = Messages (id = 3, chatId = 3, userId = 3)

    ChatsMessagesService.createMessage(chat, message)
    ChatsMessagesService.createMessage(chat2, message2)
    ChatsMessagesService.createMessage(chat3, message3)
    ChatsMessagesService.createMessage(chat, returnMessage)
    ChatsMessagesService.createMessage(chat, returnMessage2)
    ChatsMessagesService.createMessage(chat, returnMessage3)

    val unreadChats = ChatsMessagesService.getUnreadChatsCount()
    println(unreadChats)
    //ChatsMessagesService.getChats(1)
    println( ChatsMessagesService.getMessages(1, 2))
    println(ChatsMessagesService.getChats(1))

}







