package com.zanguetsuinc.gasja_api.api.exceptionHandler;

import java.time.OffsetDateTime;
import java.util.List;

public record ErrorMessage(
   OffsetDateTime timestamp,
   int status,
   String error,
   List<String> messages
) {
}
