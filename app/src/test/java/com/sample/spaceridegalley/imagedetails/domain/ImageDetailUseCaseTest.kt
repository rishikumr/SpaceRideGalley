package com.sample.spaceridegalley.imagedetails.domain

import com.sample.spaceridegalley.common.data.ImageDataSource
import com.sample.spaceridegalley.common.data.model.GalleryItem
import com.sample.spaceridegalley.imagedetails.domain.model.DetailItemModel
import com.sample.spaceridegalley.imagedetails.domain.sampledata.ImageDetailTestSampleData
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 *  This is a test class for testing ImageDetailUseCase interface
 */
internal class ImageDetailUseCaseTest {
    private lateinit var useCase: ImageDetailUseCase

    @RelaxedMockK
    private lateinit var imageDataSource: ImageDataSource

    @Before
    fun before() {
        MockKAnnotations.init(this)
        useCase = ImageDetailUseCaseImpl(
            imageDataSource
        )
    }

    @Test
    fun `given success ,when getImageItemList is called , verify response is success and data is as expected`() {
        runBlocking {
            // Given
            coEvery {
                imageDataSource.getGalleryItems()
            } returns ImageDetailTestSampleData.sampleGalleryItem

            // when
            val result = useCase.getImageItemList()

            // Verify
            verifyData(result, ImageDetailTestSampleData.sampleGalleryItem)
            coVerify {
                imageDataSource.getGalleryItems()
            }
        }
    }
}

private fun verifyData(result: List<DetailItemModel>, sampleGalleryItem: List<GalleryItem>) {
    Assert.assertEquals(
        "Total item count should be ${sampleGalleryItem.size} as per sample data. Please check ImageDetailTestSampleData -sampleGalleryItem",
        result.size,
        sampleGalleryItem.size
    )
    result.forEachIndexed { index, listItemModel ->
        Assert.assertEquals(
            "copyright and copyright does not match",
            listItemModel.owner,
            sampleGalleryItem[result.size - 1 - index].copyright
        )
        Assert.assertEquals(
            "date does not match",
            listItemModel.date,
            sampleGalleryItem[result.size - 1 - index].date
        )
        Assert.assertEquals(
            "explanation does not match",
            listItemModel.explanation,
            sampleGalleryItem[result.size - 1 - index].explanation
        )
        Assert.assertEquals(
            "hdurl does not match",
            listItemModel.hdurl,
            sampleGalleryItem[result.size - 1 - index].hdurl
        )
        Assert.assertEquals(
            "title does not match",
            listItemModel.title,
            sampleGalleryItem[result.size - 1 - index].title
        )
    }
}
