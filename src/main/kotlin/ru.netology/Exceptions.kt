package ru.netology

import java.lang.RuntimeException

class PostNotFoundException(massage: String) : RuntimeException(massage)

class IdNotFoundException(massage: String) : RuntimeException(massage)

class CorrectReasonNotFoundException(massage: String) : RuntimeException(massage)

class NoteIdIsAlreadyExistException(massage: String) : RuntimeException(massage)

class NoteIdIsNotExistException(massage: String) : RuntimeException(massage)

class NotesCommentIdIsAlreadyExistException(massage: String) : RuntimeException(massage)

class NotesCommentIdIsNotExistException(massage: String) : RuntimeException(massage)

class DeletedNotesCommentIdIsAlreadyExistException(massage: String) : RuntimeException(massage)

class ChatIdIsAlreadyExistException(massage: String) : RuntimeException(massage)

class ChatIdIsNotExistException(massage: String) : RuntimeException(massage)

class MessageIdIsAlreadyExistException(massage: String) : RuntimeException(massage)

class MessageIdIsNotExistException(massage: String) : RuntimeException(massage)