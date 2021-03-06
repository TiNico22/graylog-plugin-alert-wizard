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

package com.airbus_cyber_security.graylog.alert.rest.models.responses;

import com.airbus_cyber_security.graylog.alert.AlertRuleStream;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.joda.time.DateTime;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.util.Map;

@AutoValue
@JsonAutoDetect
public abstract class GetDataAlertRule {

	@JsonProperty("title")
	@NotNull
	public abstract String getTitle();
	
	@JsonProperty("title_condition")
	@NotNull
	public abstract String getTitleCondition();

	@JsonProperty("severity")
	@Nullable
	public abstract String getSeverity();

	@JsonProperty("condition")
	@Nullable
	public abstract String getConditionID();

	@JsonProperty("notification")
	@Nullable
	public abstract String getNotificationID();

	@JsonProperty("created_at")
	@Nullable
	public abstract DateTime getCreatedAt();

	@JsonProperty("creator_user_id")
	@Nullable
	public abstract String getCreatorUserId();

	@JsonProperty("last_modified")
	@Nullable
	public abstract DateTime getLastModified();

    @JsonProperty("disabled")
    public abstract boolean getIsDisabled();

    @JsonProperty("description")
    @Nullable
    public abstract String getDescription();

    @JsonProperty("alert_count")
    public abstract long getAlertCount();

    @JsonProperty("condition_type")
    @Nullable
    public abstract String getConditionType();
    
    @JsonProperty("condition_parameters")
    @Nullable
    public abstract Map<String, Object> conditionParameters();
    
    @JsonProperty("stream")
    @Nullable
    public abstract AlertRuleStream getStream();
    
    @JsonProperty("second_stream")
    @Nullable
    public abstract AlertRuleStream getSecondStream();
    
	@JsonCreator
	public static GetDataAlertRule create(@JsonProperty("title") String title,
										  @JsonProperty("title_condition") String titleCondition,
                                          @JsonProperty("severity") String severity,
                                          @JsonProperty("condition") String conditionID,
                                          @JsonProperty("notification") String notificationID,
                                          @JsonProperty("created_at") DateTime createdAt,
                                          @JsonProperty("creator_user_id") String creatorUserId,
                                          @JsonProperty("created_at") DateTime lastModified,
                                          @JsonProperty("disabled") boolean isDisabled,
                                          @JsonProperty("description") String description,
                                          @JsonProperty("alert_count") long alertCount,
                                          @JsonProperty("condition_type") String conditionType,
                                          @JsonProperty("condition_parameters") Map<String, Object> conditionParameters,
                                          @JsonProperty("stream") AlertRuleStream stream,
                                          @JsonProperty("second_stream") AlertRuleStream stream2) {
		return new AutoValue_GetDataAlertRule(title, titleCondition, severity, conditionID, notificationID, createdAt, creatorUserId,
                lastModified, isDisabled, description, alertCount, conditionType, conditionParameters, stream, stream2);
	}

}
