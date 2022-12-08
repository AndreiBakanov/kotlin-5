package ru.netology

import java.lang.RuntimeException

class PostNotFoundException(message: String) : RuntimeException(message)

class IdNotFoundException(message: String) : RuntimeException(message)

class CorrectReasonNotFoundException(message: String) : RuntimeException(message)

class NoteIdIsAlreadyExistException(message: String) : RuntimeException(message)

class NoteIdIsNotExistException(message: String) : RuntimeException(message)

class NotesCommentIdIsAlreadyExistException(message: String) : RuntimeException(message)

class NotesCommentIdIsNotExistException(message: String) : RuntimeException(message)

class DeletedNotesCommentIdIsAlreadyExistException(message: String) : RuntimeException(message)

class ChatIdIsAlreadyExistException(message: String) : RuntimeException(message)

class ChatIdIsNotExistException(message: String) : RuntimeException(message)

class MessageIdIsAlreadyExistException(message: String) : RuntimeException(message)

class MessageIdIsNotExistException(message: String) : RuntimeException(message)

class ChatNotFoundException(message: String) : RuntimeException(message)