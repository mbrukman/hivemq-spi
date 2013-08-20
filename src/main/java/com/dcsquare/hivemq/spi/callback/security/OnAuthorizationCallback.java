/*
 * Copyright 2013 dc-square GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dcsquare.hivemq.spi.callback.security;

import com.dcsquare.hivemq.spi.callback.SynchronousCallback;
import com.dcsquare.hivemq.spi.security.ClientData;
import com.dcsquare.hivemq.spi.topic.MqttTopicPermission;

import java.util.List;

/**
 * This callback returns a list of {@link MqttTopicPermission}s.
 * <p/>
 * When more OnAuthorizationCallbacks are added only one must return
 * a permission, which matches the required permission to successfully
 * authorize the client action.
 * <p/>
 * It is <strong>highly</strong> recommended to use proper caching as this callback is
 * called every time HiveMQ asks for the client permissions.
 *
 * @author Christian Goetz
 * @since 1.4
 */
public interface OnAuthorizationCallback extends SynchronousCallback {

    /**
     * Returns a list of {@link MqttTopicPermission}s for this client.
     * <p/>
     * <strong>Make sure you use proper caching of the returned values as this method will be called very often</strong>
     *
     * @param clientData information about the client
     * @return a list of {@link MqttTopicPermission}s for the given client
     */
    public List<MqttTopicPermission> getPermissionsForClient(ClientData clientData);
}