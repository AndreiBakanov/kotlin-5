package ru.netology

object NoteService {
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
        throw NoteIdIsNotExistException("There is not any notes with this id")
    }

    fun editNote(newNote: Notes): Notes {
        for (note in listOfNotes) {
            if (newNote.noteId == note.noteId) {
                listOfNotes[listOfNotes.indexOf(note)] = newNote
                return newNote
            }
        }
        throw NoteIdIsNotExistException("There is not any notes with this id")
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
        throw NoteIdIsNotExistException("There is no note with this id")
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
        throw NoteIdIsNotExistException("There is no note with this id")
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
        throw NoteIdIsNotExistException("There is not any notes with this id")
    }

    fun editNotesComment(newNotesComment: NotesComments): NotesComments {
        for (notesComment in listOfNotesComments) {
            if (newNotesComment.commentId == notesComment.commentId) {
                listOfNotesComments[listOfNotesComments.indexOf(notesComment)] = newNotesComment
                return newNotesComment
            }
        }
        throw NotesCommentIdIsNotExistException("There is not any note's comments with this id")
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
        throw NoteIdIsNotExistException("There is not any deleted notes with this id")
    }

}