package com.example.a223010_sunflower.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.a223010_sunflower.GardenFragment
import com.example.a223010_sunflower.PlantListFragment

const val MY_GARDEN_PAGE_INDEX = 0
const val PLANT_LIST_PAGE_INDEX = 1

class SunflowerPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    /**
     * Mapping of the ViewPager page indexes to their respective Fragments
     */

    //람다 함수 예시1 (선언 자료형이 표시된 경우 -> 람다식 매개변수타입 입력X)
    val check: (Int, Int) -> Int = { x, y -> x * y }

    //람다 함수 예시2 (선언 자료형이 생략o,-> 람다식 매개변수타입 입력)
    val check2 = { x: Int, y: Int -> x * y }


    //람다함수 프래그먼트 유형에 따라서 알맞은  ViewPager2의 들어갈 프래그먼트 객체를 반환
    //선언 자료형:
    // -입력값: Map<Int, () -> Fragment> (1개)
    // key: Int value, 람다함수(프래그먼트 반환)
    // -출력값: mapOf()
    private val tabFragmentsCreators: (Map<Int, () -> Fragment>) = mapOf(
        MY_GARDEN_PAGE_INDEX to { GardenFragment() },
        PLANT_LIST_PAGE_INDEX to { PlantListFragment() }
    )

    //ViewPager2의 사용할 페이지 수를 반환
    override fun getItemCount() = tabFragmentsCreators.size

    //ViewPager2 탭 레이아웃에  사용할 프레그먼트 생성
    override fun createFragment(position: Int): Fragment {
        //입력값으로 숫자(ViewPager의 페이지수? )를 입력
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}