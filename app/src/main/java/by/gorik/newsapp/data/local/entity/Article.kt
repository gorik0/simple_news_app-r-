package by.gorik.newsapp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.PrimaryKey
import by.gorik.newsapp.data.model.ApiArticle
import com.google.gson.annotations.SerializedName

data class Article(

    @PrimaryKey
    @ColumnInfo("id")
    val Id:Int=0,

    @ColumnInfo("title")
    val title:String="",

    @ColumnInfo("description")
    val description:String?=null,

    @ColumnInfo("url")
    val url:String="",

    @ColumnInfo("urlToImage")
    val urlToImage:String?=null,

    @ColumnInfo("source")
     @Embedded val source:Source
) {
    fun toApiArticle():ApiArticle{
        return  ApiArticle(
            title = title,
            description = description.let{it.toString()},
            url = url,
            urlToImage = urlToImage.let{it.toString()},
            source = source.toApiSource()
        )


    }



}
