package com.tms.mcq.framework.exception;

import com.tms.mcq.framework.utils.MessageCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.dao.DataAccessException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Exception is categorized according to use case
 */
@Data
public class TMSException extends RuntimeException {
   private ErrorCode code;
   private boolean isRecoverable;
   private String causeInfo;

   public TMSException(String message){
      super(message);
   }

   public TMSException(ErrorCode code,String message,String causeInfo){
      super(message);
   }
}
