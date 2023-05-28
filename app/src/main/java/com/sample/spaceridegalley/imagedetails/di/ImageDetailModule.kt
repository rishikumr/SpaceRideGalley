package com.sample.spaceridegalley.imagedetails.di

import com.sample.spaceridegalley.common.data.ImageDataSource
import com.sample.spaceridegalley.imagedetails.domain.ImageDetailUseCase
import com.sample.spaceridegalley.imagedetails.domain.ImageDetailUseCaseImpl
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
