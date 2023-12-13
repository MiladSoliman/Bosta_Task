package com.example.bostatask.viewImageScreen.di

import com.example.bostatask.viewImageScreen.data.remoteSource.ImageRemoteDataSource
import com.example.bostatask.viewImageScreen.data.remoteSource.ImageRemoteDataSourceImp
import com.example.bostatask.viewImageScreen.data.repo.ImageRepoImp
import com.example.bostatask.viewImageScreen.data.retrofit.ImageApi
import com.example.bostatask.viewImageScreen.domin.repo.ImageRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
abstract class ImageScreenModule {

    @ViewModelScoped
    @Binds
    abstract fun bindImagerRemoteDataSource(imageRemoteDataSourceImp: ImageRemoteDataSourceImp): ImageRemoteDataSource

    @ViewModelScoped
    @Binds
    abstract fun bindImageRepo(imageRepoImp: ImageRepoImp): ImageRepo



    companion object {
        @ViewModelScoped
        @Provides
        fun provideUserServices(retrofit: Retrofit) : ImageApi =
            retrofit.create(ImageApi::class.java)
    }
}