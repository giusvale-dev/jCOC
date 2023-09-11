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

public class BadgeUrl {

    private String small;
    private String large;
    private String medium;
    private String tiny;

    public BadgeUrl() {

    }

    /**
     * @return the tiny
     */
    public String getTiny() {
        return tiny;
    }

    /**
     * @param tiny the tiny to set
     */
    public void setTiny(String tiny) {
        this.tiny = tiny;
    }

    /**
     * @return the small
     */
    public String getSmall() {
        return small;
    }

    /**
     * @param small the small to set
     */
    public void setSmall(String small) {
        this.small = small;
    }

    /**
     * @return the large
     */
    public String getLarge() {
        return large;
    }

    /**
     * @param large the large to set
     */
    public void setLarge(String large) {
        this.large = large;
    }

    /**
     * @return the medium
     */
    public String getMedium() {
        return medium;
    }

    /**
     * @param medium the medium to set
     */
    public void setMedium(String medium) {
        this.medium = medium;
    }


    

}
