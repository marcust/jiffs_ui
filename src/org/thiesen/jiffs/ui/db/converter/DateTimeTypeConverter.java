package org.thiesen.jiffs.ui.db.converter;

import org.joda.time.DateTime;
import org.thiesen.troy.conversion.TypeConverter;

public class DateTimeTypeConverter implements
		TypeConverter<DateTime, Long> {

	@Override
	public Class<DateTime> getFieldType() {
		return DateTime.class;
	}

	@Override
	public Class<Long> getConvertedType() {
		return Long.class;
	}

	@Override
	public Long convertFieldValue(DateTime fieldValue) {
		return Long.valueOf( fieldValue.getMillis() );
	}

	@Override
	public DateTime convertDatabaseValue(Long dbValue) {
		return new DateTime( dbValue.longValue() );
	}

}
