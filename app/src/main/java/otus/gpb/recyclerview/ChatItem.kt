package otus.gpb.recyclerview

data class ChatItem(
    val id : Int,
    val imageUrl : Int? = null,
    val userName : String,
    var title : String = NO_TITLE,
    val message : String,
    val time : String,
    val isVolume : Boolean,
    val isMark : Boolean,
    val isRead : Boolean

){
    companion object{
        const val NO_TITLE = ""
    }
}
