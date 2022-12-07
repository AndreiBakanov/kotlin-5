package ru.netology

object ChatsMessagesService {
    private val listOfChats = mutableListOf<Chats>()

    fun createChat(chat: Chats): Chats {
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

    fun getUnreadChatsCount (): String {
        val unreadChats: List<Chats> = listOfChats.filter { chats ->
            chats.messages.filter { messages -> !messages.isRead && (messages.userId != chats.userId) }
                .isNotEmpty()
        }
        return if (unreadChats.isEmpty()) "There is not any unread messages" else "There are ${unreadChats.size} unread chats"
    }

    fun getChats (userid: Int) {
        val usersChats: List<Chats> = listOfChats.filter {chats -> chats.userId == userid}
        for(chats in usersChats) {
            println("chat id = ${chats.id}, last massage id is ${chats.messages.last().id} with text <${chats.messages.last().text}>")
        }
    }

    fun getMessages (chatId: Int, lastMessageId: Int, amountOfMessages: Int): List<Messages>{
        for (chats in listOfChats){
            if (chats.id == chatId){
                for (messages in chats.messages){
                    if (messages.id == lastMessageId){
                        for (unreadMessages in chats.messages.takeLast(amountOfMessages)){
                            unreadMessages.isRead = true
                        }
                        //val result: List<Messages> = chats.messages.filter { allMessages ->  chats.messages.indexOf(messages) >= chats.messages.indexOf(allMessages) }
                        return chats.messages.takeLast(amountOfMessages)
                        //return result
                    }
                }
                throw MessageIdIsNotExistException("There is not a message with this id")
            }
        }
        throw ChatIdIsNotExistException("There is not a chat with this id")
//        val chatList: List<Chats> = listOfChats.filter { chats -> chats.id == chatId }
//        val messageFrom: List<Messages> = chatList[0].messages.filter { messages -> messages.id == lastMessageId}
//        val messagesList: List<Messages> = chatList[0].messages.takeLast(chatList[0].messages.filter {  })
    }

}
