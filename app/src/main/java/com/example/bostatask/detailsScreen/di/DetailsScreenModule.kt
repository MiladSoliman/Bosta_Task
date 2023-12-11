package com.example.bostatask.detailsScreen.di

import com.example.bostatask.detailsScreen.data.remotDataSource.AlbumPhotosRemoteDataSource
import com.example.bostatask.detailsScreen.data.remotDataSource.AlbumPhotosRemoteDataSourceImp
import com.example.bostatask.detailsScreen.data.repo.AlbumPhotosRepoImp
import com.example.bostatask.detailsScreen.data.retrofit.DetailsScreenApi
import com.example.bostatask.detailsScreen.domin.repo.AlbumPhotosRepo
import com.example.bostatask.homeScreen.data.remotDataSource.AlbumsRemoteDataSource
import com.example.bostatask.homeScreen.data.remotDataSource.AlbumsRemoteDataSourceImp
import com.example.bostatask.homeScreen.data.repo.AlbumsRepoImp
import com.example.bostatask.homeScreen.data.retrofit.HomeApiService
import com.example.bostatask.homeScreen.domin.repo.AlbumsRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
abstract class DetailsScreenModule {

    @ViewModelScoped
    @Binds
    abstract fun bindAlbumsPhotosRemoteDataSource(albumPhotosRemoteDataSourceImp: AlbumPhotosRemoteDataSourceImp): AlbumPhotosRemoteDataSource

    @ViewModelScoped
    @Binds
    abstract fun bindAlbumPhotosRepo(albumPhotosRepoImp: AlbumPhotosRepoImp): AlbumPhotosRepo

    companion object {
        @ViewModelScoped
        @Provides
        fun provideUserServices(retrofit: Retrofit) : DetailsScreenApi =
            retrofit.create(DetailsScreenApi::class.java)
    }
}