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
                Chat(
            4,
            "https://icons.iconarchive.com/icons/diversity-avatars/avatars/64/cristiano-ronaldo-icon.png",
            "Ronaldo5",
            "How are u?",
            "Fri",
        ),
        Chat(
            5,
            "https://icons.iconarchive.com/icons/diversity-avatars/avatars/64/trinity-icon.png",
            "Trinity6",
            "Okay",
            "Wed",
        ),
        Chat(
            6,
            "https://icons.iconarchive.com/icons/diversity-avatars/avatars/64/cristiano-ronaldo-icon.png",
            "Ronaldo7",
            "How are u?",
            "Fri",
        ),
        Chat(
            7,
            "https://icons.iconarchive.com/icons/diversity-avatars/avatars/64/trinity-icon.png",
            "Trinity8",
            "Okay",
            "Wed",
        ),
                Chat(
            8,
            "https://icons.iconarchive.com/icons/diversity-avatars/avatars/64/cristiano-ronaldo-icon.png",
            "Ronaldo9",
            "How are u?",
            "Fri",
        ),
        Chat(
            9,
            "https://icons.iconarchive.com/icons/diversity-avatars/avatars/64/trinity-icon.png",
            "10",
            "Okay",
            "Wed",
        ),Chat(
            10,
            "https://icons.iconarchive.com/icons/diversity-avatars/avatars/64/cristiano-ronaldo-icon.png",
            "11",
            "How are u?",
            "Fri",
        ),
        Chat(
            11,
            "https://icons.iconarchive.com/icons/diversity-avatars/avatars/64/trinity-icon.png",
            "12",
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
