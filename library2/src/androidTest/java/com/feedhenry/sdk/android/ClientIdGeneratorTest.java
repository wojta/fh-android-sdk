package com.feedhenry.sdk.android;

import android.support.test.runner.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getContext;
import static junit.framework.Assert.*;
import static org.junit.Assert.assertNotEquals;

/**
 * Created on 9/20/17.
 */
@RunWith(AndroidJUnit4.class)
public class ClientIdGeneratorTest {

    @Test
    public void testIdQuality() {
        String id = new ClientIdGeneratorImpl(getContext()).getClientId();
        assertNotNull(id);
        assertNotEquals("", id);
        if (id.length() < 5) {
            fail("Implementation of ClientIdGeneratorImpl generates id with length < 5");
        }
    }

    @Test
    public void testIdConsistency() {
        String id1 = new ClientIdGeneratorImpl(getContext()).getClientId();
        String id2 = new ClientIdGeneratorImpl(getContext()).getClientId();
        assertEquals(id1, id2);
    }

}
