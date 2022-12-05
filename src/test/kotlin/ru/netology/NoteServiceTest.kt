package ru.netology

import org.junit.Test

import org.junit.Assert.*

class NoteServiceTest {

    @Test
    fun createNoteIdNotZero() {
        val noteId = 1
        val title = "title"
        val userId = 1
        val text = "note"
        val privacy = 1
        val commentPrivacy = 1
        val privacyView = "privacyView"
        val privacyComment = "privacyComment"
        val note = Notes(noteId, title, userId, text, privacy, commentPrivacy, privacyView, privacyComment)
        NoteService.createNote(note)
        assertNotEquals(0, note.noteId)
    }

    @Test(expected = NoteIdIsAlreadyExistException::class)
    fun shouldThrowNoteIdIsAlreadyExistException() {
        val noteId = 2
        val title = "title"
        val userId = 1
        val text = "note"
        val privacy = 1
        val commentPrivacy = 1
        val privacyView = "privacyView"
        val privacyComment = "privacyComment"
        val note = Notes(noteId, title, userId, text, privacy, commentPrivacy, privacyView, privacyComment)
        val note2 = Notes(noteId, title, userId, text, privacy, commentPrivacy, privacyView, privacyComment)
        NoteService.createNote(note)
        NoteService.createNote(note2)


    }

    @Test
    fun deleteNoteReturnNote() {
        val noteId = 4
        val title = "title"
        val userId = 1
        val text = "note"
        val privacy = 1
        val commentPrivacy = 1
        val privacyView = "privacyView"
        val privacyComment = "privacyComment"
        val note = Notes(noteId, title, userId, text, privacy, commentPrivacy, privacyView, privacyComment)
        NoteService.createNote(note)
        assertEquals(note, NoteService.deleteNote(note))
    }

    @Test(expected = NoteIdIsNotExistException::class)
    fun shouldThrowNoteIdIsNotExistExceptionInDelete() {
        val noteId = 5
        val title = "title"
        val userId = 1
        val text = "note"
        val privacy = 1
        val commentPrivacy = 1
        val privacyView = "privacyView"
        val privacyComment = "privacyComment"
        val note = Notes(noteId, title, userId, text, privacy, commentPrivacy, privacyView, privacyComment)
        NoteService.deleteNote(note)
    }

    @Test
    fun editNoteTitleChanged() {
        val noteId = 6
        val title = "title"
        val userId = 1
        val text = "note"
        val privacy = 1
        val commentPrivacy = 1
        val privacyView = "privacyView"
        val privacyComment = "privacyComment"
        val note = Notes(noteId, title, userId, text, privacy, commentPrivacy, privacyView, privacyComment)
        val note1 = Notes(noteId, title = "edit", userId, text, privacy, commentPrivacy, privacyView, privacyComment)
        NoteService.createNote(note)
        assertEquals("edit", NoteService.editNote(note1).title)
    }

    @Test(expected = NoteIdIsNotExistException::class)
    fun shouldThrowNoteIdIsNotExistExceptionInEdit() {
        val noteId = 6
        val title = "title"
        val userId = 1
        val text = "note"
        val privacy = 1
        val commentPrivacy = 1
        val privacyView = "privacyView"
        val privacyComment = "privacyComment"
        val note1 = Notes(noteId, title, userId, text, privacy, commentPrivacy, privacyView, privacyComment)
        NoteService.editNote(note1)
    }

    @Test
    fun getUsersNotes() {
        assertEquals(1, NoteService.getUsersNotes(2).size)
    }

    @Test
    fun getNoteById() {
        val noteId = 8
        val title = "title"
        val userId = 1
        val text = "note"
        val privacy = 1
        val commentPrivacy = 1
        val privacyView = "privacyView"
        val privacyComment = "privacyComment"
        val note = Notes(noteId, title, userId, text, privacy, commentPrivacy, privacyView, privacyComment)
        NoteService.createNote(note)
        assertEquals(note, NoteService.getNoteById(8))
    }

    @Test(expected = NoteIdIsNotExistException::class)
    fun shouldThrowNoteIdIsNotExistExceptionInGetById() {
        val noteId = 9
        val title = "title"
        val userId = 1
        val text = "note"
        val privacy = 1
        val commentPrivacy = 1
        val privacyView = "privacyView"
        val privacyComment = "privacyComment"
        val note = Notes(noteId, title, userId, text, privacy, commentPrivacy, privacyView, privacyComment)
        NoteService.createNote(note)
        NoteService.getNoteById(99)
    }


}