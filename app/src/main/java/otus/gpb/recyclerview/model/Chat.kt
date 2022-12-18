package otus.gpb.recyclerview.model

import otus.gpb.recyclerview.R

data class Chat(
    val name: String,
    val sender: String,
    val message: String,
    val dateTime: String,
    val isVerified: Boolean,
    val isMuted: Boolean,
    val isScam: Boolean,
    val status: Int,
    val countMessages: Int,
    val chatImage: Int,
    val messageImage: Int
)

fun generateItemList(): MutableList<Chat> {
    val list = mutableListOf<Chat>()
    list.add(Chat("Elon Musk", "", "Hi, wanna work?", "Mon", true, false, false, 0, 2, R.drawable.elon, 0))
    list.add(Chat("Pasha", "", "Yes, of course", "12:17 PM", true, true, false, 2, 0, R.drawable.pasha, R.drawable.chat_heart))
    list.add(Chat("OTUS GPB", "Tatyana", "We have postponed the lesson", "11:46 AM", false, true, false, 0, 1, R.drawable.otus, 0))
    list.add(Chat("MAGN_IT", "Pasha Kol", "Ahahah", "09:08 AM", false, true, false, 0, 56, R.drawable.magnit, 0))
    list.add(Chat("Dmitry Omelchenko", "", "Where are you?", "Tue", false, false, false, 3, 0, R.drawable.omel, 0))
    list.add(Chat("Yana", "", "I`ve no money", "04:15 PM", false, true, false, 0, 0, R.drawable.yana, 0))
    list.add(Chat("Ma", "", "I found it!", "09:07 AM", false, false, false, 2, 0, R.drawable.mom, R.drawable.chat_lake))
    list.add(Chat("Freddy", "", "We have a great deal for you!", "Sat", false, false, true, 0, 3, R.drawable.freddy, 0))
    list.add(Chat("HiLoad 2019", "Maxim", "No no, it`s a different thing", "08:32 PM", true, true, false, 0, 7, R.drawable.hiload, 0))
    list.add(Chat("Dad", "", "How are you?", "05:57 AM", false, false, false, 0, 1, R.drawable.dad, 0))
    return list
}