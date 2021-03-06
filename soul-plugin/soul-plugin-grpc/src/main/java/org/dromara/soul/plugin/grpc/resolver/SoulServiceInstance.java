/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.dromara.soul.plugin.grpc.resolver;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Soul Service instance.
 *
 * @author zhanglei
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SoulServiceInstance {

    private String host;

    private int port;

    private Map<String, String> metadata;

    public SoulServiceInstance(final String host, final int port) {
        this(host, port, new HashMap<>());
    }

    /**
     * Get weight.
     *
     * @return int i
     */
    public int getWeight() {
        final String weightValue = metadata.get("weight");
        if (StringUtils.isEmpty(weightValue)) {
            return 0;
        }
        return Integer.parseInt(weightValue);
    }

    /**
     * Set weight.
     *
     * @param weight weight
     */
    public void setWeight(final int weight) {
        this.metadata.put("weight", String.valueOf(weight));
    }
}
