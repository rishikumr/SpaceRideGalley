package com.sample.imagefeaturelibrary.imagedetails.di

import com.sample.imagefeaturelibrary.common.data.ImageDataSource
import com.sample.imagefeaturelibrary.imagedetails.domain.ImageDetailUseCase
import com.sample.imagefeaturelibrary.imagedetails.domain.ImageDetailUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ImageDetailModule {

    @Provides
    fun provideImageDetailUseCase(
        imageDataSource: ImageDataSource
    ): ImageDetailUseCase {
        return ImageDetailUseCaseImpl(imageDataSource)
    }
}
