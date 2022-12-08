package ru.netology

import org.junit.Test

import org.junit.Assert.*

class ChatsMessagesServiceTest {

    @Test
    fun createMessageListSizeIs1() {
        val userIdM = 1
        val idM = 1
        val chatIdM = 1
        var isReadM = false
        val textM = "text"

        val userIdC = 1
        val user2IdC = 1
        val idC = 1
        val messagesC: MutableList<Messages> = mutableListOf()

        val message = Messages(userIdM, idM, chatIdM, isReadM, textM)
        val chat = Chats(userIdC, user2IdC, idC, messagesC)
        ChatsMessagesService.createMessage(chat, message)
        assertEquals(1, chat.messages.size)
    }

    @Test(expected = MessageIdIsAlreadyExistException::class)
    fun shouldThrowMessageIdIsAlreadyExistException() {
        val userIdM = 1
        val idM = 1
        val chatIdM = 1
        var isReadM = false
        val textM = "text"

        val userIdC = 1
        val user2IdC = 1
        val idC = 1
        val messagesC: MutableList<Messages> = mutableListOf()

        val message = Messages(userIdM, idM, chatIdM, isReadM, textM)
        val chat = Chats(userIdC, user2IdC, idC, messagesC)
        ChatsMessagesService.createMessage(chat, message)
        ChatsMessagesService.createMessage(chat, message)
    }

    @Test
    fun getUnreadChatsNumberIs1() {
        val userIdM = 3
        val idM = 2
        val chatIdM = 2
        var isReadM = false
        val textM = "text"

        val userIdC = 2
        val user2IdC = 2
        val idC = 2
        val messagesC: MutableList<Messages> = mutableListOf()

        val message = Messages(userIdM, idM, chatIdM, isReadM, textM)
        val chat = Chats(userIdC, user2IdC, idC, messagesC)

        val userIdM2 = 4
        val idM2 = 3
        val chatIdM2 = 3
        var isReadM2 = false
        val textM2 = "text"

        val userIdC2 = 3
        val user2IdC2 = 3
        val idC2 = 3
        val messagesC2: MutableList<Messages> = mutableListOf()

        val message2 = Messages(userIdM2, idM2, chatIdM2, isReadM2, textM2)
        val chat2 = Chats(userIdC2, user2IdC2, idC2, messagesC2)

        ChatsMessagesService.createMessage(chat, message)
        ChatsMessagesService.createMessage(chat2, message2)
        assertEquals(2, ChatsMessagesService.getUnreadChatsCount())
    }

    @Test
    fun getUserMessageNumberIs1() {
        val userIdM = 5
        val idM = 5
        val chatIdM = 5
        var isReadM = false
        val textM = "text"

        val userIdC = 5
        val user2IdC = 5
        val idC = 5
        val messagesC: MutableList<Messages> = mutableListOf()

        val message = Messages(userIdM, idM, chatIdM, isReadM, textM)
        val chat = Chats(userIdC, user2IdC, idC, messagesC)


        ChatsMessagesService.createMessage(chat, message)
        assertEquals(1, ChatsMessagesService.getChats(5).size)
    }

    @Test
    fun getUserChatsNumberIs2() {
        val userIdM = 6
        val idM = 6
        val chatIdM = 6
        var isReadM = false
        val textM = "text"

        val userIdC = 6
        val user2IdC = 6
        val idC = 6
        val messagesC: MutableList<Messages> = mutableListOf()

        val message = Messages(userIdM, idM, chatIdM, isReadM, textM)
        val chat = Chats(userIdC, user2IdC, idC, messagesC)


        ChatsMessagesService.createMessage(chat, message)
        assertEquals(1, ChatsMessagesService.getMessages(6, 1).size)
    }
}