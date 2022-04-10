package notes

class ManagerMessages<T> {
    private val messages: MutableMap<Int, T> = HashMap()
    private val deletedMessages: MutableMap<Int, T> = HashMap()
    private var lastId = 0

    fun add(message: T): Int {
        messages[++lastId] = message
        return lastId
    }

    fun delete(message: T): Boolean {
        val id = getIdMessage(message, messages)
        if (id == -1) {
            return false
        }
        deletedMessages[id] = (messages.remove(id) ?: return false)
        return true
    }

    fun edit(id: Int, editedMessage: T): Boolean {
        if (!messages.contains(id)) {
            return false
        }
        messages[id] = editedMessage
        return true
    }

    fun getById(id: Int): T? {
        if (!messages.contains(id)) {
            return null
        }
        return messages[id]
    }

    fun restore(message: T): Boolean {
        val id = getIdMessage(message, deletedMessages)
        if (id == -1) {
            return false
        }
        messages[id] = message
        deletedMessages.remove(id)
        return true
    }

    private fun getIdMessage(message: T, map: MutableMap<Int, T>): Int {
        for (id in map.keys) {
            if (map[id] == message) {
                return id
            }
        }
        return -1
    }

    fun getMessages(): MutableCollection<T> {
        return messages.values
    }
}