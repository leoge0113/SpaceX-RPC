/*
 * Copyright (c) 2015 The Jupiter Project
 *
 * Licensed under the Apache License, version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cainiao.transport.processor;

import com.cainiao.transport.Status;
import com.cainiao.transport.channel.SChannel;
import com.cainiao.transport.payload.JRequestBytes;


/**
 * Provider's processor.
 *

  transport.processor
 *

 */
public interface ProviderProcessor {

    /**
     * 处理正常请求
     */
    void handleRequest(SChannel channel, JRequestBytes request) throws Exception;

    /**
     * 处理异常
     */
    void handleException(SChannel channel, JRequestBytes request, Status status, Throwable cause);
}
