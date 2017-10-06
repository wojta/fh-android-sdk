/**
 * Copyright Red Hat, Inc, and individual contributors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.feedhenry.sdk.android;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.NonNull;
import com.feedhenry.sdk.sync.FHSyncListener;
import com.feedhenry.sdk.sync.FHSyncUtils;

/**
 * Created on 9/20/17.
 */
public abstract class FHSyncServiceConnection implements ServiceConnection {

    private FHSyncService service;
    private Context context;

    public FHSyncServiceConnection(Context context) {
        this.context = context;
    }

    /**
     * Called when client is bound to service.
     *
     * @param service service
     */
    public void onServiceConnected(FHSyncService service) {
        this.service = service;
    }

    public void onServiceDisconnected() {
        this.service = null;
    }

    /**
     * Is it connected to the service?
     *
     * @return true=service is connected, false=service is not connected or failed
     */
    public final boolean isConnected() {
        return this.service != null;
    }

    /**
     * Calls action on service.
     *
     * @param action action to be called
     *
     * @return true=action was called, false=service is not connected or failed
     */
    public boolean call(FHSyncUtils.Action1<FHSyncService> action) {
        if (service != null) {
            action.doAction(service);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Unbinds service and unregisters listener.
     *
     * @param listener registered listener
     */
    public void unbindAndUnregister(@NonNull FHSyncListener listener) {
        if (service != null && context != null) {
            service.unregisterListener(listener);
            context.unbindService(this);
        }
    }

    @Override
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        onServiceConnected(((FHSyncService.FHSyncBinder) iBinder).getService());
    }

    @Override
    public final void onServiceDisconnected(ComponentName componentName) {
        context = null;
        onServiceDisconnected();
    }

    @Override
    public final void onBindingDied(ComponentName name) {
        context = null;
        this.service = null;
    }
}
