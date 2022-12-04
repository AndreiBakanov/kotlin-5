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


    val note = Notes(1,"original", 33)
    val note3 = Notes(3,"original2", 33)
    val note2 = Notes(2, userId = 33)
    val copiedNote = Notes(1, "edit", 33)
    WallService.createNote(note)
    WallService.createNote(note2)
    WallService.createNote(note3)
    WallService.editNote(copiedNote)

    val notesComment = NotesComments(1, 1, 1)
    val copiedNotesComment = NotesComments(1, 1, 2)
    val notesComment2 = NotesComments(2, 1)
    WallService.createNotesComment(notesComment)
    WallService.createNotesComment(notesComment2)
    WallService.editNotesComment(copiedNotesComment)
    println(WallService.getNotesComments(1))
    WallService.deleteNotesComment(copiedNotesComment)
    println(WallService.getNotesComments(1))
    WallService.restoreNotesComment(copiedNotesComment)
    println(WallService.getNotesComments(1))
    println(WallService.getUsersNotesComments(2))



}







