package otus.gpb.recyclerview

class ChatItem {
    private val someList = mutableListOf(
        Chat(
            0,
            "https://icons.iconarchive.com/icons/diversity-avatars/avatars/64/andy-warhol-icon.png",
            "Warhol",
            "Yes",
            "11:38",
        ),
        Chat(
            1,
            "https://icons.iconarchive.com/icons/diversity-avatars/avatars/64/batman-icon.png",
            "Batman",
            "I love sky",
            "12:44",
        ),
        Chat(
            2,
            "https://icons.iconarchive.com/icons/diversity-avatars/avatars/64/cristiano-ronaldo-icon.png",
            "Ronaldo",
            "How are u?",
            "Fri",
        ),
        Chat(
            3,
            "https://icons.iconarchive.com/icons/diversity-avatars/avatars/64/trinity-icon.png",
            "Trinity",
            "Okay",
            "Wed",
        ),
    )

    fun chatItem() = someList

    fun remove(pos: Int) {
        someList.removeAt(pos)
    }

    fun addAll(newItems: List<Chat>) {
        someList.addAll(newItems)
    }
}