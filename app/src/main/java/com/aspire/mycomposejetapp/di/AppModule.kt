package com.aspire.mycomposejetapp.di


import android.content.Context
import androidx.room.Room
import com.aspire.mycomposejetapp.model.entity.MovieDeo
import com.aspire.mycomposejetapp.model.entity.MoviewDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MoviewDatabase {
        return Room.databaseBuilder(
            context,
            MoviewDatabase::class.java,
            "movie_db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideMoviewDao(moviewDatabase: MoviewDatabase): MovieDeo {
        return moviewDatabase.movieDao()
    }



}