package com.sample.imagefeaturelibrary.imagelist.di

import android.content.Context
import com.sample.imagefeaturelibrary.common.data.ImageDataSource
import com.sample.imagefeaturelibrary.common.data.ImageDataSourceImpl
import com.sample.imagefeaturelibrary.imagelist.domain.ImageListUseCase
import com.sample.imagefeaturelibrary.imagelist.domain.ImageListUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ImageListModule {

    @Provides
    fun provideImageListUseCase(
        imageDataSource: ImageDataSource
    ): ImageListUseCase {
        return ImageListUseCaseImpl(imageDataSource)
    }

    @Provides
    fun provideImageDataSource(
        appCtx: Context
    ): ImageDataSource {
        return ImageDataSourceImpl(appCtx)
    }

    @Provides
    fun provideAppContext(
        @ApplicationContext appCtx: Context
    ): Context {
        return appCtx
    }
}
