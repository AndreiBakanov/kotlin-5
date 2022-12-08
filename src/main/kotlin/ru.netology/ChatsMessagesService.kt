package ru.netology

object ChatsMessagesService {
    private val listOfChats = mutableListOf<Chats>()

    private fun createChat(chat: Chats): Chats {
        val isError: List<Chats> = listOfChats.filter { chats -> chats.id == chat.id }
        if (isError.isNotEmpty()) throw ChatIdIsAlreadyExistException("There is a chat with the same id")
        listOfChats.add(chat)
        return chat
    }

    fun createMessage(chat: Chats, message: Messages) {
        val isError: List<Messages> = chat.messages.filter { messages -> messages.id == message.id }
        if (isError.isNotEmpty()) throw MessageIdIsAlreadyExistException("There is a message in this chat with the same id")
        val doesExist: List<Chats> = listOfChats.filter { chats -> chats.id == message.chatId }
        if (doesExist.size == 1) {
            chat.messages.add(message)
        } else {
            createChat(chat)
            chat.messages.add(message)
        }
    }

    fun deleteChat(chat: Chats): Chats {
        for (chats in listOfChats) {
            if (chats.id == chat.id) {
                listOfChats.removeAt(listOfChats.indexOf(chats))
                return chats
            }

        }
        throw ChatIdIsNotExistException("There is not a chat with this id")
    }

    fun getUnreadChatsCount() =
        listOfChats.count { chat -> chat.messages.any { !it.isRead && (it.userId != chat.userId) } }
//    fun getUnreadChatsCount (): Int {
//        val unreadChats: List<Chats> = listOfChats.filter { chats ->
//            chats.messages.filter { messages -> !messages.isRead && (messages.userId != chats.userId) }
//                .isNotEmpty()
//        }
//        return unreadChats.size
//    }

    fun getChats(userid: Int): List<Chats> {
        val usersChats: List<Chats> = listOfChats.filter { chats -> chats.userId == userid }
        for (chats in usersChats) {
            val lastMessage = chats.messages.last()
            if (chats.messages.isEmpty()) println("There aren't any messages in a chat with id ${chats.id}")
            chats.messages.clear()
            chats.messages.add(lastMessage)

        }
        return usersChats
    }

    fun getMessages(chatId: Int, amountOfMessages: Int): List<Messages> {
        return listOfChats.find { it.id == chatId }?.messages.orEmpty().takeLast(amountOfMessages)
            .onEach { it.isRead = true }
    }

}
