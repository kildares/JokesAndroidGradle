package recipe.kildare.com.jokesandroidlib;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.JokeEndpointAsyncTask;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertNotSame;

/**
 * Created by kilda on 4/27/2018.
 */

@RunWith(AndroidJUnit4.class)

public class JokerEndpointAsyncTaskTest {

    @Test
    public void testAsyncTaskResponse(){

        JokeEndpointAsyncTask asyncTask = new JokeEndpointAsyncTask();
        //By using SDK 26, Android Studio identified I should use InstrumentationRegistry instead of AndroidTestCase
        Context context = InstrumentationRegistry.getTargetContext();
        String result = asyncTask.doInBackground(context);

        assertNotSame("",result);
    }

}
