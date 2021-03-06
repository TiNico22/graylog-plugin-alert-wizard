/*
 * graylog-plugin-alert-wizard Source Code
 * Copyright (C) 2018-2020 - Airbus CyberSecurity (SAS) - All rights reserved
 *
 * This file is part of the graylog-plugin-alert-wizard GPL Source Code.
 *
 * graylog-plugin-alert-wizard Source Code is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this code.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.airbus_cyber_security.graylog.config.rest;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.graylog2.database.CollectionName;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

@AutoValue
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
@CollectionName("default_values")
public abstract  class DefaultValues {

	@JsonProperty("title")
	@Nullable
    public abstract String getTitle();
	
	@JsonProperty("severity")
	@Nullable
    public abstract String getSeverity();
	
    @JsonProperty("matching_type")
    @NotNull
    public abstract String getMatchingType();
    
    @JsonProperty("threshold_type")
    @NotNull
    public abstract String getThresholdType();

    @JsonProperty("threshold")
    public abstract int getThreshold();

    @JsonProperty("time")
    public abstract int getTime();
    
    @JsonProperty("time_type")
    public abstract int getTimeType();
    
    @JsonProperty("field")
    @Nullable
    public abstract String getField();

    @JsonProperty("field_type")
    public abstract int getFieldType();

    @JsonProperty("field_value")
    @Nullable
    public abstract String getFieldValue();
    
    @JsonProperty("grace")
    public abstract int getGrace();
    
    @JsonProperty("backlog")
    public abstract int getBacklog();

    @JsonCreator
    public static DefaultValues create(@JsonProperty("title") String title,
    		@JsonProperty("severity") String severity,
    		@JsonProperty("matching_type") String matchingType,
    		@JsonProperty("threshold_type") String thresholdType,
    		@JsonProperty("threshold") int threshold,
    		@JsonProperty("time") int time,
    		@JsonProperty("time_type") int timeType,
			@JsonProperty("field") String field,
            @JsonProperty("field_type") int fieldType,
            @JsonProperty("field_value") String fieldValue,
            @JsonProperty("grace") int grace,
            @JsonProperty("backlog") int backlog){
        return new AutoValue_DefaultValues(title, severity, matchingType, thresholdType, threshold, time, timeType, 
        		field, fieldType, fieldValue, grace, backlog);
    }
}
