package com.sample.spaceridegalley.imagelist.domain

import com.sample.spaceridegalley.common.data.ImageDataSource
import com.sample.spaceridegalley.common.data.model.GalleryItem
import com.sample.spaceridegalley.imagelist.domain.model.ListItemModel
import com.sample.spaceridegalley.imagelist.domain.sampledata.ImageListTestSampleData
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 *  This is a test class for testing ImageListUseCase interface
 */
class ImageListUseCaseTest {
    private lateinit var useCase: ImageListUseCase

    @RelaxedMockK
    private lateinit var imageDataSource: ImageDataSource

    @Before
    fun before() {
        MockKAnnotations.init(this)
        useCase = ImageListUseCaseImpl(
            imageDataSource
        )
    }

    @Test
    fun `given success ,when getImageItemList is called , verify response is success and data is as expected`() {
        runBlocking {
            // Given
            coEvery {
                imageDataSource.getGalleryItems()
            } returns ImageListTestSampleData.sampleGalleryItem

            // when
            val result = useCase.getImageItemList()

            // Verify
            verifyData(result, ImageListTestSampleData.sampleGalleryItem)
            coVerify {
                imageDataSource.getGalleryItems()
            }
        }
    }
}

private fun verifyData(result: List<ListItemModel>, sampleGalleryItem: List<GalleryItem>) {
    Assert.assertEquals(
        "Total item count should be ${sampleGalleryItem.size} as per sample data. Please check ImageListTestSampleData -sampleGalleryItem",
        result.size,
        sampleGalleryItem.size
    )
    result.forEachIndexed { index, listItemModel ->
        Assert.assertEquals(
            "title does not match",
            listItemModel.title,
            sampleGalleryItem[result.size - 1 - index].title /* Why? returned list was sorted as per date value*/
        )
        Assert.assertEquals(
            "lowQUrl and url does not match",
            listItemModel.lowQUrl,
            sampleGalleryItem[result.size - 1 - index].url
        )
    }
}
