package app.milkyway.utils

import java.text.SimpleDateFormat

object Helper {

    fun convertDate(date:String):String{
       return SimpleDateFormat("yyyy-MM-dd").format(SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(date))
    }

}