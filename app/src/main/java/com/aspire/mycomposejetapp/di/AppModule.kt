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
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

    //api
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }



}