package otus.gpb.recyclerview

data class ChatItem(
    val id : Int,
    val imageUrl : String,
    val userName : String,
    var title : String = NO_TITLE,
    val message : String,
    val time : String
){
    companion object{
        const val NO_TITLE = ""
    }
}
