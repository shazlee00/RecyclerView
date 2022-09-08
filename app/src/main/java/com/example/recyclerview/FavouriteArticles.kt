package com.example.recyclerview

import androidx.room.*
@Entity
data class FavouriteArticles(

    @PrimaryKey val articleId: Int,
     var title       : String? = null,
     var description : String? = null,
     var url         : String? = null,
     var urlToImage  : String? = null,

    )


@Dao
interface ArticleDao {
    @Query("SELECT * FROM FavouriteArticles")
    fun getUsers(): List<FavouriteArticles>

    @Insert
    fun insert(FavouriteArticle: FavouriteArticles)

    @Delete
    fun delete(article:FavouriteArticles)
}

@Database(entities = [FavouriteArticles::class], version = 1)
abstract class DataBasic : RoomDatabase() {
    abstract fun getArticleDao(): ArticleDao
}