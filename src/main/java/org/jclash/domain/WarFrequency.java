/*
 * Copyright 2023 Giuseppe Valente<valentepeppe@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.jclash.domain;

import com.fasterxml.jackson.annotation.JsonValue;

public enum WarFrequency {
    
    UNKNOWN                     ("unknown"), 
    ALWAYS                      ("always"), 
    MORE_THAN_ONCE_PER_WEEK     ("moreThanOncePerWeek"), 
    ONCE_PER_WEEK               ("oncePerWeek"),  
    LESS_THAN_ONCE_PER_WEEK     ("lessThanOncePerWeek"),
    NEVER                       ("never"), 
    ANY                         ("any");

    private String frequency;

    private WarFrequency(String frequency) {
        this.frequency = frequency;
    }

    /**
     * @return the frequency
     */
    @JsonValue
    public String getFrequency() {
        return frequency;
    }

    /**
     * @param frequency the frequency to set
     */
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    

}
