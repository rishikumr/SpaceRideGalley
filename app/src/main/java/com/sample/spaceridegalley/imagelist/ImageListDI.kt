package com.sample.spaceridegalley.imagelist

import android.content.Context
import com.sample.spaceridegalley.common.data.ImageDataSource
import com.sample.spaceridegalley.common.data.StaticDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AnalyticsModule {

    @Provides
    fun provideImageListUseCase(
        imageDataSource: ImageDataSource
    ): ImageListUseCase {
        return ImageListUseCaseImpl(imageDataSource)
    }

    @Provides
    fun provideImageDataSource(
        appCtx : Context
    ): ImageDataSource {
        return StaticDataSource(appCtx)
    }

    @Provides
    fun provideAppContext(
        @ApplicationContext appCtx : Context
    ): Context {
        return appCtx
    }
}