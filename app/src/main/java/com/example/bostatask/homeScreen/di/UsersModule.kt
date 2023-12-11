package com.example.bostatask.homeScreen.di

import com.example.bostatask.homeScreen.data.remotDataSource.UserRemoteDataSource
import com.example.bostatask.homeScreen.data.remotDataSource.UserRemoteDataSourceImp
import com.example.bostatask.homeScreen.data.repo.UserRepoImp
import com.example.bostatask.homeScreen.data.retrofit.HomeApiService
import com.example.bostatask.homeScreen.domin.repo.UsersRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
abstract class UsersModule {

    @ViewModelScoped
    @Binds
    abstract fun bindUserRemoteDataSource(userRemoteDataSourceImp: UserRemoteDataSourceImp): UserRemoteDataSource

    @ViewModelScoped
    @Binds
    abstract fun bindUserRepo(userRepoImp: UserRepoImp): UsersRepo

    companion object {
        @ViewModelScoped
        @Provides
        fun provideUserServices(retrofit: Retrofit) : HomeApiService =
            retrofit.create(HomeApiService::class.java)
    }
}