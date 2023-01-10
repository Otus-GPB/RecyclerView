package otus.gpb.recyclerview

class ChatItem {
    private val someList = mutableListOf(
        Chat(
            0,
            "https://icons.iconarchive.com/icons/diversity-avatars/avatars/64/andy-warhol-icon.png",
            "Warhol",
            "Yes",
            "11:38",
            false

        ),
        Chat(
            1,
            "https://icons.iconarchive.com/icons/diversity-avatars/avatars/64/batman-icon.png",
            "Batman",
            "I love sky",
            "12:44",
            true
        ),
        Chat(
            2,
            "https://icons.iconarchive.com/icons/diversity-avatars/avatars/64/cristiano-ronaldo-icon.png",
            "Ronaldo",
            "How are u?",
            "Fri",
            false
        ),
        Chat(
            3,
            "https://icons.iconarchive.com/icons/diversity-avatars/avatars/64/trinity-icon.png",
            "Trinity",
            "Okay",
            "Wed",
            true
        ),
                Chat(
            4,
            "https://icons.iconarchive.com/icons/diversity-avatars/avatars/64/cristiano-ronaldo-icon.png",
            "Ronaldo 5",
            "How are u?",
            "Fri",
                    false
        ),
        Chat(
            5,
            "https://icons.iconarchive.com/icons/diversity-avatars/avatars/64/trinity-icon.png",
            "Trinity 6",
            "Okay",
            "Wed",
            true
        ),
        Chat(
            6,
            "https://icons.iconarchive.com/icons/diversity-avatars/avatars/64/cristiano-ronaldo-icon.png",
            "Ronaldo 7",
            "How are u?",
            "Fri",
            false
        ),
        Chat(
            7,
            "https://icons.iconarchive.com/icons/diversity-avatars/avatars/64/trinity-icon.png",
            "Trinity 8",
            "Okay",
            "Wed",
            false
        ),
                Chat(
            8,
            "https://icons.iconarchive.com/icons/diversity-avatars/avatars/64/cristiano-ronaldo-icon.png",
            "Ronaldo 9",
            "How are u?",
            "Fri",
            false
        ),
        Chat(
            9,
            "https://icons.iconarchive.com/icons/diversity-avatars/avatars/64/trinity-icon.png",
            "Mate 10",
            "Okay",
            "Wed",
            true
        ),Chat(
            10,
            "https://icons.iconarchive.com/icons/diversity-avatars/avatars/64/cristiano-ronaldo-icon.png",
            "Mate 11",
            "How are u?",
            "Fri",
            true
        ),
        Chat(
            11,
            "https://icons.iconarchive.com/icons/diversity-avatars/avatars/64/trinity-icon.png",
            "Mate 12",
            "Okay",
            "Wed",
            false
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
