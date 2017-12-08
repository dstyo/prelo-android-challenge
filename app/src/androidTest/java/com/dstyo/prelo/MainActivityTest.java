package com.dstyo.prelo;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.dstyo.prelo.activity.main.MainActivity;
import com.dstyo.prelo.activity.main.MainViewModel;
import com.dstyo.prelo.base.MockWebServerTestRule;
import com.dstyo.prelo.base.PermissionRule;
import com.dstyo.prelo.base.TestEnvironmentRule;
import com.dstyo.prelo.model.login.DefaultAddress;
import com.dstyo.prelo.model.login.LoginData;
import com.dstyo.prelo.model.login.Profile;
import com.dstyo.prelo.util.Const;
import com.dstyo.prelo.utils.EspressoUtils;
import com.dstyo.prelo.utils.TestUtils;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;

/**
 * @author Dwi Setiyono <dwi.setiyono@ovo.id>
 * @since 2017.08.12
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public TestEnvironmentRule testEnvironmentRule = new TestEnvironmentRule();

    @Rule
    public MockWebServerTestRule mockWebServerRule = new MockWebServerTestRule();

    @Rule
    public PermissionRule permissionRule = new PermissionRule();

    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule = new IntentsTestRule<MainActivity>(MainActivity.class, true, false);

    @Mock
    public MainViewModel viewModel;

    private Context context;

    @Before
    public void setUp() throws Exception {
        context = InstrumentationRegistry.getTargetContext();
        init();
    }

    @Test
    public void testShouldShowProgressDuringFetchData() throws Exception {
        init();
        launchActivity();
        EspressoUtils.viewShowMatcher(R.id.list);
        onView(withId(R.id.list)).check(matches(isDisplayed()));
        onView(withId(R.id.progress)).check(matches(not(isDisplayed())));
    }

    @Test
    public void testShouldSelectProductImage() throws Exception {
        init();
        launchActivity();
        EspressoUtils.viewShowMatcher(R.id.list);
        onView(withId(R.id.list))
                .perform(RecyclerViewActions.actionOnItemAtPosition(3, ViewActions.scrollTo()));
        onView(withId(R.id.list)).check(matches(isDisplayed())).perform(ViewActions.click());
    }

    @Test
    public void testShouldDisplayListAfterReload() throws Exception {
        init();
        launchActivity();
        EspressoUtils.viewShowMatcher(R.id.list);
        onView(withId(R.id.list)).check(matches(isDisplayed()));
    }

    private void launchActivity() {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(Const.LOGIN, getDummyLoginData());
        intentsTestRule.launchActivity(intent);
    }

    private LoginData getDummyLoginData() {
        LoginData loginData = new LoginData();
        loginData.setFullname("Dwi Setiyono");
        loginData.setEmail("dstyo91@gmail.com");
        loginData.setProfile(getDummyProfile());
        loginData.setDefaultAddress(getDummyDefaultAddress());
        return loginData;
    }

    private DefaultAddress getDummyDefaultAddress() {
        DefaultAddress defaultAddress = new DefaultAddress();
        defaultAddress.setProvinceName("Jawa Barat");
        defaultAddress.setRegionName("Bandung");
        defaultAddress.setSubdistrictName("Cilame");
        return defaultAddress;
    }

    private Profile getDummyProfile() {
        Profile profile = new Profile();
        profile.setPict("https://media-exp2.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAOdAAAAJDhkNGYyZjQ3LTNmNWUtNDlmYi1iY2QwLTkxYmIyNGY5NTM5NQ.jpg");
        return profile;
    }

    private void init() throws Exception {
        mockWebServerRule.mock(EspressoUtils.recordedRequestMatcher("/me/lovelist"), 200,
                TestUtils.readAsset("response_product_list.json"), null);
        mockWebServerRule.mock(EspressoUtils.recordedRequestMatcher("/auth/login"), 200,
                TestUtils.readAsset("response_profile.json"), null);
    }

}
