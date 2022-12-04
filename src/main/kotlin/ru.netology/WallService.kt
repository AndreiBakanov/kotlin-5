package ru.netology

object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private val newID = posts.size + 1
    private var commentReports = emptyArray<Reports>()
    fun createReport(report: Reports): Int {
        if (report.reason > 8 || report.reason < 0) {
            return throw CorrectReasonNotFoundException("Reason is not correct")
        } else {
            for (comment in comments) {
                if (comment.id == report.commentID) {
                    commentReports += report
                    return 1
                }
            }
            return throw IdNotFoundException("No comment with ${report.commentID}")
        }
    }

    fun createComment(postID: Int, comment: Comment): Comment {
        for (post in posts) {
            if (postID == post.id) {
                comments += comment
                return comment
            }
        }
        return throw PostNotFoundException("No post with $postID")
    }

    fun add(post: Post): Post {
        val post1 = post.copy(id = newID)
        posts += post1
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, originalPost) in posts.withIndex()) {
            if (post.id == originalPost.id) {
                val newPost = post.copy(id = originalPost.id, date = originalPost.date, ownerID = originalPost.ownerID)
                posts[index] = newPost
                return true
            }
        }
        return false
    }

    private val listOfNotes = mutableListOf(Notes())
    private val listOfUsersNotes = mutableListOf(Notes())
    private val listOfNotesComments = mutableListOf(NotesComments())
    private val listOfExactNotesComments = mutableListOf(NotesComments())
    private val listOfDeletedNotesComments = mutableListOf(NotesComments())


    fun createNote(note: Notes): Notes {
        for (notes in listOfNotes) {
            if (notes.noteId == note.noteId) throw NoteIdIsAlreadyExistException("The list has the note with the same id")
        }
        listOfNotes.add(note)
        return note
    }

    fun deleteNote(note: Notes): Notes {
        for (notes in listOfNotes) {
            if (notes.noteId == note.noteId) {
                listOfNotes.removeAt(listOfNotes.indexOf(notes))
                return notes
            }

        }
        return throw NoteIdIsNotExistException("There is not any notes with this id")
    }

    fun editNote(newNote: Notes): Notes {
        for (note in listOfNotes) {
            if (newNote.noteId == note.noteId) {
                listOfNotes[listOfNotes.indexOf(note)] = newNote
                return newNote
            }
        }
        return throw NoteIdIsNotExistException("There is not any notes with this id")
    }

    fun getUsersNotes(userId: Int): List<Notes> {
        for (usersNotes in listOfNotes) {
            if (userId == usersNotes.userId) {
                listOfUsersNotes.add(usersNotes)
            }
        }
        return listOfUsersNotes
    }

    fun getNoteById(noteId: Int): Notes {
        for (note in listOfNotes) {
            if (note.noteId == noteId) {
                return note
            }
        }
        return throw NoteIdIsNotExistException("There is no note with this id")
    }

    fun createNotesComment(notesComment: NotesComments): NotesComments {
        for (notes in listOfNotes) {
            if (notes.noteId == notesComment.noteId) {
                for (notesComments in listOfNotesComments) {
                    if (notesComment.commentId == notesComments.commentId) throw NotesCommentIdIsAlreadyExistException("The list has the note's comment with the same id")
                }
                listOfNotesComments.add(notesComment)
                return notesComment
            }
        }
        return throw NoteIdIsNotExistException("There is no note with this id")
    }

    fun deleteNotesComment(notesComment: NotesComments): NotesComments {
        for (notesComments in listOfDeletedNotesComments) {
            if (notesComment.noteId == notesComments.noteId) {
                return throw DeletedNotesCommentIdIsAlreadyExistException("The deleted list has the note's comment with the same id")
            }
        }
        for (notesComments in listOfNotesComments) {
            if (notesComments.commentId == notesComment.commentId) {
                listOfNotesComments.removeAt(listOfNotesComments.indexOf(notesComments))
                listOfDeletedNotesComments.add(notesComments)
                return notesComments
            }

        }
        return throw NoteIdIsNotExistException("There is not any notes with this id")
    }

    fun editNotesComment(newNotesComment: NotesComments): NotesComments {
        for (notesComment in listOfNotesComments) {
            if (newNotesComment.commentId == notesComment.commentId) {
                listOfNotesComments[listOfNotesComments.indexOf(notesComment)] = newNotesComment
                return newNotesComment
            }
        }
        return throw NotesCommentIdIsNotExistException("There is not any note's comments with this id")
    }

    fun getNotesComments(noteId: Int): List<NotesComments> {
        listOfExactNotesComments.clear()
        for (notesComments in listOfNotesComments) {
            if (noteId == notesComments.noteId) {
                listOfExactNotesComments.add(notesComments)
            }
        }
        return listOfExactNotesComments
    }

    fun getUsersNotesComments(ownerId: Int): List<NotesComments> {
        listOfExactNotesComments.clear()
        for (notesComments in listOfNotesComments) {
            if (ownerId == notesComments.ownerId) {
                listOfExactNotesComments.add(notesComments)
            }
        }
        return listOfExactNotesComments
    }

    fun restoreNotesComment(notesComment: NotesComments): NotesComments {
        for (deletedNotesComment in listOfDeletedNotesComments) {
            if (deletedNotesComment.noteId == notesComment.noteId) {
                listOfDeletedNotesComments.removeAt(listOfDeletedNotesComments.indexOf(deletedNotesComment))
                listOfNotesComments.add(deletedNotesComment)
                return deletedNotesComment
            }
        }
        return throw NoteIdIsNotExistException("There is not any deleted notes with this id")
    }


}