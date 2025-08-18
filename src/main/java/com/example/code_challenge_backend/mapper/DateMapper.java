package com.example.code_challenge_backend.mapper;

import org.mapstruct.Mapper;
import java.time.OffsetDateTime;
import java.sql.Timestamp;

@Mapper(componentModel = "spring")
public interface DateMapper {

    default OffsetDateTime asOffsetDateTime(Timestamp ts) {
        return ts != null ? ts.toInstant().atOffset(java.time.ZoneOffset.UTC) : null;
    }

    default Timestamp asTimestamp(OffsetDateTime odt) {
        return odt != null ? Timestamp.from(odt.toInstant()) : null;
    }
}
