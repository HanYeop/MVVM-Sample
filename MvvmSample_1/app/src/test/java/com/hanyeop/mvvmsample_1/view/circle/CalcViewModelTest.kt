package com.hanyeop.mvvmsample_1.view.circle
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.hanyeop.mvvmsample_1.utils.MyCalc
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class CalcViewModelTest{

    private lateinit var calcViewModel: CalcViewModel
    private lateinit var calculations: MyCalc

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Before
    fun setUp() {
        calculations = Mockito.mock(MyCalc::class.java)
        Mockito.`when`(calculations.calculateArea(2.1)).thenReturn(13.8474)
        Mockito.`when`(calculations.calculateCircumference(1.0)).thenReturn(6.28)
        calcViewModel = CalcViewModel(calculations)
    }

    @Test
    fun calculateArea_radiusSent_updateLiveData(){
        calcViewModel.calculateArea(2.1)
        val result = calcViewModel.areaValue.value
        assertThat(result).isEqualTo("13.8474")
    }

    @Test
    fun calculateCircumference_radiusSent_updateLiveData(){
        calcViewModel.calculateCircumference(1.0)
        val result = calcViewModel.circumferenceValue.value
        assertThat(result).isEqualTo("6.28")
    }
}